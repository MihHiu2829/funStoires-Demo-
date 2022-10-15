package com.example.app_truyen_cuoi.View;

public class DetailStories {
        String NameStory ;
        String DetailStories ;

    public DetailStories(String nameStory, String detailStories) {
        NameStory = nameStory;
        DetailStories = detailStories;
    }

    public String getNameStory() {
        return NameStory;
    }

    public void setNameStory(String nameStory) {
        NameStory = nameStory;
    }

    public String getDetailStories() {
        return DetailStories;
    }

    public void setDetailStories(String detailStories) {
        DetailStories = detailStories;
    }
}
