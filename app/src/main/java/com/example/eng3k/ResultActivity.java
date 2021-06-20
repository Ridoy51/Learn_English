package com.example.eng3k;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView scoretxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoretxt=findViewById(R.id.scoretxt);
        Intent intent2 = getIntent();
        int s = intent2.getIntExtra("point",0);
        int a = intent2.getIntExtra("page",0);
        scoretxt.setText("Your score :: "+s+"\n"+"Your accuracy= "+s*10+"%" );
    }
}