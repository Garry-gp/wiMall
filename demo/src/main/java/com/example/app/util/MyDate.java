package com.example.app.util;

import java.util.Date;

/**
 * 子类化，可对不可修改的类，添加自己的通用方法（重构手法）
 */
public class MyDate extends Date {

    public void checkDateDay(Date paramerDate){
        paramerDate.getTime();
    }

}
