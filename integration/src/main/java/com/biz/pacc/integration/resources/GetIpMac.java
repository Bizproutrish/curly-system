package com.biz.pacc.integration.resources;

	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class GetIpMac {

	    public static String GetAddress(String addressType) {
	        String address = "";
	        InetAddress lanIp = null;
	        try {

	            String ipAddress = null;
	            Enumeration<NetworkInterface> net = null;
	            net = NetworkInterface.getNetworkInterfaces();

	            while (net.hasMoreElements()) {
	                NetworkInterface element = net.nextElement();
	                Enumeration<InetAddress> addresses = element.getInetAddresses();

	                while (addresses.hasMoreElements() && !isVMMac(element.getHardwareAddress())) {
	                    InetAddress ip = addresses.nextElement();
	                    if (ip instanceof Inet4Address) {

	                        if (ip.isSiteLocalAddress()) {
	                            ipAddress = ip.getHostAddress();
	                            lanIp = InetAddress.getByName(ipAddress);
	                        }

	                    }

	                }
	            }

	            if (lanIp == null)
	                return null;

	            if (addressType.equals("ip")) {

	                address = lanIp.toString().replaceAll("^/+", "");

	            } else if (addressType.equals("mac")) {

	                address = getMacAddress(lanIp);

	            } else {

	                throw new Exception("Specify \"ip\" or \"mac\"");

	            }

	        } catch (UnknownHostException ex) {

	            ex.printStackTrace();

	        } catch (SocketException ex) {

	            ex.printStackTrace();

	        } catch (Exception ex) {

	            ex.printStackTrace();

	        }

	        return address;

	    }

	    private static String getMacAddress(InetAddress ip) {
	        String address = null;
	        try {

	            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
	            byte[] mac = network.getHardwareAddress();

	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < mac.length; i++) {
	                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
	            }
	            address = sb.toString();

	        } catch (SocketException ex) {

	            ex.printStackTrace();

	        }

	        return address;
	    }

	    private static boolean isVMMac(byte[] mac) {
	        if(null == mac) return false;
	        byte invalidMacs[][] = {
	                {0x00, 0x05, 0x69},             //VMWare
	                {0x00, 0x1C, 0x14},             //VMWare
	                {0x00, 0x0C, 0x29},             //VMWare
	                {0x00, 0x50, 0x56},             //VMWare
	                {0x08, 0x00, 0x27},             //Virtualbox
	                {0x0A, 0x00, 0x27},             //Virtualbox
	                {0x00, 0x03, (byte)0xFF},       //Virtual-PC
	                {0x00, 0x15, 0x5D}              //Hyper-V
	        };

	        for (byte[] invalid: invalidMacs){
	            if (invalid[0] == mac[0] && invalid[1] == mac[1] && invalid[2] == mac[2]) return true;
	        }

	        return false;
	    }
	    
	    Pattern macpt = null;

	    public String getMac(String ip) {

	        // Find OS and set command according to OS
	        String OS = System.getProperty("os.name").toLowerCase();

	        String[] cmd;
	        if (OS.contains("win")) {
	            // Windows
	            macpt = Pattern
	                    .compile("[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+");
	            String[] a = { "arp", "-a", ip };
	            cmd = a;
	        } else {
	            // Mac OS X, Linux
	            macpt = Pattern
	                    .compile("[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+");
	            String[] a = { "arp", ip };
	            cmd = a;
	        }

	        try {
	            // Run command
	            Process p = Runtime.getRuntime().exec(cmd);
	            p.waitFor();
	            // read output with BufferedReader
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    p.getInputStream()));
	            String line = reader.readLine();

	            // Loop trough lines
	            while (line != null) {
	                Matcher m = macpt.matcher(line);

	                // when Matcher finds a Line then return it as result
	                if (m.find()) {
	                    System.out.println("Found");
	                    System.out.println("MAC: " + m.group(0));
	                    return m.group(0);
	                }

	                line = reader.readLine();
	            }

	        } catch (IOException e1) {
	            e1.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Return empty string if no MAC is found
	        return "";
	    }

	}
