package org.example.beans;

import org.example.record.CreateXmlFileDemo;

import java.util.ArrayList;
import java.util.List;

public class CLMHDR {

    public static List<String[]> searchHeaderGroup(String groupNo, String date) {
        String alias = "QTEMP.CLMHDR";
        String file = "testdata.CLMHDR(TRT)";
        String sql = "SELECT HASSGN,HPROVD,HSSN,HCLMNO,HPRODT" +
                ",HTOTCL,HDISC,HTOTAL,HTOTDD,HCOPAY,HTOTCO,HFILL6 FROM QTEMP.CLMHDR where HGRPNO = '" + groupNo + "' and HCHKDT = '"+ date +"' LIMIT 1";
        List<String[]> resultList = iSeries.executeSQLByAlias(sql, alias, file);
        return resultList;
    }

    public static List<String[]> searchProvider(String groupNo, String date) {
        List<String[]> clmnotList = new ArrayList<String[]>();
        List<String[]> insureList = new ArrayList<String[]>();
        List<String[]> headerGroup = searchHeaderGroup(groupNo, date);
        List<String[]> providerList = new ArrayList<String[]>();
        List<String[]> clmdetList = new ArrayList<String[]>();
        String[] result;
        String pprovn = "";
        String hassgn = "";
        String ssn = "";
        String hclmno = "";
        for(int i=0;i<headerGroup.size();i++) {
            result = headerGroup.get(i);
            hassgn = result[0].trim();
            pprovn = result[1].trim();
            ssn = result[2].trim();
            hclmno = result[3].trim();
            System.out.println("hcl:"+hclmno);
            if (hassgn.equalsIgnoreCase("Y")) {
                providerList = getProvider(pprovn);

                //mainList.add(resultList);
            } else {

            }
            if(!hclmno.equals("")){
                clmnotList = getClmnot(hclmno);
            }
            if(!ssn.equals("")){
                insureList = getInsure(ssn);
            }
            clmdetList = getClmdet(hclmno);
        }
        CreateXmlFileDemo.writeXml(providerList, clmnotList, insureList, headerGroup, clmdetList);
        System.out.println("size:"+providerList.size());
        System.out.println("clmn:"+clmnotList.size());
        System.out.println("ssn:"+insureList.size());
        return providerList;
    }

    public static List<String[]> getProvider(String pprovn) {

        String alias = "QTEMP.provdr";
        String file = "testdata.provdr(TRT)";
        String sql = "SELECT * FROM QTEMP.provdr where pprovn='"+ pprovn +"'";
        List<String[]> resultList = iSeries.executeSQLByAlias(sql, alias, file);
        System.out.println(resultList.size());

        return resultList;
       // return null;
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
        String sql = "select * from qtemp.clmdet where dclmno = '"+ hclmno +"' limit 1";
        List<String[]> resultData = iSeries.executeSQLByAlias(sql, alias, file);
        return resultData;
    }
}
