package Homework.ClientService;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Customer {
    public static void main(String[] args) {
        String host = "localhost";
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(host + ", ip address: " + inetAddress.getHostAddress());
    }
}
