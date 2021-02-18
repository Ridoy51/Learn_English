package com.example.eng3k;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button wrdlstbutt;
    private Button testButt;
    private Button rmbrdlstbutt;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wrdlstbutt:
                Toast.makeText(this, wrdlstbutt.getText()+" selected", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(this, WordListActivity.class);
                startActivity(i);

                break;
            case R.id.rmbrdlstbutt:
                Toast.makeText(this, rmbrdlstbutt.getText()+" selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.testButt:
                Toast.makeText(this, testButt.getText()+" selected", Toast.LENGTH_SHORT).show();
                break;
            default: break;

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wrdlstbutt= findViewById(R.id.wrdlstbutt);
        rmbrdlstbutt= findViewById(R.id.rmbrdlstbutt);
        testButt= findViewById(R.id.testButt);

        wrdlstbutt.setOnClickListener(this);
        rmbrdlstbutt.setOnClickListener(this);
        testButt.setOnClickListener(this);

        wrdlstbutt.setText(getString(R.string.wrdlst));
        rmbrdlstbutt.setText(getString(R.string.rmbrdlst));
        testButt.setText(getString(R.string.test));

    }



}