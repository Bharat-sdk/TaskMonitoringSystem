package com.makertech.taskmonitoringsystem.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity <V extends ViewDataBinding,VM extends BaseViewModel>  extends AppCompatActivity {

    private V viewBinding;
    private VM viewModel;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this,getLayoutId());
        viewModel = initialViewModel();
        viewBinding.setVariable(getBindingVariable(),viewModel);
        viewBinding.executePendingBindings();
        initView();
    }

    /***
     * it is used to do work related to specific requirements of  sub class related to view
     */
    protected abstract void initView();

    /***
     *  It is used to provide layout id specific to your child class
     * @return
     */
    protected abstract Integer getBindingVariable();

    /***
     *
     * @return
     */
    protected   abstract VM initialViewModel();
    protected abstract Integer getLayoutId();
    public V getViewBinding() {
        return viewBinding;
    }

    public VM getViewModel() {
        return viewModel;
    }

}


