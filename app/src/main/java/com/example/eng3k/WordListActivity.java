package com.example.eng3k;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WordListActivity extends AppCompatActivity {

    private RecyclerView wordsRecView;
    private WordsRecViewAdapter adapter;
    public static WordListActivity baseActivity;
    public static Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        baseActivity=this;// passed to non-activity class use
        mContext=this.getBaseContext();//passed to non-activity class use

        adapter=new WordsRecViewAdapter(this);
        wordsRecView = findViewById(R.id.wrdlistRecView);

        wordsRecView.setAdapter(adapter);
        wordsRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setWords(Utils.getInstance().getAllWords());





    }
}