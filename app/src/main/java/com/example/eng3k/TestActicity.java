package com.example.eng3k;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class TestActicity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup radioGroup;
    private Button apply,next;
    private TextView qstntxt,resulttxt;
    private RadioButton r1,r2,r3,r4;
    private RadioButton[] rButtons = {r1, r2,r3,r4};

    Random r = new Random();
    int i1 = r.nextInt( 3000- 1) + 1;
    int i2 = r.nextInt( 3000- 1) + 1;
    int i3 = r.nextInt( 3000- 1) + 1;
    int i4 = r.nextInt( 3000- 1) + 1;
    int rdcontrol = r.nextInt( 4);


    String validoption;
    String[] option=new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_acticity);

        radioGroup = findViewById(R.id.group);
        apply = findViewById(R.id.apply);
        next = findViewById(R.id.next);
        qstntxt = findViewById(R.id.qstntxt);
        resulttxt= findViewById(R.id.resulttxt);
        rButtons[0] = findViewById(R.id.op1);
        rButtons[1] = findViewById(R.id.op2);
        rButtons[2] = findViewById(R.id.op3);
        rButtons[3] = findViewById(R.id.op4);






        String[] value;
        InputStream inputStream;
        inputStream = getResources().openRawResource(R.raw.data);
        BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
        try{
            String read;
            while ((read =reader.readLine()) !=null){

                value=read.split(",");
                try{
                    if (Integer.parseInt(value[0])==i1){
                        qstntxt.setText(value[1]+" শব্দটির বাংলা অর্থ কী ?");
                        validoption=value[2];
                    }
                    if (Integer.parseInt(value[0])==i2){
                        option[0]=value[2];
                    }
                    if (Integer.parseInt(value[0])==i3){
                        option[1]=value[2];
                    }
                    if (Integer.parseInt(value[0])==i4){
                        option[2]=value[2];
                    }


                }catch(Exception e){
                    Log.e("Unknown error", e.toString());
                }
            }

        }catch (Exception e){

        }
        int j=0;
        for (int i=0;i<4;i++){
            if(i==rdcontrol){
                rButtons[i].setText(validoption);
            }
            else{
                rButtons[i].setText(option[j]);
                j++;
            }

        }

        apply.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        apply.setEnabled(false);
        for(int i=0;i<4;i++){
            rButtons[i].setEnabled(false);
        }
        int point =0,page=0;
        page++;

        if(rButtons[rdcontrol].isChecked())
        {
            point++;
            resulttxt.setText("Correct Answer"+point);

        }
        else {
            resulttxt.setText("Wrong Answer");
        }

        if(v.getId()==R.id.next)
        {
            Intent intent= new Intent(TestActicity.this,TestActicity2.class);
            intent.putExtra("point", point);
            intent.putExtra("page",page);
            startActivity(intent);
        }

    }
}