package com.example.user.greendaolibrary.manager;

import android.database.sqlite.SQLiteDatabase;

/**
 * Copyright  : 2015-2033 Beijing Startimes Communication & Network Technology Co.Ltd
 * Created by zhanghf on 2016/2/19.
 * ClassName  :
 * Description  :
 */
public interface DBHelper {
      void onUpgrade(SQLiteDatabase db);
}
