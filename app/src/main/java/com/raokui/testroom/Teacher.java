package com.raokui.testroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by RaoKui on 2018/3/22.
 */

@Entity(tableName = "tb_teacher")
public class Teacher {

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "name")
    private String name;

    @Ignore
    private String school;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
