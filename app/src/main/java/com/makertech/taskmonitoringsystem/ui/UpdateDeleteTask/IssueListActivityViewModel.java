package com.makertech.taskmonitoringsystem.ui.UpdateDeleteTask;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.android.material.tabs.TabLayout;
import com.makertech.taskmonitoringsystem.api.TmsTask;
import com.makertech.taskmonitoringsystem.api.repository.AppRepository;
import com.makertech.taskmonitoringsystem.ui.base.BaseViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueListActivityViewModel extends BaseViewModel {

    private MutableLiveData<List<TmsTask>> getTmsTasks;
    public IssueListActivityViewModel(AppRepository appRepository) {
        super(appRepository);
        getTmsTasks = new MutableLiveData<>();
    }

    public MutableLiveData<List<TmsTask>> getTmsTasks() {
        return getTmsTasks;
    }


    public void getTmsTasksList()
    {
        getAppRepository().getTmsTaskList().enqueue(new Callback<List<TmsTask>>() {
            @Override
            public void onResponse(Call<List<TmsTask>> call, Response<List<TmsTask>> response) {
                getTmsTasks.postValue(response.body());
                Log.d("myapp", "getting a response "+response.body());

            }

            @Override
            public void onFailure(Call<List<TmsTask>> call, Throwable t) {
                getTmsTasks.postValue(null);
            }
        });


    }
}
