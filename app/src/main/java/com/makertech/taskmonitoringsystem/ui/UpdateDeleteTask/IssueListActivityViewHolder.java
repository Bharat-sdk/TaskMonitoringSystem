package com.makertech.taskmonitoringsystem.ui.UpdateDeleteTask;

import com.makertech.taskmonitoringsystem.databinding.ItemIssueListBinding;
import com.makertech.taskmonitoringsystem.ui.base.BaseViewHolder;
import com.makertech.taskmonitoringsystem.api.TmsTask;

public class IssueListActivityViewHolder extends BaseViewHolder<TmsTask,ItemIssueListBinding> {

    public IssueListActivityViewHolder(ItemIssueListBinding itemIssueListBinding) {
        super(itemIssueListBinding);
    }

    @Override
    protected void bind(TmsTask tmsTask) {
        getViewBinding().itemTxtCategory.setText(tmsTask.getCategory());
        getViewBinding().itemTxtIssueTask.setText(tmsTask.getTaskSubject());
        getViewBinding().itemTxtPriority.setText(tmsTask.getPriority());
        getViewBinding().itemTxtTargetDate.setText(tmsTask.getTargetDate());
    }
}
