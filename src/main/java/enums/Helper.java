package enums;

public class Helper {

    public static String URL, User, Password,Id;

    /*
     *
     * This Method Return NMS URL
     * */
    public static String getURL() {
        if (System.getProperty("url") != null) {
            System.out.println(" URL==> " + System.getProperty("url"));
            URL = System.getProperty("url");
        } else {
            URL = Constants.TEST_URL.getValue();
        }

        return URL;
    }


    /*
     *
     * This Method Return NMS User ID
     * */
    public static String getUser() {
        if (System.getProperty("username") != null) {
            System.out.println("NMS Username ==> " + System.getProperty("username"));
            User = System.getProperty("username");
        } else {
            User = TestData.USERNAME.getValue();
        }
        return User;
    }

    /*
     * This Method Return NMS user password
     * */
    public static String getPassword() {
        if (System.getProperty("password") != null) {
            System.out.println("NMS Password ==> " + System.getProperty("password"));
            Password = System.getProperty("password");
        } else {
            Password = TestData.PASSWORD.getValue();
        }
        return Password;
    }
    public static String getId() {
        if (System.getProperty("ID") != null) {
            System.out.println("ID ==> " + System.getProperty("ID"));
            Id = System.getProperty("ID");
        } else {
            Id = TestData.ID_Clu.getValue();
        }
        return Id;
    }

    /*
     * This Method Return NHM URL
     * */

    /*
     * This Method Return DB hostname
     * */
//    public static String getdbHost() {
//        if (System.getProperty("dbhost") != null) {
//            System.out.println("Oracle DB Hostname ==> " + System.getProperty("dbhost"));
//            dbHost = System.getProperty("dbhost");
//        } else {
//            dbHost = Constants.DB_HOST.getValue();
//        }
//        return dbHost;
//    }
//
//    /*
//     * This Method Return DB name
//     * */
//    public static String getdbName() {
//        dbName = TestData.DB_NAME.getValue();
//        return dbName;
//    }
//
//    /*
//     * This Method Return DB user
//     * */
//    public static String getdbUser() {
//        dbUser = TestData.DB_USER.getValue();
//        return dbUser;
//    }
//
//    /*
//     * This Method Return DB password
//     * */
//    public static String getdbPass() {
//        dbPass = TestData.DB_PASS.getValue();
//        return dbPass;
//    }

    /*
     * This Method Return weblct URL
     * */

}
