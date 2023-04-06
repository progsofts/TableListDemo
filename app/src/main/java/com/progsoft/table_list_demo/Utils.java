package com.progsoft.table_list_demo;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class Utils {
    private static final String TAG = "Utils";
    public static final String LOG_FILEPATH = "progsoft/demo/log/";
    public static final String LOG_FILENAME = "progsoft/demo/log/log.txt";
    public static final String INFO_FILENAME = "progsoft/demo/info3.txt";
    public static final String GET_CHARGE_URL = "https://www.baidu.com/";
    public static final double CENTRE_LATITUDE = 12.6569;
    public static final double CENTRE_LONGITUDE = 14.0537;
    public static final int MAX_DISPLAY_RECORD = 30;

    public static void FileWrite(String filename, String context, boolean tFlag) {
        try {
            String newTitle = "";
            File file = new File(Environment.getExternalStorageDirectory(), filename);
            if (!file.exists()) {
                newTitle = "开启新的一天，加油吧\n";
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            Date now = new Date();
            if (tFlag) {
                bw.write(newTitle + now + " , " + context);
            } else {
                bw.write(context);
            }
            bw.newLine();
            bw.flush();
            bw.close();
            Log.e(TAG, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
