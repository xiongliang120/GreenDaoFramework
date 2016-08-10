package com.example.user.greendaolibrary.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.greendaolibrary.entity.DaoMaster;
import com.example.user.greendaolibrary.entity.DaoSession;
import com.example.user.greendaolibrary.entity.LockMarkDao;


/**
 * Copyright  : 2015-2033 Beijing Startimes Communication & Network Technology Co.Ltd
 * Created by zhanghf on 2016/2/19.
 * ClassName  :
 * Description  :
 */

public class DBManager {
    private static DBManager instance;
    private Context context;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private LockMarkDao lockMarkDao;

    public DBManager(Context context) {
        this.context = context;
        registerCreateDB();
    }

    private void registerCreateDB() {
        setupDatabase();
    }

    //初始化单例时使用
    public static DBManager getInstance(Context context) {
        if (instance == null) {
            instance = new DBManager(context);
        }
        return instance;
    }

    public static DBManager getInstance() {
        return instance;
    }

    public LockMarkDao getLockMaskDao() {
        return lockMarkDao;
    }

    /**
     *     更新已做处理
     */
    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, "msg_info.db", null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
            daoSession = daoMaster.newSession();
            lockMarkDao = daoSession.getLockMarkDao();
        }

    }

}
