package com.example.truynkhngci.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.truynkhngci.R;
import com.example.truynkhngci.View.story;

import java.util.List;

public class viewPagerAdapter extends PagerAdapter {
    private Context context ;
    private List<story> list ;
    private story data ;
    private TextView name,content ;


    public viewPagerAdapter(Context context, List<story> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup viewPager, int position) {
            View view = LayoutInflater.from(context).inflate(R.layout.m002_viewpager_component,viewPager,false);
            name = view.findViewById(R.id.tv_nameStory) ;
            content = view.findViewById(R.id.tv_content) ;
            data = list.get(position) ;
            name.setText(data.getName());
            content.setText(data.getContent());
            viewPager.addView(view) ;

            return view ;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                    container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
