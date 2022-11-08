package org.example.beans;

import org.example.record.CreateXmlFileDemo;

import java.util.List;

public class CLMHDR {
    public static List<String[]> searchHeaderGroup(String groupNo, String date) {
        String alias = "QTEMP.CLMHDR";
        String file = "testdata.CLMHDR(TRT)";
        String sql = "SELECT HASSGN,HPROVD,HSSN,HCLMNO,HPRODT" +
                ",HTOTCL,HDISC,HTOTAL,HTOTDD,HCOPAY,HTOTCO,HFILL6 FROM QTEMP.CLMHDR where HGRPNO = '" + groupNo + "' and HCHKDT = '"+ date +"'";
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

    public static List<String[]> getProvider(String pprovn) {
        String alias = "QTEMP.provdr";
        String file = "testdata.provdr(TRT)";
        String sql = "SELECT * FROM QTEMP.provdr where pprovn='"+ pprovn +"'";
        List<String[]> resultList = iSeries.executeSQLByAlias(sql, alias, file);

        return resultList;
    }

    public static List<String[]> getClmnot(String nclmno) {
        String alias = "QTEMP.clmnot";
        String file = "testdata.clmnot(TRT)";
        String sql = "SELECT * FROM QTEMP.clmnot where nclmno='"+ nclmno +"'";
        List<String[]> resultList = iSeries.executeSQLByAlias(sql, alias, file);

        return resultList;
    }

    public static List<String[]> getInsure(String issn){
        String alias =  "QTEMP.INSURE";
        String file = "testdata.INSURE(TRT)";
        String sql = "SELECT * FROM QTEMP.INSURE where ISSN = '"+ issn +"'";
        List<String[]> resultData = iSeries.executeSQLByAlias(sql, alias, file);

        return resultData;
    }

    public static List<String[]> getClmdet(String hclmno){
        String alias =  "QTEMP.clmdet";
        String file = "testdata.clmdet(TRT)";
        String sql = "select * from qtemp.clmdet where dclmno = '"+ hclmno +"'";
        List<String[]> resultData = iSeries.executeSQLByAlias(sql, alias, file);

        return resultData;
    }
}
