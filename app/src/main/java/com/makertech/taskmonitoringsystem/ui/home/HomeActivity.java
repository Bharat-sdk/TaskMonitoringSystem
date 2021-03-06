package com.makertech.taskmonitoringsystem.ui.home;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.makertech.taskmonitoringsystem.BR;
import com.makertech.taskmonitoringsystem.R;
import com.makertech.taskmonitoringsystem.databinding.HomeActivityBinding;
import com.makertech.taskmonitoringsystem.ui.NewTask.NewTaskActivity;
import com.makertech.taskmonitoringsystem.ui.UpdateDeleteTask.IssueListActivity;
import com.makertech.taskmonitoringsystem.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity<HomeActivityBinding,HomeViewModel> {
    @Override
    protected void initView() {

        getViewBinding().newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewTaskActivity.class);
                startActivity(i);
            }
        });

        getViewBinding().updateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IssueListActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected Integer getBindingVariable() {
        return BR._all;
    }

    @Override
    protected HomeViewModel initialViewModel() {
        return new HomeViewModel();
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.home_activity;
    }


}
