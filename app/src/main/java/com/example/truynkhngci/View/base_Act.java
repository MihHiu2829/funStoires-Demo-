package com.example.truynkhngci.View;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

public abstract class base_Act <T extends ViewBinding, M extends ViewModel> extends AppCompatActivity implements View.OnClickListener {
    T binding ; 
    M viewModel ;  
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding() ; 
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(ClassVM()) ;
        initViews(); 
    }

    protected abstract void initViews();

    protected abstract Class<M> ClassVM();

    protected abstract T initViewBinding();

    @Override
    public void onClick(View view) {
        
    }
}
