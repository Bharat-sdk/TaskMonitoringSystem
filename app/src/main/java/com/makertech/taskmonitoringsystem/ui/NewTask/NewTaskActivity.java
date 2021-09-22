package com.makertech.taskmonitoringsystem.ui.NewTask;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.makertech.taskmonitoringsystem.BR;
import com.makertech.taskmonitoringsystem.R;
import com.makertech.taskmonitoringsystem.databinding.NewTaskActivityBinding;
import com.makertech.taskmonitoringsystem.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewTaskActivity extends BaseActivity<NewTaskActivityBinding,NewActivityViewModel> {

    @Override
    protected void initView() {
        setSpinnerValue(createYearList(),getViewBinding().yearSpinner);

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

    public List<String> createYearList(){
        List<String> yearList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int currentYear =  calendar.get(Calendar.YEAR);
        for (int i = currentYear; i<=2080; i++)
        {
            yearList.add(String.valueOf(i));
        }

        return yearList;
    }

    public void setSpinnerValue(List<String> dataList , Spinner spinner)
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.spin_text_view, dataList);
        arrayAdapter.setDropDownViewResource(R.layout.spin_dropdown_text_view);
        spinner.setAdapter(arrayAdapter);
    }
}
