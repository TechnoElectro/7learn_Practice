package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.R;
import com.example.myapplication.model.WordCount;
import com.example.myapplication.ui.adapters.WordsCountAdapter;
import com.example.myapplication.utils.FontGuid;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragWordCounter extends Fragment {
    private WordsCountAdapter wordsCountAdapter;

    @BindView(R.id.av_wordCounter_done)
    LottieAnimationView done_animation;

    @BindView(R.id.av_wordCounter_search)
    LottieAnimationView search_animation;

    @BindView(R.id.tv_counter_question)
    TextView tv_question;

    @BindView(R.id.rv_counter_words)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=   inflater.inflate(R.layout.fragment_word_counter, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FontGuid fontGuid = FontGuid.getInstance(view.getContext());
        tv_question.setTypeface(fontGuid.getFont());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        wordsCountAdapter = new WordsCountAdapter();
        recyclerView.setAdapter(wordsCountAdapter);
    }

    public static FragWordCounter newInstance() {
        Bundle args = new Bundle();
        FragWordCounter fragment = new FragWordCounter();
        fragment.setArguments(args);
        return fragment;
    }

    public void setWordCount(List<WordCount> wordCount) {
        search_animation.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        done_animation.playAnimation();
        wordsCountAdapter.setWordCount(wordCount);
    }
}
