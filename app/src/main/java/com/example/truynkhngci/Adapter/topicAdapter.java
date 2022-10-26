package com.example.truynkhngci.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.truynkhngci.R;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class topicAdapter extends RecyclerView.Adapter<topicAdapter.Stories> {
    private  Context context ;
    private List<InputStream> input = new ArrayList<>();
    private List<String> listPhoto = new ArrayList<>() ;
    private String data ;
    private InputStream in ;


    public topicAdapter(Context context, List<String> listPhoto,List<InputStream> input) {
        this.context = context;
        this.listPhoto = listPhoto;
        this.input = input ;
    }


    @NonNull
    @Override
    public topicAdapter.Stories onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.m001_componet_view,parent,false) ;
        return new Stories(view);
    }

    @Override
    public void onBindViewHolder(@NonNull topicAdapter.Stories holder, int position) {
            data = listPhoto.get(position) ;
            in = input.get(position) ;
                Bitmap bitmap = BitmapFactory.decodeStream(in) ;
                holder.img_Topic.setImageBitmap(bitmap);
                String a =data.replace(".png","") ;
                String b = a.replace(".PNG","");
                String c = b.replace(".jpg","");
                holder.tv_NameTopic.setText(c);

    }

    @Override
    public int getItemCount() {
        return listPhoto.size();
    }

    public class Stories extends RecyclerView.ViewHolder {
        public  ImageView img_Topic ;
        public TextView tv_NameTopic ;
        public Stories(@NonNull View itemView) {
            super(itemView);
            img_Topic = itemView.findViewById(R.id.img_Topic) ;
            tv_NameTopic = itemView.findViewById(R.id.tv_nameTopic) ;
        }
    }
}
