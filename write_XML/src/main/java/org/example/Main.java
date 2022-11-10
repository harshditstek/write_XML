package org.example;

import org.example.beans.CLMHDR;

public class Main {

    public static String member = "";
    public static String hgrpNo = "";
    public static String hchkdt = "";
    public static void main(String[] args) {
        System.out.println("Please Wait!");
        if (args.length == 3) {
            member = args[0];
            hgrpNo = args[1];
            hchkdt = args[2];
            CLMHDR.searchProvider(hgrpNo, hchkdt);
        }else{
            System.out.println("Please Enter parameter");
            System.exit(0);
        }
    }
}