package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements courseRegisterDialogFrag.dialogListener{

    private TextView courseTitle, courseCode;
    private FloatingActionButton fragMainReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseCode = (TextView) findViewById(R.id.courseCodeView);
        courseTitle = (TextView) findViewById(R.id.courseTitleView);
        fragMainReg = findViewById(R.id.fABtn);
        fragMainReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment();
            }
        });
    }

    public void openFragment()
    {
        courseRegisterDialogFrag createDialog = new courseRegisterDialogFrag();
        createDialog.show(getSupportFragmentManager(), "create");
    }

    @Override
    public void applyTexts(String course, String title) {
        courseTitle.setText(title);
        courseCode.setText(course);
    }
}