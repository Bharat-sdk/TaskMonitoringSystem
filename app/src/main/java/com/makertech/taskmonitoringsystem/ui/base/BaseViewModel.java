package com.makertech.taskmonitoringsystem.ui.base;

import androidx.lifecycle.ViewModel;

import com.makertech.taskmonitoringsystem.ui.data.api.repository.AppRepository;

public abstract class BaseViewModel  extends ViewModel {

    private AppRepository appRepository;

    public BaseViewModel() {
    }

    public BaseViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public AppRepository getAppRepository() {
        return appRepository;
    }
}