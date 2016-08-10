package com.example.user.greendaolibrary.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "LOCK_MARK".
 */
public class LockMark implements java.io.Serializable {

    private Long id;
    private String lockID;
    private String lockName;

    public LockMark() {
    }

    public LockMark(Long id) {
        this.id = id;
    }

    public LockMark(Long id, String lockID, String lockName) {
        this.id = id;
        this.lockID = lockID;
        this.lockName = lockName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLockID() {
        return lockID;
    }

    public void setLockID(String lockID) {
        this.lockID = lockID;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

}