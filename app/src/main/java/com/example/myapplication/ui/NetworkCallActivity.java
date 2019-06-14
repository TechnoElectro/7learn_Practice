package com.example.myapplication.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.model.WordCount;
import com.example.myapplication.ui.adapters.ViewPagerAdapter;
import com.example.myapplication.utils.FontGuid;
import com.example.myapplication.viewmodel.NetworkCallViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NetworkCallActivity extends AppCompatActivity implements NetworkCallViewModel.UiCallBack {
    @BindView(R.id.tv_network_brand)
    TextView brand;

    @BindView(R.id.tv_network_title)
    TextView title;

    @BindView(R.id.iv_network_logo)
    ImageView logo;

    @BindView(R.id.vp_network_request)
    ViewPager viewPager;


    private ViewPagerAdapter mViewPagerAdapter =new ViewPagerAdapter(getSupportFragmentManager());
    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_call);
        initViews();
        makeRequest();
    }

    private void initViews() {
        ButterKnife.bind(this);
        FontGuid fontGuid = FontGuid.getInstance(this);
        brand.setTypeface(fontGuid.getFont());
        title.setTypeface(fontGuid.getFont());
        viewPager.setClipToPadding(false);
        viewPager.setPadding(80, 0, 80, 0);
        viewPager.setPageMargin(8);
        viewPager.setAdapter(mViewPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.press_twice_to_finish), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void makeRequest() {
        NetworkCallViewModel mViewModel = new NetworkCallViewModel(this);
        mViewModel.getCharAt10Position();
        mViewModel.getMultipleCharAt10Position();
        mViewModel.getWordsCount();
    }

    @Override
    public void charAtPosition10CallBack(Character character) {
        mViewPagerAdapter.setFragChar(character);
    }

    @Override
    public void MultipleCharAt10CallBack(char[] characterList) {
        mViewPagerAdapter.setCharList(characterList);
    }

    @Override
    public void getWordsCountCallBack(List<WordCount> wordCount) {
        mViewPagerAdapter.setWordCount(wordCount);
    }

    @Override
    public void onErrorDataReceive(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
