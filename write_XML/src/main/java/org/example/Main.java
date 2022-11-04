package org.example;

import org.example.beans.CLMHDR;

public class Main {
    public static void main(String[] args) {
        String hgrpNo = "";
        String hchkdt = "";
        if (args.length == 2) {
            hgrpNo = args[0];
            hchkdt = args[1];
            System.out.println(hgrpNo);
            System.out.println(hchkdt);
            CLMHDR.searchProvider(hgrpNo, hchkdt);
        }else{
            System.out.println("Please Enter parameter");
            System.exit(0);
        }
    }
}