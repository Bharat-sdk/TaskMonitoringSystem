package com.makertech.taskmonitoringsystem.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @GET("tms")
    Call<List<TmsTask>> getTmsTaskList();

    @POST("tms")
    Call<TmsTask> createTmsTask(@Body TmsTask tmsTask);

}
