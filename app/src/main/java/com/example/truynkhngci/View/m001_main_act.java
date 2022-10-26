package com.example.truynkhngci.View;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.Observer;

import com.example.truynkhngci.Adapter.menuTopicAdapter;
import com.example.truynkhngci.R;
import com.example.truynkhngci.ViewModel.m001_ViewModel;
import com.example.truynkhngci.databinding.M001MainActBinding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class m001_main_act extends base_Act<M001MainActBinding, m001_ViewModel> {


    private menuTopicAdapter adapter ;



    @Override
    protected void initViews() {
        binding.tvToolBar.btM000Menu.setOnClickListener(v -> OpenMenu(v));

        importListTopic();
    }

    private void OpenMenu(View v) {
            v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
            binding.loDawer.open();

    }

//    private void importListTopic2() {
//        AssetManager ast = getAssets() ;
//        try{
//            List<String> stories = Arrays.asList(ast.list("photo/ "));
//            List<InputStream>  inList = new ArrayList<>() ;
//            for (String a :
//                 stories) {
//                            InputStream in = ast.open("photo"+a) ;
//                            inList.add(in);
//            }
//            binding.rycView.setAdapter(new topicAdapter(this,stories,inList));
//
//
//
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

    private void importListTopic() {
        AssetManager ast = getAssets();
    binding.lnTopic.removeAllViews() ;
        try{
            String[] stories = ast.list("photo/") ;
            for (String a :
                    stories  ) {
                InputStream in = ast.open("photo/"+ a ) ;

                View view = LayoutInflater.from(this).inflate(R.layout.m001_componet_view,null)   ;
                TextView tv_topic = view.findViewById(R.id.tv_nameTopic);
                ImageView img = view.findViewById(R.id.img_Topic) ;
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                String b = a.replace(".PNG","");
                String c = b.replace(".png","");
                String d = c.replace(".JPG","");
                tv_topic.setText(d);
                img.setImageBitmap(bitmap);
                view.setTag(d) ;
                binding.lnTopic.addView(view);
                view.setOnClickListener(v-> gotoMainDawer(view));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void gotoMainDawer(View view) {
            view.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
            binding.loDawer.close();
            binding.tvToolBar.tvM000Topic.setText(view.getTag().toString());
            setup_MenuTopic(view.getTag().toString());
    }

    private void setup_MenuTopic(String source) {
        List<story> list = new ArrayList<>() ;
        AssetManager ast = getAssets() ;
        try{
                InputStream in = ast.open("data/"+ source +".txt") ;
            InputStreamReader isrd = new InputStreamReader(in) ;
            BufferedReader reader = new BufferedReader(isrd) ;
            String line = reader.readLine() ;
            String name = null ;
            StringBuilder content = new StringBuilder() ;
            while(line != null)
            {
                if(name == null) name = line ;
               else if(line.contains("','0');"))
                {
                    story story = new story(name,content.toString()) ;
                    list.add(story) ;
                    name = null ;
                    content = new StringBuilder() ;
                }else if(!line.isEmpty())
                    content.append(line).append("\n") ;
               line = reader.readLine() ;
            }
            in.close();
            isrd.close(); ;
            reader.close();
            adapter = new menuTopicAdapter(this,list) ;

            binding.rycView.setAdapter(adapter);

            adapter.getList().observe(this, new Observer<story>() {
                @Override
                public void onChanged(story stories) {
                    App.getInstance().getStorage().list = list ;
                    App.getInstance().getStorage().story = stories ;
                    gotoM002();
                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    private void gotoM002() {
        startActivity(new Intent(this,m002_viewPager.class));
    }


    @Override
    protected Class<m001_ViewModel> ClassVM() {
        return m001_ViewModel.class;
    }

    @Override
    protected M001MainActBinding initViewBinding() {
        return M001MainActBinding.inflate(getLayoutInflater());
    }
}