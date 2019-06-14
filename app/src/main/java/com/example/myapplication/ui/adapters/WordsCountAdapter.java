package com.example.myapplication.ui.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.WordCount;
import com.example.myapplication.utils.ColorHelper;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordsCountAdapter extends RecyclerView.Adapter<WordsCountAdapter.RecyclerViewHolder> {
    private List<WordCount> wordCounts;

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_words_count, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if (wordCounts != null) {

            holder.word.setText(wordCounts.get(position).getWord());

            holder.count.setText(String.valueOf(wordCounts.get(position).getCount()));

            holder.desc.setText("this word repeated " + wordCounts.get(position).getCount() + " times");

            holder.layout_background.setBackgroundColor(ColorHelper.getColor(wordCounts.get(position).getCount()));
        }
    }

    @Override
    public int getItemCount() {
        if (wordCounts != null)
            return wordCounts.size();
        else
            return 0;
    }

    public void setWordCount(List<WordCount> wordCount) {
        this.wordCounts = wordCount;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_counter_item_word)
        TextView word;
        @BindView(R.id.tv_counter_item_counts)
        TextView count;
        @BindView(R.id.tv_counter_item_desc)
        TextView desc;
        @BindView(R.id.layout_itemCount_background)
        RelativeLayout layout_background;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
