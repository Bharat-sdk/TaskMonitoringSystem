package com.makertech.taskmonitoringsystem.ui.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

abstract public class BaseViewHolder<D,V extends ViewBinding> extends RecyclerView.ViewHolder {
    private final V viewBinding;
    public BaseViewHolder(V v) {
        super(v.getRoot());
        viewBinding = v;
    }

    public V getViewBinding() {
        return viewBinding;
    }

    protected abstract void bind(D d);
}