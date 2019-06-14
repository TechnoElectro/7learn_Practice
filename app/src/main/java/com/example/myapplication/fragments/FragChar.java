package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.R;
import com.example.myapplication.utils.FontGuid;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragChar extends Fragment {

    @BindView(R.id.tv_char_character)
    TextView tv_char;

    @BindView(R.id.view_char_background)
    View bg_view;

    @BindView(R.id.av_char_done)
    LottieAnimationView done_animation;

    @BindView(R.id.av_char_search)
    LottieAnimationView search_animation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_char, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initViews(view);
    }

    private void initViews(View view) {
        FontGuid fontGuid = FontGuid.getInstance(view.getContext());
        TextView tv_question = view.findViewById(R.id.tv_char_question);
        tv_question.setTypeface(fontGuid.getFont());
    }

    public static FragChar newInstance() {
        Bundle args = new Bundle();
        FragChar fragment = new FragChar();
        fragment.setArguments(args);
        return fragment;
    }

    public void setChar(Character character) {
        search_animation.setVisibility(View.GONE);
        done_animation.playAnimation();
        tv_char.setText(character.toString());
        bg_view.setVisibility(View.VISIBLE);
    }

}
