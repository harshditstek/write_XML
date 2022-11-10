package org.example.beans;

import com.ibm.as400.access.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class iSeries {
    private static final String DRIVER = "com.ibm.as400.access.AS400JDBCDriver";
    private static final String SERVER = "printers.hi-techhealth.com";
    private static final String URL = "jdbc:as400://printers.hi-techhealth.com";
    //private static final String HOSTNAME = "JAVA2018";
    private static final String HOSTNAME = "JAVALOOK";
    private static final String PASSWORD = "TWMC1990";
    private static AS400 system = null;
    private static String IBM_CHARSET = "IBM285";

    public static List<String[]> executeSQLByAlias(String sql, String alias, String file) {
        String aliasSQL = "CREATE ALIAS " + alias + " FOR " + file;
        List<String[]> resultList = new ArrayList<>();
        String[] result;
        Statement statement;
        ResultSet resultSet;
        ResultSetMetaData resultSetMetaData;
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, HOSTNAME, PASSWORD);
            statement = connection.createStatement();
            statement.execute(aliasSQL);

            if (sql.substring(0, 6).equalsIgnoreCase("SELECT")) {
                resultSet = statement.executeQuery(sql);
                resultSetMetaData = resultSet.getMetaData();

                while (resultSet.next()) {
                    result = new String[resultSetMetaData.getColumnCount()];
                    for (int idx = 0; idx < result.length; idx++) {
                        result[idx] = resultSet.getString(idx + 1);
                    }
                    resultList.add(result);
                }
            } else {
                String rowCount = Integer.toString(statement.executeUpdate(sql));
                result = new String[]{rowCount};
                resultList.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return resultList;
    }

    public static String generatePatientResponsibility(String member, String claimNum) {
        // Define the CL program.
        String programName = "/QSYS.lib/HTHOBJV1.lib/GETPTRC.pgm";

        // Define the output as empty.
        String output = "";

        // Declare the parameters data.
        byte[] memData, claimNumData, outputData;

        // Declare the array of parameters that is needed.
        ProgramParameter[] params;

        // Declare the CL Programs Call instance.
        ProgramCall programCall;

        try {
            // Check if system is not initialized.
            if (system == null) {
                system = new AS400(SERVER, HOSTNAME, PASSWORD);
            }

            // Initialize the array of parameters. Size of 3 because the CL called takes in 3 parameters (2 INPUT, 1 OUTPUT).
            params = new ProgramParameter[3];

            // Initialize INPUT parameter values. Convert the input string to IBM_CHARSET byte[].
            memData = member.getBytes(IBM_CHARSET);
            claimNumData = claimNum.getBytes(IBM_CHARSET);

            // Initialize each parameter that is passed to CL program.
            params[0] = new ProgramParameter(memData);
            params[1] = new ProgramParameter(claimNumData);
            params[2] = new ProgramParameter(9);

            // Initialize Program Call instance.
            programCall = new ProgramCall(system);
            programCall.setProgram(programName, params); // Set the program and parameters.

            // Check if the program is successfully called.
            if (programCall.run()) {
                // Get the output data and convert back to JAVA string to return.//break
                outputData = params[2].getOutputData();
                output = new String(outputData, IBM_CHARSET).trim();
            } else {
                // Print error messages regarding the program.
                AS400Message[] messageList = programCall.getMessageList();
                for (AS400Message message : messageList) {
                    String msg = message.getID() + " - " + message.getText();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                system.disconnectAllServices();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Validate the output by knowing the output must be 9 characters.
        if (output.length() < 9) {
            return "";
        } else {
            //change the output the wanted
            output = output.substring(0, 7) + "." + output.substring(7);
            double amount = Double.parseDouble(output);
            /// NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
            return String.valueOf(amount);
        }
    }

    public static String[] getSingleRecord(String sql, String alias, String file) {
        String aliasSQL = "CREATE ALIAS " + alias + " FOR " + file;
        String[] result = null;
        Statement statement;
        ResultSet resultSet;
        ResultSetMetaData resultSetMetaData;
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, HOSTNAME, PASSWORD);
            statement = connection.createStatement();
            statement.execute(aliasSQL);

            if (sql.substring(0, 6).equalsIgnoreCase("SELECT")) {
                resultSet = statement.executeQuery(sql);
                resultSetMetaData = resultSet.getMetaData();

                while (resultSet.next()) {
                    result = new String[resultSetMetaData.getColumnCount()];
                    for (int idx = 0; idx < result.length; idx++) {
                        result[idx] = resultSet.getString(idx + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return result;
    }
}
