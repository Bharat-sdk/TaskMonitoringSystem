package com.makertech.taskmonitoringsystem.api.repository;

import com.makertech.taskmonitoringsystem.api.ApiServices;
import com.makertech.taskmonitoringsystem.api.TmsTask;

import java.util.List;

import retrofit2.Call;

public class RepositoryImplimentation implements AppRepository{
    ApiServices apiServices;
    public RepositoryImplimentation(ApiServices apiServices) {
        this.apiServices = apiServices;
    }


    @Override
    public Call<List<TmsTask>> getTmsTaskList() {
        return apiServices.getTmsTaskList();
    }

    @Override
    public Call<TmsTask> createTmsTask(TmsTask tmsTask) {
        return apiServices.createTmsTask(tmsTask);
    }
}
