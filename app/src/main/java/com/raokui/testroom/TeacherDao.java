package com.raokui.testroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

/**
 * Created by RaoKui on 2018/3/22.
 */

@Dao
public interface TeacherDao {

    @Insert
    void insert(Teacher teacher);


}
