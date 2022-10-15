package com.example.app_truyen_cuoi.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_truyen_cuoi.R;
import com.example.app_truyen_cuoi.ViewModel.m001_mainAct;
import com.example.app_truyen_cuoi.databinding.ActivityMainBinding;
import com.example.app_truyen_cuoi.databinding.LayoutTopicBinding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends base_ACT<ActivityMainBinding, m001_mainAct> {

    ArrayList<DetailStories> listSt ;
    int index = 0  ;

    @Override
    protected Class<m001_mainAct> ClassVM() {
        return m001_mainAct.class;
    }

    @Override
    protected void initViews() {
        importTopic() ;
        importStories() ;
        stoiresAndStories() ;
        setOnClickStories() ;
    }

    private void setOnClickStories() {
        binding.btDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawer.open();
            }
        });


        binding.layoutContentStories.btBack.setOnClickListener(view -> {
            index-- ;
            if(index < 0 )
            {
                index = listSt.size()-1 ;
                stoiresAndStories();
            }else
            {
                stoiresAndStories();
            }
        });
        binding.layoutContentStories.btNext.setOnClickListener(view -> {
            index++ ;
            if(index > (listSt.size()-1))
            {
                index = 0 ;
                stoiresAndStories();
            }else{
                stoiresAndStories();
            }
        });
    }

    private void stoiresAndStories() {
        binding.layoutContentStories.tvNameStories.setText(listSt.get(index).NameStory);
        binding.layoutContentStories.tvStoriess.setText(listSt.get(index).DetailStories);
    }

    private void importStories() {
        AssetManager ast = getAssets()  ;
        listSt = new ArrayList<>()  ;
            try{
                InputStream in = ast.open("data/cuchai.txt") ;
                InputStreamReader inSR =new InputStreamReader(in, StandardCharsets.UTF_8) ;
                BufferedReader reader = new BufferedReader(inSR) ;

                String name = null ;
                StringBuilder content = new StringBuilder() ;
                String line = reader.readLine() ;
                while(line != null)
                {
                   if(name==null)
                       name = line ;
                   else if(line.contains("','0');"))
                   {
                       DetailStories dtStories = new DetailStories(name,content.toString()) ;
                       listSt.add(dtStories) ;
                       name = null ;
                       content = new StringBuilder() ;
                   }else if(!line.isEmpty())
                   {
                       content.append(line).append("\n") ;
                   } line = reader.readLine() ;
                }
                in.close();
                inSR.close();
                reader.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    private void importTopic() { AssetManager ast = getAssets() ;
        try {
            String[] stories = ast.list("photo/") ;
            binding.lnTopicStories.lnTopicStories.removeAllViews();
            for (String a : stories
            ) {
                InputStream in =  ast.open("photo/"+ a) ;
                Bitmap btmp = BitmapFactory.decodeStream(in) ;
                View itemview = LayoutInflater.from(this).inflate(R.layout.layout_topic,null) ;
                TextView tv =  itemview.findViewById(R.id.tv_name);
                String az = a.replace(".PNG","") ;
                String ac = az.replace(".png","") ;
                tv.setText(ac);
                ImageView imv = itemview.findViewById(R.id.iv_photo) ;
                imv.setImageBitmap(btmp);
                binding.lnTopicStories.lnTopicStories.addView(itemview);
                itemview.setTag(tv.getText().toString());
                itemview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                                    openTopic(view) ;
                    }
                });
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void openTopic(View viewTopic) {
                viewTopic.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
                binding.drawer.close();
                String topicName = viewTopic.getTag().toString();
                binding.tvNameStories.setText(topicName);
                showListStories(topicName);

    }

    private void showListStories(String topicName) {
                    topicName = topicName.replace(".png","") ;
        listSt.remove(DetailStories.class) ;
        listSt = new ArrayList<>()  ;
                    AssetManager asgt = getAssets() ;
                    try{
                        InputStream in =  asgt.open("photo/"+topicName+".txt") ;
                        InputStreamReader istr = new InputStreamReader(in,StandardCharsets.UTF_8) ;
                        BufferedReader bfferRD = new BufferedReader(istr) ;
                        String line = bfferRD.readLine() ;
                        String name = null ;
                        StringBuilder content = new StringBuilder() ;
                        while(line != null )
                        {
                               if(name == null)
                                        name = line ;
                               else if(line.contains("','0');"))
                               {
                                   DetailStories dtStories = new DetailStories(name,content.toString()) ;
                                   listSt.add(dtStories) ;
                                   name = null  ;
                                   content = new StringBuilder() ;
                               }else if(!line.isEmpty())
                               {
                                   content.append(line).append("\n") ;
                               }
                               line = bfferRD.readLine() ;
                        }
                        in.close();
                        istr.close();
                        bfferRD.close();
                        index =  0   ;
                        binding.layoutContentStories.tvNameStories.setText(listSt.get(0).NameStory);
                        binding.layoutContentStories.tvStoriess.setText(listSt.get(0).DetailStories);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
    }

    @Override
    protected ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}