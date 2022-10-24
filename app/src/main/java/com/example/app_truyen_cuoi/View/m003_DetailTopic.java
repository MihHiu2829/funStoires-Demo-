package com.example.app_truyen_cuoi.View;

import com.example.app_truyen_cuoi.App;
import com.example.app_truyen_cuoi.COMMON_VM;
import com.example.app_truyen_cuoi.adapter.detailStoriesAdapter;
import com.example.app_truyen_cuoi.databinding.M003DetailtopicBinding;

public class m003_DetailTopic extends base_ACT<M003DetailtopicBinding, COMMON_VM> {
    @Override
    protected Class<COMMON_VM> ClassVM() {
        return COMMON_VM.class;
    }

    @Override
    protected void initViews() {
        detailStoriesAdapter adapter = new detailStoriesAdapter(this, App.getInstance().getStoragee().listStory) ;
        binding.vpStories.setAdapter(adapter);



        //goto selected story
        int Selected = App.getInstance().getStoragee().listStory.indexOf(App.getInstance().getStoragee().storyy) ;
        binding.vpStories.setCurrentItem(Selected,true);
    }

    @Override
    protected M003DetailtopicBinding initViewBinding() {
        return M003DetailtopicBinding.inflate(getLayoutInflater());
    }
}
