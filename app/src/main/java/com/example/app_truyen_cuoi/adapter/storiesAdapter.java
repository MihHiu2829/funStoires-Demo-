package com.example.app_truyen_cuoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_truyen_cuoi.R;
import com.example.app_truyen_cuoi.View.DetailStories;

import java.util.List;

public class storiesAdapter extends RecyclerView.Adapter<storiesAdapter.Storyholder> {
    private Context context ;
    private List<DetailStories> listStory  ;
    private MutableLiveData<DetailStories> stories = new MutableLiveData<>() ;
    public storiesAdapter(Context context, List<DetailStories> listStory) {
        this.context = context;
        this.listStory = listStory;
    }

    public MutableLiveData<DetailStories> getStories() {
        return stories;
    }

    @NonNull
    @Override
    public Storyholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_story,parent,false) ;
        return new Storyholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Storyholder holder, int position) {
                DetailStories data = listStory.get(position) ;
                holder.storyName.setText(data.getNameStory());
                holder.storyName.setTag(data);
    }

    @Override
    public int getItemCount() {
        return listStory.size() ;
    }

    public  class  Storyholder extends RecyclerView.ViewHolder {
        TextView storyName;
        public Storyholder(@NonNull View view) {
            super(view);
            storyName = view.findViewById(R.id.bt_topicStories) ;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.startAnimation(AnimationUtils.loadAnimation(context , androidx.appcompat.R.anim.abc_fade_in));
                    clickItemStory((DetailStories)storyName.getTag()) ;
                }
            });
        }

        private void clickItemStory(DetailStories stroies) {
            stories.postValue(stroies);


        }


    }
}
