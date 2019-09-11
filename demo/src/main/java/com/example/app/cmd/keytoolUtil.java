package com.example.app.cmd;

import org.apache.ibatis.executor.BaseExecutor;

import java.io.IOException;

public class keytoolUtil {


    public static void exec(StringBuffer strCmd) throws IOException{
        try {
            Process ps = Runtime.getRuntime().exec(strCmd.toString());
        } catch (IOException e) {
            //Log.info("执行CMD失败。")
            throw e;
        }
    }
}
