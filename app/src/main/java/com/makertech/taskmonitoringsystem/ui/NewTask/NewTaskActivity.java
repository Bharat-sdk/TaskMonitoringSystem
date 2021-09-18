package com.makertech.taskmonitoringsystem.ui.NewTask;

import com.makertech.taskmonitoringsystem.BR;
import com.makertech.taskmonitoringsystem.R;
import com.makertech.taskmonitoringsystem.databinding.NewTaskActivityBinding;
import com.makertech.taskmonitoringsystem.ui.base.BaseActivity;

import java.util.prefs.BackingStoreException;

public class NewTaskActivity extends BaseActivity<NewTaskActivityBinding,NewActivityViewModel> {
    @Override
    protected void initView() {

    }

    @Override
    protected Integer getBindingVariable() {
        return BR._all;
    }

    @Override
    protected NewActivityViewModel initialViewModel() {
        return new NewActivityViewModel();
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.new_task_activity;
    }
}
