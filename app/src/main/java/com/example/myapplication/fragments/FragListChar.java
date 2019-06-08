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
import com.example.myapplication.ui.adapters.CharListAdapter;
import com.example.myapplication.utils.FontGuid;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragListChar extends Fragment {

    private CharListAdapter charListAdapter;

    @BindView(R.id.av_charList_done)
    LottieAnimationView done_animation;

    @BindView(R.id.av_charList_search)
    LottieAnimationView search_animation;

    @BindView(R.id.tv_listchar_question)
    TextView tv_question;

    @BindView(R.id.rv_charList_chars)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_char, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        FontGuid fontGuid = FontGuid.getInstance(view.getContext());
        tv_question.setTypeface(fontGuid.getFont());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        charListAdapter = new CharListAdapter();
        recyclerView.setAdapter(charListAdapter);
    }

    public static FragListChar newInstance() {
        Bundle args = new Bundle();
        FragListChar fragment = new FragListChar();
        fragment.setArguments(args);
        return fragment;
    }

    public void setCharList(char[] characterList) {
        search_animation.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        done_animation.playAnimation();
        charListAdapter.setCharList(characterList);
    }
}
