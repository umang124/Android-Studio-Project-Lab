package com.example.wordsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<WordModel> modelArrayList;
    WordAdapter wordAdapter;
    WordsHelper wordsHelper;
    ArrayList<String> wordsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        wordsHelper = new WordsHelper();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int position = getIntent().getIntExtra("position", 0);

        wordsHelper.AddWordsInArrayList(position, wordsList, wordsHelper);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        modelArrayList = new ArrayList<>();
        wordAdapter = new WordAdapter(this, modelArrayList);
        recyclerView.setAdapter(wordAdapter);

        for (String word : wordsList) {
            WordModel wordModel = new WordModel(word);
            modelArrayList.add(wordModel);
        }
        wordAdapter.notifyDataSetChanged();
    }
}