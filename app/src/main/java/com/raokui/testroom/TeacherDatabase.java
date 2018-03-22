package com.raokui.testroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by RaoKui on 2018/3/22.
 */

@Database(entities = {Teacher.class} ,version = 1)
public abstract class TeacherDatabase extends RoomDatabase {
    public abstract TeacherDao teacherDao();
}
