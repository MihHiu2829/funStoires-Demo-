package com.example.truynkhngci.View;

import android.content.Intent;
import android.os.Handler;

import com.example.truynkhngci.ViewModel.Common_VM;
import com.example.truynkhngci.databinding.M000FlashBinding;

public class m000_flash extends base_Act<M000FlashBinding, Common_VM> {
    @Override
    protected void initViews() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    gotoMain() ;
                }
            },1000 ) ;
    }

    private void gotoMain() {
        startActivity(new Intent(this, m001_main_act.class));
        finish();
    }

    @Override
    protected Class<Common_VM> ClassVM() {
        return Common_VM.class;
    }

    @Override
    protected M000FlashBinding initViewBinding() {
        return M000FlashBinding.inflate(getLayoutInflater());
    }
}
