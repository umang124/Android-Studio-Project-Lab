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
    String[] wordA = new String[]{"Apple", "About", "Acne", "Alphabet", "Anchor"};
    String[] wordB = new String[]{"Bakery", "Balance", "Banana", "Band", "Bank"};
    String[] wordC = new String[]{"Car", "Cat", "Computer", "Cake", "Camera"};
    String[] wordD = new String[]{"Dog", "Door", "Dinner", "Drink", "Desk"};
    String[] wordE = new String[]{"Elephant", "Egg", "Earth", "Exercise", "Eat"};
    String[] wordF = new String[]{"Friend", "Family", "Flower", "Food", "Fun"};
    String[] wordG = new String[]{"Good", "Great", "Game", "Garden", "Gift"};
    String[] wordH = new String[]{"House", "Hat", "Happy", "Help", "Heart"};
    String[] wordI = new String[]{"Idea", "Ice", "Interesting", "Island", "Important"};
    String[] wordJ = new String[]{"Joke", "Juice", "Jacket", "Joy", "Journal"};
    String[] wordK = new String[]{"Kangaroo", "Kindness", "Kitchen", "Key", "Kind"};
    String[] wordL = new String[]{"Lion", "Lamp", "Lemon", "Language", "Library"};
    String[] wordM = new String[]{"Music", "Movie", "Mountain", "Meal", "Moon"};
    String[] wordN = new String[]{"Nature", "Night", "Newspaper", "Name", "Nose"};
    String[] wordO = new String[]{"Ocean", "Orange", "Office", "Octopus", "Oven"};
    String[] wordP = new String[]{"Party", "Park", "Pizza", "Pencil", "Phone"};
    String[] wordQ = new String[]{"Queen", "Quick", "Quiet", "Quilt", "Quench"};
    String[] wordR = new String[]{"Rainbow", "Room", "Rabbit", "Rose", "River"};
    String[] wordS = new String[]{"Summer", "Sun", "School", "Sand", "Sandwich"};
    String[] wordT = new String[]{"Tree", "Table", "Telephone", "Television", "Tiger"};
    String[] wordU = new String[]{"Umbrella", "Unicorn", "Uniform", "University", "Upstairs"};
    String[] wordV = new String[]{"Umbrella", "Unicorn", "Uniform", "University", "Upstairs"};
    String[] wordW = new String[]{"Water", "Window", "Watch", "Wheel", "Wine"};
    String[] wordX = new String[]{"X-ray", "Xenophobia", "Xylophone", "Xenon", "Xerophyte"};
    String[] wordY = new String[]{"Yummy", "Yogic", "Yarrow", "Yearly", "Yeast"};
    String[] wordZ = new String[]{"Zany", "Zestful", "Zenith", "Zonal", "Zygotic"};

    ArrayList<String> wordsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int position = getIntent().getIntExtra("position", 0);

        if (position == 0) {
            for (String word : wordA) {
                wordsList.add(word);
            }
        } else if (position == 1) {
            for (String word : wordB) {
                wordsList.add(word);
            }
        } else if (position == 2) {
            for (String word : wordC) {
                wordsList.add(word);
            }
        } else if (position == 3) {
            for (String word : wordD) {
                wordsList.add(word);
            }
        } else if (position == 4) {
            for (String word : wordE) {
                wordsList.add(word);
            }
        } else if (position == 5) {
            for (String word : wordF) {
                wordsList.add(word);
            }
        } else if (position == 6) {
            for (String word : wordG) {
                wordsList.add(word);
            }
        } else if (position == 7) {
            for (String word : wordH) {
                wordsList.add(word);
            }
        } else if (position == 8) {
            for (String word : wordI) {
                wordsList.add(word);
            }
        } else if (position == 9) {
            for (String word : wordJ) {
                wordsList.add(word);
            }
        } else if (position == 10) {
            for (String word : wordK) {
                wordsList.add(word);
            }
        } else if (position == 11) {
            for (String word : wordL) {
                wordsList.add(word);
            }
        } else if (position == 12) {
            for (String word : wordM) {
                wordsList.add(word);
            }
        } else if (position == 13) {
            for (String word : wordN) {
                wordsList.add(word);
            }
        } else if (position == 14) {
            for (String word : wordO) {
                wordsList.add(word);
            }
        } else if (position == 15) {
            for (String word : wordP) {
                wordsList.add(word);
            }
        } else if (position == 16) {
            for (String word : wordQ) {
                wordsList.add(word);
            }
        } else if (position == 17) {
            for (String word : wordR) {
                wordsList.add(word);
            }
        } else if (position == 18) {
            for (String word : wordS) {
                wordsList.add(word);
            }
        } else if (position == 19) {
            for (String word : wordT) {
                wordsList.add(word);
            }
        } else if (position == 20) {
            for (String word : wordU) {
                wordsList.add(word);
            }
        } else if (position == 21) {
            for (String word : wordV) {
                wordsList.add(word);
            }
        } else if (position == 22) {
            for (String word : wordW) {
                wordsList.add(word);
            }
        } else if (position == 23) {
            for (String word : wordX) {
                wordsList.add(word);
            }
        } else if (position == 24) {
            for (String word : wordY) {
                wordsList.add(word);
            }
        } else if (position == 25) {
            for (String word : wordZ) {
                wordsList.add(word);
            }
        }
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