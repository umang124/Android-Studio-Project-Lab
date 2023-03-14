package com.example.wordsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.LetterViewHolder> {
    Context context;
    ArrayList<LetterModel> modelArrayList;
    GridLayoutManager mLayoutManager;

    public LetterAdapter(Context context, ArrayList<LetterModel> modelArrayList, GridLayoutManager layoutManager) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        mLayoutManager = layoutManager;
    }

    @NonNull
    @Override
    public LetterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (mLayoutManager.getSpanCount() == 1) {
            view = layoutInflater.inflate(R.layout.letter_item_big, parent, false);
        } else {
            view = layoutInflater.inflate(R.layout.letter_item_small, parent, false);
        }
        return new LetterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LetterViewHolder holder, int position) {
        LetterModel letterModel = modelArrayList.get(position);
        holder.button.setText(letterModel.letter);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("position", position);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class LetterViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public LetterViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }
}
