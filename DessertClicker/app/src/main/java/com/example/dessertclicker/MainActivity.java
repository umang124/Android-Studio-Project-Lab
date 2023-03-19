package com.example.dessertclicker;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.databinding.DataBindingUtil;

import com.example.dessertclicker.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    private int revenue = 0;
    private int dessertsSold = 0;
    private ActivityMainBinding binding;


    private final List<Dessert> allDesserts = Arrays.asList(
            new Dessert(R.drawable.cupcake, 5, 0),
            new Dessert(R.drawable.donut, 10, 5),
            new Dessert(R.drawable.eclair, 15, 20),
            new Dessert(R.drawable.froyo, 30, 50),
            new Dessert(R.drawable.gingerbread, 50, 100),
            new Dessert(R.drawable.honeycomb, 100, 200),
            new Dessert(R.drawable.icecreamsandwich, 500, 500),
            new Dessert(R.drawable.jellybean, 1000, 1000),
            new Dessert(R.drawable.kitkat, 2000, 2000),
            new Dessert(R.drawable.lollipop, 3000, 4000),
            new Dessert(R.drawable.marshmallow, 4000, 8000),
            new Dessert(R.drawable.nougat, 5000, 16000),
            new Dessert(R.drawable.oreo, 6000, 20000)
    );
    private Dessert currentDessert = allDesserts.get(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(ConstantVariable.TAG, "onCreate Called");
        // Use Data Binding to get reference to the views
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.dessertButton.setOnClickListener(view -> onDessertClicked());

        // Set the TextViews to the right values
        setRevenueAndAmountSold(revenue, dessertsSold);

        // Make sure the correct dessert is showing
        binding.dessertButton.setImageResource(currentDessert.getImageId());

        if (checkIfSavedInstanceStateIsNotNull(savedInstanceState)) {
            revenue = savedInstanceState.getInt(ConstantVariable.KEY_REVENUE, 0);
            dessertsSold = savedInstanceState.getInt(ConstantVariable.KEY_DESSERT_SOLD, 0);
            setRevenueAndAmountSold(revenue, dessertsSold);
            showCurrentDessert();
        }
    }
    private boolean checkIfSavedInstanceStateIsNotNull(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            return true;
        }
        return false;
    }

    private void setRevenueAndAmountSold(int revenue, int dessertsSold) {
        binding.setRevenue(revenue);
        binding.setAmountSold(dessertsSold);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(ConstantVariable.TAG, "onSaveInstanceState Called");
        outState.putInt(ConstantVariable.KEY_REVENUE, revenue);
        outState.putInt(ConstantVariable.KEY_DESSERT_SOLD, dessertsSold);
    }

    /**
     * Updates the score when the dessert is clicked. Possibly shows a new dessert.
     */
    private void onDessertClicked() {

        // Update the score
        revenue += currentDessert.getPrice();
        dessertsSold++;

        binding.setRevenue(revenue);
        binding.setAmountSold(dessertsSold);

        // Show the next dessert
        showCurrentDessert();
    }

    /**
     * Determine which dessert to show.
     */
    private void showCurrentDessert() {
        // revenue
        // dessertsSold
        Dessert newDessert = allDesserts.get(0);
        for (Dessert dessert : allDesserts) {
            if (dessertsSold >= dessert.getStartProductionAmount()) {
                newDessert = dessert;
            }
            else break;
        }
        // If the new dessert is actually different than the current dessert, update the image
        if (!newDessert.equals(currentDessert)) {
            currentDessert = newDessert;
            binding.dessertButton.setImageResource(newDessert.getImageId());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ConstantVariable.TAG, ConstantVariable.ON_START_CALLED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ConstantVariable.TAG, ConstantVariable.ON_RESUME_CALLED);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ConstantVariable.TAG, ConstantVariable.ON_PAUSE_CALLED);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ConstantVariable.TAG, ConstantVariable.ON_STOP_CALLED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ConstantVariable.TAG, ConstantVariable.ON_DESTROY_CALLED);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ConstantVariable.TAG, ConstantVariable.ON_RESTART_CALLED);
    }

    private void onShare() {
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setText(getString(R.string.share_text, dessertsSold, revenue))
                .setType("text/plain").getIntent();
        try {
            startActivity(shareIntent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, getString(R.string.sharing_not_available), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shareMenuButton:
                onShare();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}