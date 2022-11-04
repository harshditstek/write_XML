package org.example;

public class Main {
    public static void main(String[] args) {
        String hgrpNo = "";
        String hchkdt = "";
        if (args.length == 2) {
            hgrpNo = args[0];
            hchkdt = args[1];
            System.out.println(hgrpNo);
            System.out.println(hchkdt);
        }else{
            System.out.println("Please Enter parameter");
            System.exit(0);
        }
    }
}