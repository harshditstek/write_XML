package org.example.beans;

import org.example.Main;
import org.example.record.CreateXmlFileDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CLMHDR {
    public static List<String[]> searchHeaderGroup(String groupNo, String date) {
        String alias = "QTEMP.CLMHDR";
        String file = "testdata.CLMHDR("+ Main.member +")";
        String sql = "SELECT HASSGN,HPROVD,HSSN,HCLMNO,HPRODT" +
                ",HTOTCL,HDISC,HTOTAL,HTOTDD,HCOPAY,HTOTCO,HFILL6,HFILL7,HDEP FROM QTEMP.CLMHDR where HGRPNO = '" + groupNo + "' and HCHKDT = '"+ date +"'";
        List<String[]> resultList = iSeries.executeSQLByAlias(sql, alias, file);
        return resultList;
    }

    public static void searchProvider(String groupNo, String date) {
        List<String[]> headerGroup = searchHeaderGroup(groupNo, date);

        if(headerGroup.size() <1){
            System.out.println("Data not available");
        }

        CreateXmlFileDemo.writeXml(headerGroup);
    }

    public static String[] getProvider(String pprovn) {
        String alias = "QTEMP.provdr";
        String file = "testdata.provdr("+ Main.member +")";
        String sql = "SELECT * FROM QTEMP.provdr where pprovn='"+ pprovn +"'";
        String[] resultList = iSeries.getSingleRecord(sql, alias, file);

        return resultList;
    }

    public static List<String[]> getClmnot(String nclmno) {
        String alias = "QTEMP.clmnot";
        String file = "testdata.clmnot("+Main.member+")";
        String sql = "SELECT * FROM QTEMP.clmnot where nclmno='"+ nclmno +"'";
        List<String[]> resultList = iSeries.executeSQLByAlias(sql, alias, file);

        return resultList;
    }

//    public static List<String[]> getInsure(String issn){
//        String alias =  "QTEMP.INSURE";
//        String file = "testdata.INSURE("+Main.member+")";
//        String sql = "SELECT * FROM QTEMP.INSURE where ISSN = '"+ issn +"'";
//        List<String[]> resultData = iSeries.executeSQLByAlias(sql, alias, file);
//
//        return resultData;
//    }

    public static String[] getInsure(String issn){
        String alias =  "QTEMP.INSURE";
        String file = "testdata.INSURE("+Main.member+")";
        String sql = "SELECT IFNAM,ILNAM,IEMPID,IADD1,ICITY,ISTATE,IZIP FROM QTEMP.INSURE where ISSN = '"+ issn +"'";
        String[] resultData = iSeries.getSingleRecord(sql, alias, file);

        return resultData;
    }

    public static List<String[]> getClmdet(String hclmno){
        String alias =  "QTEMP.clmdet";
        String file = "testdata.clmdet("+Main.member+")";
        String sql = "select * from qtemp.clmdet where dclmno = '"+ hclmno +"'";
        List<String[]> resultData = iSeries.executeSQLByAlias(sql, alias, file);

        return resultData;
    }

    public static String[] getInsdep(String ssn){
        String alias =  "QTEMP.insdep";
        String file = "testdata.insdep("+Main.member+")";
        String sql = "select * from qtemp.insdep where dessn = '"+ ssn +"'";
        String[] resultData = iSeries.getSingleRecord(sql, alias, file);

        return resultData;
    }

    public static String getClaimNumber(String ncnot1){
        String lastWord ="";
        if (ncnot1.contains("ClaimBridge")) {
            lastWord = ncnot1.substring(ncnot1.lastIndexOf("# ") + 1);
            System.out.println(lastWord.trim());
        }
        return lastWord.trim();
    }

    public static String formattedDate(String processDate){
        String formattedProcessDate="";
        try {
            if(processDate.equals("")){
                return formattedProcessDate;
            }
            if (processDate.length() == 5) {
                processDate = "0" + processDate;
            }
            Date d = new SimpleDateFormat("MMddyy").parse(processDate);
            SimpleDateFormat d2 = new SimpleDateFormat("yyyyMMdd");
            formattedProcessDate = d2.format(d).toString();
        }catch (Exception e){

        }
        return formattedProcessDate;
    }
}
