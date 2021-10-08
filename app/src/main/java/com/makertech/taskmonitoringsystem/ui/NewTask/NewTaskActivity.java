package com.makertech.taskmonitoringsystem.ui.NewTask;

import android.app.DatePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.lifecycle.Observer;

import com.makertech.taskmonitoringsystem.BR;
import com.makertech.taskmonitoringsystem.R;
import com.makertech.taskmonitoringsystem.databinding.NewTaskActivityBinding;
import com.makertech.taskmonitoringsystem.ui.base.BaseActivity;
import com.makertech.taskmonitoringsystem.api.ApiServices;
import com.makertech.taskmonitoringsystem.api.TmsTask;
import com.makertech.taskmonitoringsystem.api.ApiClient;
import com.makertech.taskmonitoringsystem.api.repository.RepositoryImplimentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewTaskActivity extends BaseActivity<NewTaskActivityBinding,NewActivityViewModel> {
    Calendar calendar;
    String time;
    ApiClient apiClient = new ApiClient();

    @Override
    protected void initView() {


        setSpinnerValue(createYearList(),getViewBinding().yearSpinner);
        setSpinnerValue(createPriorityList(),getViewBinding().prioritySpinner);
        setSpinnerValue(createCategoryList(),getViewBinding().categorySpinner);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        calendar = Calendar.getInstance();



        setObserver();
        time = (simpleDateFormat.format(calendar.getTime()));
        getViewBinding().edtDate.setText(time);
        getViewBinding().edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                        time = (simpleDateFormat.format(calendar.getTime()));
                        getViewBinding().edtDate.setText(time);
                    }
                };
                new DatePickerDialog(NewTaskActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }


        });


        getViewBinding().btnSubmitNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                setNewTask(String.valueOf(calendar.getTimeInMillis()),
                        "allotted to",
                        "null",
                        getViewBinding().edtDate.getText().toString(),
                        getViewBinding().yearSpinner.getSelectedItem().toString(),
                        getViewBinding().edtNewIssue.getText().toString(),
                        getViewBinding().categorySpinner.getSelectedItem().toString(),
                        getViewBinding().prioritySpinner.getSelectedItem().toString()
                        );

                Toast.makeText(getApplicationContext(), "Task Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected Integer getBindingVariable() {
        return BR._all;
    }

    @Override

    protected NewActivityViewModel initialViewModel() {
        return new NewActivityViewModel(new RepositoryImplimentation(apiClient.getService()));
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.new_task_activity;
    }


    public List<String> createYearList(){
        List<String> yearList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int currentYear =  calendar.get(Calendar.YEAR);
        for (int i = currentYear; i<=2026; i++)
        {
            yearList.add(String.valueOf((i-1) + " - " + (i)));
        }

        return yearList;
    }

    public List<String> createPriorityList(){
        List<String> priorityList = new ArrayList<>();

        priorityList.add("High");
        priorityList.add("Medium");
        priorityList.add("Normal");

        return priorityList;
    }

    public List<String> createCategoryList(){
        List<String> categoryList = new ArrayList<>();

        categoryList.add("State");
        categoryList.add("Central");
        categoryList.add("CourtCases");
        categoryList.add("CMHelpline");

        return categoryList;
    }


    public void setSpinnerValue(List<String> dataList , Spinner spinner)
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.spin_text_view, dataList);
        arrayAdapter.setDropDownViewResource(R.layout.spin_dropdown_text_view);
        spinner.setAdapter(arrayAdapter);
    }

    private void setObserver()
    {
        initialViewModel().getTmsTasks().observe(this, new Observer<List<TmsTask>>() {
            @Override
            public void onChanged(List<TmsTask> tmsTasks) {
                if (tmsTasks.isEmpty())
                {
                    Log.d("myapp", "isEmpty "+String.valueOf(tmsTasks.size()));
                }
                else
                {
                    Log.d("myapp","is NotEmpty "+ String.valueOf(tmsTasks.size()));
                }
            }
        });
    }
    void setNewTask(String id, String allotedTo, String endDate,String targetDate, String year, String taskSubject,String category,String priority)
    {
        TmsTask tmsTask = new TmsTask();
        tmsTask.setId(id);
        tmsTask.setTaskSubject(taskSubject);
        tmsTask.setAllotedTo(allotedTo);
        tmsTask.setPriority(priority);
        tmsTask.setCategory(category);
        tmsTask.setYear(year);
        tmsTask.setEndDate(endDate);
        tmsTask.setTargetDate(targetDate);
        initialViewModel().setTmsTasks(tmsTask);
    }
}
