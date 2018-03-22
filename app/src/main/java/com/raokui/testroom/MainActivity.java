package com.raokui.testroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import junit.framework.TestCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Teacher teacher = new Teacher();
        teacher.setName("hehe");
        teacher.setSchool("hai");
        LocalCacheManager.getInstance(getApplicationContext()).addTeacher(teacher, new DatabaseCallback() {
            @Override
            public void onAdded() {
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
