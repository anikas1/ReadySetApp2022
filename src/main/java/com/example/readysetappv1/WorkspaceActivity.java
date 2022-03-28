package com.example.readysetappv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WorkspaceActivity extends AppCompatActivity {

    // declaration; objects from xml
    Button theButton1;
    Button theButton2;
    Button theButton3;
    Button theButton4;
    Button theButton5;
    Button theButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workspace);

        // TODO: Use an adapter instead?
        // initialization
        theButton1 = findViewById(R.id.button);
        theButton2 = findViewById(R.id.button2);
        theButton3 = findViewById(R.id.button3);
        theButton4 = findViewById(R.id.button4);
        theButton5 = findViewById(R.id.button5);
        theButton6 = findViewById(R.id.button6);

        // TODO: Know which workspace was selected
        // all just direct to the upload activity
        theButton1.setOnClickListener(this::onClickSubmit);
        theButton2.setOnClickListener(this::onClickSubmit);
        theButton3.setOnClickListener(this::onClickSubmit);
        theButton4.setOnClickListener(this::onClickSubmit);
        theButton5.setOnClickListener(this::onClickSubmit);
        theButton6.setOnClickListener(this::onClickSubmit);

    }

    private void onClickSubmit(View v) {
        Intent intent = new Intent(WorkspaceActivity.this, MenuActivity.class);
        startActivity(intent);
    }

}