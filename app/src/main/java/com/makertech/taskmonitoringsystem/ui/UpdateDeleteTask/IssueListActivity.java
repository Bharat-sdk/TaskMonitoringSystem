package com.makertech.taskmonitoringsystem.ui.UpdateDeleteTask;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.makertech.taskmonitoringsystem.BR;
import com.makertech.taskmonitoringsystem.R;
import com.makertech.taskmonitoringsystem.api.TmsTask;
import com.makertech.taskmonitoringsystem.api.apiClient.ApiClient;
import com.makertech.taskmonitoringsystem.api.repository.AppRepository;
import com.makertech.taskmonitoringsystem.api.repository.RepositoryImplimentation;
import com.makertech.taskmonitoringsystem.databinding.IssueListActivityBinding;
import com.makertech.taskmonitoringsystem.ui.base.BaseActivity;

import java.util.List;

public class IssueListActivity extends BaseActivity<IssueListActivityBinding,IssueListActivityViewModel> {
    ApiClient apiClient = new ApiClient();
    @Override
    protected void initView() {
        setObserver();
        initialViewModel().getTmsTasksList();





    }

    @Override
    protected Integer getBindingVariable() {
        return BR._all;
    }

    @Override
    protected IssueListActivityViewModel initialViewModel() {
        return new IssueListActivityViewModel(new RepositoryImplimentation(apiClient.getService()));
    }

    @Override
    protected Integer getLayoutId() {
        return R.layout.issue_list_activity;
    }

    private void setObserver()
    {
        initialViewModel().getTmsTasks().observe(this, new Observer<List<TmsTask>>() {
            @Override
            public void onChanged(List<TmsTask> tmsTasks) {


                    Toast.makeText(getApplicationContext(),"Tasks Allotted",Toast.LENGTH_LONG).show();
                    Log.d("myapp", "is not Empty "+String.valueOf(tmsTasks.size()));
                IssueListActivityAdapter issueListActivityAdapter = new IssueListActivityAdapter(tmsTasks);
                getViewBinding().recyclerViewIssueList.setAdapter(issueListActivityAdapter);
            }
        });
    }
}
