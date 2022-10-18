package com.example.app_truyen_cuoi.View;

import androidx.viewbinding.ViewBinding;

import com.example.app_truyen_cuoi.View.base_ACT;
import com.example.app_truyen_cuoi.ViewModel.m001_VMrecycelerView;
import com.example.app_truyen_cuoi.databinding.RecyclevviewExBinding;

public class recyclevviewM001 extends base_ACT<RecyclevviewExBinding, m001_VMrecycelerView> {

    @Override
    protected Class<m001_VMrecycelerView> ClassVM() {
        return m001_VMrecycelerView.class;
    }

    @Override
    protected void initViews() {





    }

    @Override
    protected RecyclevviewExBinding initViewBinding() {
        return RecyclevviewExBinding.inflate(getLayoutInflater());
    }
}
