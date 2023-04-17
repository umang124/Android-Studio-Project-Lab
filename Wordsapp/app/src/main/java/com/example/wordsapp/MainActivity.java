package com.example.wordsapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<LetterModel> modelArrayList;
    LetterAdapter letterAdapter;
    String[] title = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    GridLayoutManager gridLayoutManager;
    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT_ONE);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        modelArrayList = new ArrayList<>();
        letterAdapter = new LetterAdapter(this, modelArrayList, gridLayoutManager);
        recyclerView.setAdapter(letterAdapter);

        for (int i = 0; i < title.length; i++) {
            LetterModel letterModel = new LetterModel(title[i]);
            modelArrayList.add(letterModel);
        }
        letterAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_switch_layout) {
            switchLayout();
            switchIcon(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        } else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        letterAdapter.notifyItemRangeChanged(0, letterAdapter.getItemCount());
    }

    private void switchIcon(MenuItem item) {
        if (gridLayoutManager.getSpanCount() == 3) {
            item.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_grid_layout, null));
        } else {
            item.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_linear_layout, null));
        }
    }
}