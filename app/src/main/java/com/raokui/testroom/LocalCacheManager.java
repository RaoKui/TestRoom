package com.raokui.testroom;

import android.arch.persistence.room.Room;
import android.content.Context;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RaoKui on 2018/3/22.
 */

public class LocalCacheManager {

    private static LocalCacheManager mInstance;

    private TeacherDatabase mDatabase;

    private static final String DB_NAME = "teacher-database";

    public static LocalCacheManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new LocalCacheManager(context);
        }
        return mInstance;
    }

    private LocalCacheManager(Context context) {
        mDatabase = Room.databaseBuilder(context, TeacherDatabase.class, DB_NAME).build();
    }

    private void getTeacher() {

    }

    public void addTeacher(final Teacher teacher, final DatabaseCallback databaseCallback) {
        Completable
                .fromAction(new Action() {
                    @Override
                    public void run() throws Exception {
                        mDatabase.teacherDao().insert(teacher);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        databaseCallback.onAdded();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
