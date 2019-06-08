package com.example.myapplication.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.myapplication.fragments.FragChar;
import com.example.myapplication.fragments.FragListChar;
import com.example.myapplication.fragments.FragWordCounter;
import com.example.myapplication.model.WordCount;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private FragChar fragChar;
    private FragListChar fragListChar;
    private FragWordCounter fragWordCounter;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragChar = FragChar.newInstance();
        fragListChar = FragListChar.newInstance();
        fragWordCounter = FragWordCounter.newInstance();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragChar;

            case 1:
                return fragListChar;

            case 2:
                return fragWordCounter;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public void setFragChar(Character character) {
        fragChar.setChar(character);
    }

    public void setCharList(char[] characterList) {
        fragListChar.setCharList(characterList);
    }

    public void setWordCount(List<WordCount> wordCount) {
        fragWordCounter.setWordCount(wordCount);
    }
}
