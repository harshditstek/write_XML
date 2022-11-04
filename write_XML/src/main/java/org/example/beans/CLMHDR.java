package org.example.beans;

import java.util.List;

public class CLMHDR {

    public static List<String[]> search(String groupNo, String date) {
        String alias = "QTEMP.CLMHDR";
        String file = "testdata.CLMHDR(TRT)";
        String sql = "SELECT * FROM QTEMP.CLMHDR where HGRPNO = '" + groupNo + "' and HCHKDT = '"+ date +"' LIMIT 1";
        List<String[]> resultList = iSeries.executeSQLByAlias(sql, alias, file);
        System.out.println(resultList.size());

        return resultList;
    }
}
