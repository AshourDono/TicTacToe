/*
    This is an abstract class that includes configuration variables
    as well as helper functions for the server 
 */
//#============================================================================#
//#                 Abstract send / reterive data from database                #
//#============================================================================#
package server.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author Mh.El3basy
 */
public abstract class ServerUtils {

    public static final int PORT_NUMBER = 7777;
    public static final String logsFilePath = "logs.txt";

    public static Boolean clearLog(Boolean statusFlag) {
        File logsFile = new File(logsFilePath);
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        Date d = new Date();
        if (logsFile.exists()) {
            try {
                fileWriter = new FileWriter(logsFile, false);
                printWriter = new PrintWriter(fileWriter);
                if (statusFlag) {
                    printWriter.println("[ " + d.toString() + " ] :  " + "Server is Running");
                } else {
                    printWriter.println("[ " + d.toString() + " ] :  " + "Server is Stopped");
                }
                fileWriter.close();
                return true;
            } catch (IOException io) {
                 System.out.println("Error in server utils clearLog  : " + io.getMessage());
                return false;
            }
        } else {
            return false;
        }

    }

    public static Boolean appendLog(String logStr) {
        File logsFile = new File(logsFilePath);
        BufferedWriter out = null;
        Date d = new Date();

        try {

            if (logsFile != null) {

                out = new BufferedWriter(new FileWriter(logsFile, true));
                out.write("[ " + d.toString() + " ] :  " + logStr + "\n");

            } else {
//                File not found case
                if (logsFile.createNewFile()) {

                    out = new BufferedWriter(new FileWriter(logsFile, true));
                    out.write("[ " + d.toString() + " ] :  " + logStr + "\n");
                }
            }

            out.close();
            return true;
        } catch (IOException io) {
             System.out.println("Error in server utils appendLog  : " + io.getMessage());
            return false;
        }
    }

}
