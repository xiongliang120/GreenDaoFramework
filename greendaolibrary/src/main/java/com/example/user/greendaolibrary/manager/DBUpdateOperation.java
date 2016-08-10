package com.example.user.greendaolibrary.manager;

import android.database.sqlite.SQLiteDatabase;

/**
 * Copyright  : 2015-2033 Beijing Startimes Communication & Network Technology Co.Ltd
 * Created by zhanghf on 2016/2/19.
 * ClassName  :
 * Description  :
 */

public class DBUpdateOperation implements DBHelper {
    @Override
    public void onUpgrade(SQLiteDatabase db) {
 /* Create a temporal table where you will copy all the data from the previous table that you need to modify with a non supported sqlite operation */
        db.execSQL("CREATE TABLE " + "\"MSG_INFO2\" (" + //
                "\"ID\" INTEGER PRIMARY KEY ASC ," + // 0: id
                "\"RECEIVE_TIME\" INTEGER," + // 1: receiveTime
                "\"IS_READ\" INTEGER," + // 2: isRead
                "\"HEAD_TITLE\" TEXT," + // 3: headTitle
                "\"IS_IMPORTANT\" INTEGER," + // 4: isImportant
                "\"SLOTNO\" INTEGER," + // 5: slotno
                "\"CONTENT\" TEXT," + // 6: content
                "\"TYPE\" INTEGER);"); // 7: type



    /* Copy the data from one table to the new one */
        db.execSQL("INSERT INTO MSG_INFO2 (ID, RECEIVE_TIME, IS_READ, HEAD_TITLE, IS_IMPORTANT,  SLOTNO, CONTENT, TYPE)" +
                " SELECT ID, RECEIVE_TIME, IS_READ, HEAD_TITLE, IS_IMPORTANT,  SLOTNO, CONTENT, TYPE FROM MSG_INFO;");

    /* Delete the previous table */
        db.execSQL("DROP TABLE MSG_INFO");
    /* Rename the just created table to the one that I have just deleted */
        db.execSQL("ALTER TABLE MSG_INFO2 RENAME TO MSG_INFO");

        //以下的这些操作是为了实例一些update操作
//    /* Add Index/es if you want them */
//        db.execSQL("CREATE INDEX " + "IDX_post_USER_ID ON MSG_INFO" +
//                " (ID);");
//        //Example sql statement
//        db.execSQL("ALTER TABLE user ADD COLUMN USERNAME TEXT");
    }
}
