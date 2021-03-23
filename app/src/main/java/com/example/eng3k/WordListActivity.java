package com.example.eng3k;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class WordListActivity extends AppCompatActivity {

    private RecyclerView wordsRecView;
    private WordsRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        adapter=new WordsRecViewAdapter(this);
        wordsRecView = findViewById(R.id.wrdlistRecView);

        wordsRecView.setAdapter(adapter);
        wordsRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setWords(Utils.getInstance().getAllWords());





    }
}