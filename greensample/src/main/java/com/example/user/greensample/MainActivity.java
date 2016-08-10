package com.example.user.greensample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.greendaolibrary.entity.LockMark;
import com.example.user.greendaolibrary.entity.LockMarkDao;
import com.example.user.greendaolibrary.manager.DBManager;

import java.util.List;

/**
 * android中得下载jar,直接放在build.gradle的话会找不到
 */
public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //插入数据
       // insert();
        //查询数据
        query();
        //删除数据,主要是以id为准
//        LockMark lockMark = new LockMark();
//        lockMark.setId(2l);
//        lockMark.setLockID("11220");
//        lockMark.setLockName("xiongliang0");
//        deleteLockMask(lockMark);
        //更新数据,主要以id为准
//        LockMark lockMark = new LockMark();
//        lockMark.setId(9l);
//        lockMark.setLockID("33333");
//        lockMark.setLockName("xiongliang22");
//        updateLockMask(lockMark);
    }


    public void insert() {
        LockMarkDao lockMarkDao = DBManager.getInstance(this).getLockMaskDao();
        for (int i = 0; i < 20; i++) {
            LockMark lockMark = new LockMark();
            lockMark.setLockID("1122" + i);
            lockMark.setLockName("xiongliang" + i);
            lockMarkDao.insert(lockMark);
        }
    }


    public void query(String id) {
        LockMarkDao lockMarkDao = DBManager.getInstance(this).getLockMaskDao();
        LockMark lockMask = lockMarkDao.queryLockById(id);
    }

    public void query() {
        LockMarkDao lockMarkDao = DBManager.getInstance(this).getLockMaskDao();
        List<LockMark> lockMask = lockMarkDao.queryAllLock();
        Log.i("msg", (lockMask == null ? 0 : lockMask.size()) + "");
    }


    public void deleteLockMask(LockMark lockMark) {
        LockMarkDao lockMarkDao = DBManager.getInstance(this).getLockMaskDao();
        lockMarkDao.delete(lockMark);
    }

    public void updateLockMask(LockMark lockMask) {
        LockMarkDao lockMarkDao = DBManager.getInstance(this).getLockMaskDao();
        lockMarkDao.update(lockMask);
    }
}
