package com.makertech.taskmonitoringsystem.ui.NewTask;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.makertech.taskmonitoringsystem.ui.base.BaseViewModel;
import com.makertech.taskmonitoringsystem.api.TmsTask;
import com.makertech.taskmonitoringsystem.api.repository.AppRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewActivityViewModel extends BaseViewModel {
    private MutableLiveData<List<TmsTask>> getTmsTasks;
    private MutableLiveData<TmsTask> newTmsTasks;
    public NewActivityViewModel(AppRepository appRepository) {
        super(appRepository);
        getTmsTasks = new MutableLiveData<>();
        newTmsTasks = new MutableLiveData<>();
    }

    public NewActivityViewModel() {

    }

    public MutableLiveData<List<TmsTask>> getTmsTasks() {
        return getTmsTasks;
    }

    public MutableLiveData<TmsTask> getNewTmsTasks() {
        return newTmsTasks;
    }


    public void setTmsTasks(TmsTask tmsTask)
    {
        getAppRepository().createTmsTask(tmsTask).enqueue(new Callback<TmsTask>() {
            @Override
            public void onResponse(Call<TmsTask> call, Response<TmsTask> response) {
                newTmsTasks.postValue(response.body());
            }

            @Override
            public void onFailure(Call<TmsTask> call, Throwable t) {
                newTmsTasks.postValue(null);
            }
        });
    }

}
