package com.example.truynkhngci.View;

import com.example.truynkhngci.Adapter.viewPagerAdapter;
import com.example.truynkhngci.ViewModel.Common_VM;
import com.example.truynkhngci.databinding.M002ViewpagerContentBinding;

public class m002_viewPager extends base_Act<M002ViewpagerContentBinding, Common_VM> {
    @Override
    protected void initViews() {

        viewPagerAdapter adapter = new viewPagerAdapter(this, App.getInstance().getStorage().list) ;
            binding.vpStory.setAdapter(adapter);


            int isSlected = App.getInstance().getStorage().list.indexOf(App.getInstance().getStorage().story);
            binding.vpStory.setCurrentItem(isSlected);
    }



    @Override
    protected Class<Common_VM> ClassVM() {
        return Common_VM.class;
    }

    @Override
    protected M002ViewpagerContentBinding initViewBinding() {
        return M002ViewpagerContentBinding.inflate(getLayoutInflater());
    }
}
