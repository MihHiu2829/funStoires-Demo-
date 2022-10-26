package com.example.truynkhngci.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.truynkhngci.R;
import com.example.truynkhngci.View.App;
import com.example.truynkhngci.View.story;

import java.util.List;

public class menuTopicAdapter extends RecyclerView.Adapter<menuTopicAdapter.Topic_Holder> {

        private Context context;
        private List<story> listStory ;
        private story data ;
        MutableLiveData<story> list = new MutableLiveData<>();

    public MutableLiveData<story> getList() {
        return list;
    }

    public menuTopicAdapter(Context context, List<story> listStory) {
        this.context = context;
        this.listStory = listStory;
    }

    @NonNull
    @Override
    public menuTopicAdapter.Topic_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.m001_componet_view2,parent,false) ;
        return new Topic_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull menuTopicAdapter.Topic_Holder holder, int position) {
                    data = listStory.get(position) ;
                    holder.tv_nameTopic.setText(data.getName());
                    holder.tv_nameTopic.setTag(data);
    }

    @Override
    public int getItemCount() {
        return listStory.size();
    }

    public class Topic_Holder extends RecyclerView.ViewHolder{

            TextView tv_nameTopic ;
            View Ln_topic ;

        public Topic_Holder(@NonNull View itemView) {
            super(itemView);
            tv_nameTopic = itemView.findViewById(R.id.tv_nameTopic)  ;
            Ln_topic = itemView.findViewById(R.id.ln_topic) ;
            Ln_topic.setOnClickListener(v -> gotoM002(v,(story)tv_nameTopic.getTag()));



        }


    }

    private void gotoM002(View v, story tag) {
        v.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
            list.postValue(tag);
    }
}
