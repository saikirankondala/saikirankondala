package util;

import enums.Helper;
import org.testng.Reporter;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class NMSDatabaseHelper {

//    private final static String host = Helper.getdbHost();
//    private final static String dbName = Helper.getdbName();
//    private final static String user = Helper.getdbUser();
//    private final static String pass = Helper.getdbPass();
//
//    private static Connection connection;
//
//    /**
//     * This method indicates to start a connection to database
//     */
//    public static void connectToDataBase() {
//        try {
//            Reporter.log("db_host =====> " + host, true);
//            Reporter.log("db_Name =====> " + dbName, true);
//            Reporter.log("db_user =====> " + user, true);
//            Reporter.log("db_pass =====> " + pass, true);
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            connection = DriverManager.getConnection(host + dbName, user, pass);
//            Reporter.log("=====> Database Connection Established Successfully!", true);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String nhmServerLoadCpuCount() {
//        String cpucount = null;
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT CPU_COUNT  FROM NHM_SERVER_LOAD");
//
//            while (resultSet.next()) {
//                cpucount = resultSet.getString(1);
//            }
//
//            Reporter.log("=====> CPU COUNT from DB: " + cpucount, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cpucount;
//    }
//
//
//    /*
//     * This Method query NHM Disk Usage Table data and return
//     * arraylist
//     */
//
//    public static ArrayList<String> fetchNHMDiskUsageTableData() {
//
//        ArrayList<String> diskUsageTableData = new ArrayList<>();
//        if (connection == null)
//            connectToDataBase();
//
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt
//                    .executeQuery("SELECT FILESYSTEM,USED,AVAILABLE,USAGE_PERC,MOUNTED_ON FROM NHM_DISK_STORAGE");
//            while (rs.next()) {
//                diskUsageTableData.add(rs.getString(1));
//                diskUsageTableData.add(rs.getString(2));
//                diskUsageTableData.add(rs.getString(3));
//                diskUsageTableData.add(rs.getString(4));
//                diskUsageTableData.add(rs.getString(5));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return diskUsageTableData;
//    }
//
//    /*
//     * This Method query NHM failed checklist data and return
//     * arraylist
//     */
//    public static ArrayList<String> fetchNHMFailedChecklist() {
//        ArrayList<String> fetchNHMFailedChecklist = new ArrayList<>();
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT CHECK_NAME FROM NHM_CHECKLIST WHERE CHECK_RESULT='KO'");
//
//            while (resultSet.next()) {
//                fetchNHMFailedChecklist.add(resultSet.getString(1).replaceAll("_", " ").replaceAll(" ", "").toUpperCase());
//            }
//            Reporter.log("=====> NHM Failed Checklist from DB: " + fetchNHMFailedChecklist, true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return fetchNHMFailedChecklist;
//    }
//
//    /*
//     * Fetching NHM Application Start and Stop Time
//     * */
//    public static String NHM_Start_Stop_Time() {
//        String formattedDate = null;
//        String time = "";
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT MAX(TIMESTAMP) FROM NHM_PLATFORM_RESTARTS WHERE ADD_TYPE =1 ORDER BY TIMESTAMP DESC");
//
//            while (resultSet.next()) {
//                time = resultSet.getString(1);
//            }
//            Date nhmplatformTime = new Date((Long.valueOf(time)) * 1000);
//            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d yyyy, hh:mm:ss", Locale.ENGLISH);
//            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//            formattedDate = sdf.format(nhmplatformTime);
//            Reporter.log("=====> NHM Start Stop Time from DB: " + formattedDate, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return formattedDate;
//    }
//
//    /*
//     * Fetching NHM Server Load checklist cpu count
//     * */
//    public static String VerifyCountWithOperationType() {
//        String cpucount = null;
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT count(*) FROM TMN_TRANSACTION_LOG ttl WHERE (category >= 0 AND category <= 100) AND OPERATION = 0");
//
//            while (resultSet.next()) {
//                cpucount = resultSet.getString(1);
//            }
//
//            Reporter.log("=====> Log COUNT from DB: " + cpucount, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cpucount;
//    }
//    public static String nhmServerTransactionCount() {
//        String cpucount = null;
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT count(*) FROM TMN_TRANSACTION_LOG ttl WHERE category >= 0 AND category <= 100");
//
//            while (resultSet.next()) {
//                cpucount = resultSet.getString(1);
//            }
//
//            Reporter.log("=====> Log COUNT from DB: " + cpucount, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cpucount;
//    }
//    public static String VerifyCountWithOperationType_USername_Mapname_ElementTypeAndInformation() {
//        String cpucount = null;
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT count(*) FROM TMN_TRANSACTION_LOG ttl WHERE (category >= 0 AND category <= 100) AND (((OPERATION >= 0 AND USERNAME ='nms5ux') AND ((MAP_NAME ='nms5ux') AND ELEMENT=29)) AND INFORMATION ='IP Address=172.26.60.244')");
//
//            while (resultSet.next()) {
//                cpucount = resultSet.getString(1);
//            }
//
//            Reporter.log("=====> Log COUNT from DB: " + cpucount, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cpucount;
//    }
//    public static String VerifyCountWithOperationType_USername_MapnameAndElementType() {
//        String cpucount = null;
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT * FROM TMN_TRANSACTION_LOG ttl WHERE (category >= 0 AND category <= 100) AND ((OPERATION >= 0 AND USERNAME ='nms5ux') AND ((MAP_NAME ='nms5ux') AND ELEMENT='29'))");
//
//            while (resultSet.next()) {
//                cpucount = resultSet.getString(1);
//            }
//
//            Reporter.log("=====> Log COUNT from DB: " + cpucount, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cpucount;
//    }
//    public static String VerifyCountWithOperationType_USernameAndMapname() {
//        String cpucount = null;
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT count(*) FROM TMN_TRANSACTION_LOG ttl WHERE (category >= 0 AND category <= 100) AND ((OPERATION >= 0 AND USERNAME ='nms5ux') AND MAP_NAME ='nms5ux')");
//
//            while (resultSet.next()) {
//                cpucount = resultSet.getString(1);
//            }
//
//            Reporter.log("=====> Log COUNT from DB: " + cpucount, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cpucount;
//    }
//    public static String VerifyCountWithOperationTypeAndUSername() {
//        String cpucount = null;
//        if (connection == null)
//            connectToDataBase();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("SELECT count(*) FROM TMN_TRANSACTION_LOG ttl WHERE (category >= 0 AND category <= 100) AND (OPERATION = 0 AND USERNAME ='nms5ux')");
//
//            while (resultSet.next()) {
//                cpucount = resultSet.getString(1);
//            }
//
//            Reporter.log("=====> Log COUNT from DB: " + cpucount, true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cpucount;
//    }
//    /*
//     * Fetching NMS System Daemon Checklist table data on NHM Application
//     * */
//    public static ArrayList<String> fetchNMSSystemDaemonTableData() {
//        ArrayList<String> systemDaemonTableData = new ArrayList<>();
//        if (connection == null)
//            connectToDataBase();
//
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt
//                    .executeQuery("SELECT DAEMON AS Name, STATUS from NHM_NMS_SYSTEM_DAEMON;");
//            while (rs.next()) {
//                systemDaemonTableData.add(rs.getString(1));
//                systemDaemonTableData.add(rs.getString(2));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return systemDaemonTableData;
//    }

}