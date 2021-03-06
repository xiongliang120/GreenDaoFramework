package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * Copyright  : 2015-2033 Beijing Startimes Communication & Network Technology Co.Ltd
 * Created by zhf 2015/12/23.
 * ClassName  :
 * Description  :
 */

public class HybridDaoGenerate {
    public static void main(String[] args) throws Exception {
        HybridDaoGenerate hybridDaoGenerate = new HybridDaoGenerate();
        hybridDaoGenerate.generate();
    }

    //用于创建
    public void generate() throws Exception {
        DaoGenerator daoGenerator = new DaoGenerator();
        daoGenerator.generateAll(schema, "greendaolibrary/src/main/java"); //根据自己情况修改输出路径
    }

    private final Schema schema;
    public HybridDaoGenerate() {
        schema = new Schema(1, "com.example.user.greendaolibrary.entity"); //指定生成代码所在的包
        //createLockMark(); //创建lock
        createLockMarkAndPicture();

    }

    private void createLockMark() {
        Entity lockMark = schema.addEntity("LockMark");
        lockMark.addIdProperty().primaryKey().autoincrement();
        lockMark.addStringProperty("lockID");
        lockMark.addStringProperty("lockName");
        lockMark.implementsSerializable(); //序列化,可选
    }


    private void createLockMarkAndPicture() {
        Entity lockMark = schema.addEntity("LockMark");
        lockMark.addIdProperty().primaryKey().autoincrement();
        lockMark.addStringProperty("lockID");
        lockMark.addStringProperty("lockName");
        lockMark.implementsSerializable(); //序列化,可选

        Entity picture = schema.addEntity("Picture");
        picture.addLongProperty("pictureId").primaryKey().autoincrement();
        picture.addStringProperty("pictureName").notNull();

        //建立一对一关联关系
        Property property = lockMark.addLongProperty("pictureId").getProperty();
        lockMark.addToOne(picture,property);

        Property propertyName = picture.addLongProperty("aa").getProperty();
        picture.addToOne(lockMark,propertyName);

    }


}
