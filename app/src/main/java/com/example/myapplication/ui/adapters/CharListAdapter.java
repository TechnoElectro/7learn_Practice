package com.example.myapplication.ui.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharListAdapter extends RecyclerView.Adapter<CharListAdapter.RecyclerViewHolder> {

    private static char[] characters;

    public void setCharList(char[] characterList) {
        characters = characterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_char_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if (characters != null) {
            holder.tv_char.setText(String.valueOf(characters[position]));
            holder.tv_counts.setText(String.valueOf((position + 1) * 10));
            if (position % 2 == 0) {
                holder.charListBackground.setBackgroundColor(Color.rgb(251, 170, 244));
            } else {
                holder.charListBackground.setBackgroundColor(Color.rgb(252, 197, 248));
            }
        }

    }

    @Override
    public int getItemCount() {
        if (characters != null) {
            return characters.length;
        } else {
            return 0;
        }
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_char_character)
        TextView tv_char;

        @BindView(R.id.tv_counter_item_counts)
        TextView tv_counts;

        @BindView(R.id.layout_charList_background)
        RelativeLayout charListBackground;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
