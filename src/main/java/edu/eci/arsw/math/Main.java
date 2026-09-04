/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void stopat5 () {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            PiThread.tellEverybody();
        }
    }

    public static void main(String a[]) throws InterruptedException {
        int N = 10;

        Runnable runble = Main::stopat5;
        Thread stopt = new Thread(runble);
        stopt.setDaemon(true);
        stopt.start();

        System.out.println(bytesToHex(PiDigits.getDigits(0, 10, N)));
        System.out.println(bytesToHex(PiDigits.getDigits(1, 100, N)));
        System.out.println(bytesToHex(PiDigits.getDigits(1, 1000, N)));
        System.out.println(bytesToHex(PiDigits.getDigits(1, 10000, N)));
        System.out.println(bytesToHex(PiDigits.getDigits(1, 100000, N)));
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            sb.append(hexChars[i+1]);            
        }
        return sb.toString();
    }
}
