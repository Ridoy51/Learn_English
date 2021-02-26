package com.example.eng3k;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class WordListActivity extends AppCompatActivity {

    private RecyclerView wordsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        setContentView(R.layout.activity_word_list);

        wordsRecView = findViewById(R.id.wrdlistRecView);




        WordsRecViewAdapter adapter = new WordsRecViewAdapter(this);
        adapter.setWords(Utils.getInstance().getAllWords());

        wordsRecView.setAdapter(adapter);
        wordsRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}