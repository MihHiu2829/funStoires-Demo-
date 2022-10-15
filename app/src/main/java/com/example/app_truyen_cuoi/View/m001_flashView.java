package com.example.app_truyen_cuoi.View;

import android.content.Intent;
import android.os.Handler;

import com.example.app_truyen_cuoi.ViewModel.m001_flashVM;
import com.example.app_truyen_cuoi.databinding.M000SflashBinding;

public class m001_flashView extends base_ACT<M000SflashBinding, m001_flashVM> {
    @Override
    protected Class<m001_flashVM> ClassVM() {
        return m001_flashVM.class;
    }

    @Override
    protected void initViews() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        gotoMain();
                    }
            }, 1000 ) ;
    }

    private void gotoMain() {
        startActivity(new Intent().setClass(this, MainActivity.class));
        finish() ;

    }

    @Override
    protected M000SflashBinding initViewBinding() {
        return M000SflashBinding.inflate(getLayoutInflater());
    }
}
