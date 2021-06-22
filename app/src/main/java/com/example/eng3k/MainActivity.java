package com.example.eng3k;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView learn, test ,about;
    //private Button rmbrdlstbutt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        learn = findViewById(R.id.learn);
        test = findViewById(R.id.test);
        about = findViewById(R.id.us);

        learn.setOnClickListener(this);
        test.setOnClickListener(this);
        about.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.learn)
        {
            Intent intent = new Intent(MainActivity.this , WordListActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.test)
        {
            Intent intent = new Intent(MainActivity.this , TestActicity.class);
            startActivity(intent);

        }
        else
        {
            Intent intent = new Intent(MainActivity.this , AboutActivity.class);
            startActivity(intent);
        }


    }
    @Override
    public void onBackPressed(){
        Intent  intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        System.exit(0);

    }


}