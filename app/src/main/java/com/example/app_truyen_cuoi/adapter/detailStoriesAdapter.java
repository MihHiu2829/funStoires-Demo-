package com.example.app_truyen_cuoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.app_truyen_cuoi.R;
import com.example.app_truyen_cuoi.View.DetailStories;

import java.util.ArrayList;
import java.util.List;

public class detailStoriesAdapter extends PagerAdapter {
    private Context context ;
    private List<DetailStories> listStory ;


    public detailStoriesAdapter(Context context, List<DetailStories> listStory) {
        this.context = context;
        this.listStory = listStory;

    }

    @Override
    public int getCount() {
        return listStory.size() ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup viewPager, int position) {
        View  view = LayoutInflater.from(context).inflate(R.layout.item_detail_stories,viewPager,false) ;
        DetailStories data = listStory.get(position) ;
        TextView tvName = view.findViewById(R.id.tv_topicNames) ;
        TextView tvDetail = view.findViewById(R.id.tv_topicDetails) ;
        tvName.setText(data.getNameStory());
        tvDetail.setText(data.getDetailStories());
        viewPager.addView(view) ;

            return view ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup viewPager, int position, @NonNull Object object) {
                    viewPager.removeView((View) object);
        }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
