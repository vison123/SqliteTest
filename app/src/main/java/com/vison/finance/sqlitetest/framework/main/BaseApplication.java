package com.vison.finance.sqlitetest.framework.main;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vison.finance.sqlitetest.framework.db.SqLiteHelper;

/**
 * Created by vison.
 * on 17/7/5.
 */
public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SqLiteHelper dh = new SqLiteHelper(context);
        //连接数据库 获取数据库实例
        //getWritableDatabase() 数据写满会报错
        //getReadableDatabase() 数据写满不会报错
        SQLiteDatabase sd = dh.getWritableDatabase();
        sd.close();
    }

    public static Context getContext() {
        return context;
    }
}
