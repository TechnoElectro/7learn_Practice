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

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordsCountAdapter extends RecyclerView.Adapter<WordsCountAdapter.RecyclerViewHolder> {
    private List<WordCount> wordCounts;


    public WordsCountAdapter() {

    }

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
            switch (wordCounts.get(position).getCount()) {
                case 0:
                    holder.layout_background.setBackgroundColor(Color.rgb(160, 232, 252));
                    break;
                case 1:
                    holder.layout_background.setBackgroundColor(Color.rgb(160, 252, 238));
                    break;
                case 2:
                    holder.layout_background.setBackgroundColor(Color.rgb(160, 252, 197));
                    break;
                case 3:
                    holder.layout_background.setBackgroundColor(Color.rgb(160, 252, 188));
                    break;
                case 4:
                    holder.layout_background.setBackgroundColor(Color.rgb(160, 252, 176));
                    break;
                case 5:
                    holder.layout_background.setBackgroundColor(Color.rgb(160, 252, 167));
                    break;
                case 6:
                    holder.layout_background.setBackgroundColor(Color.rgb(179, 252, 160));
                    break;
                case 7:
                    holder.layout_background.setBackgroundColor(Color.rgb(199, 253, 159));
                    break;
                case 8:
                    holder.layout_background.setBackgroundColor(Color.rgb(222, 253, 159));
                    break;
                case 9:
                    holder.layout_background.setBackgroundColor(Color.rgb(241, 253, 159));
                    break;
                case 10:
                    holder.layout_background.setBackgroundColor(Color.rgb(253, 241, 159));
                    break;
                case 11:
                    holder.layout_background.setBackgroundColor(Color.rgb(254, 225, 158));
                    break;
                case 12:
                    holder.layout_background.setBackgroundColor(Color.rgb(254, 208, 158));
                    break;
                case 13:
                    holder.layout_background.setBackgroundColor(Color.rgb(254, 187, 158));
                    break;
                default:
                    holder.layout_background.setBackgroundColor(Color.rgb(254, 158, 158));
                    break;

            }
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
