package com.example.eng3k;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class
ResultActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView scoretxt;
    private Button home, retest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home=findViewById(R.id.home);
        retest= findViewById(R.id.retest);

        scoretxt=findViewById(R.id.scoretxt);
        Intent intent2 = getIntent();
        int s = intent2.getIntExtra("point",0);
        int a = intent2.getIntExtra("page",0);
        scoretxt.setText("Your score :: "+s+"\n"+"Your accuracy= "+s*10+"%" );
        home.setOnClickListener(this);
        retest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.home)
        {
            Intent intent = new Intent(ResultActivity.this , MainActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.retest)
        {
            Intent intent = new Intent(ResultActivity.this , TestActicity.class);
            startActivity(intent);
        }

        finish();

    }
}