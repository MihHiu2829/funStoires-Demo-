package com.example.app_truyen_cuoi;

import android.os.storage.StorageManager;

import com.example.app_truyen_cuoi.View.DetailStories;

import java.util.ArrayList;
import java.util.List;

public class Storagee  {

    public List<DetailStories> listStory = new ArrayList<>();
    public DetailStories storyy   ;
    public void setStorage(List<DetailStories> lStory, DetailStories story)
    {
        listStory = new ArrayList<>(lStory) ;
        storyy = new DetailStories(story.getNameStory(),story.getDetailStories()) ;
    }
}
