package com.example.myviewpager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyAdapter extends PagerAdapter {
    private List<View> mListView;

    public MyAdapter(List<View> mListView) {
        this.mListView = mListView;
    }

    @Override
    public int getCount() {
        return mListView.size();
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mListView.get(position),0);
        return mListView.get(position);
    }


}
