package com.makertech.taskmonitoringsystem.ui.UpdateDeleteTask;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.makertech.taskmonitoringsystem.R;
import com.makertech.taskmonitoringsystem.api.TmsTask;
import com.makertech.taskmonitoringsystem.databinding.ItemIssueListBinding;

import java.util.List;

public class IssueListActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TmsTask> tmsTaskList;

    public IssueListActivityAdapter(List<TmsTask> tmsTaskList) {
        this.tmsTaskList = tmsTaskList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIssueListBinding itemIssueListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_issue_list,parent,false);
        return new IssueListActivityViewHolder(itemIssueListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            TmsTask tmsTask = tmsTaskList.get(position);
            IssueListActivityViewHolder issueListActivityViewHolder = (IssueListActivityViewHolder) holder;
            issueListActivityViewHolder.bind(tmsTask);
        Log.d("myapp", "onBindViewHolder: "+tmsTask.toString());
    }

    @Override
    public int getItemCount() {
        return tmsTaskList.size();
    }
}
