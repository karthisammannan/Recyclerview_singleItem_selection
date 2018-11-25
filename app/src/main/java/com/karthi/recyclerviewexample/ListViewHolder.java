package com.karthi.recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.karthi.recyclerviewexample.Model.Item;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.tvw_version_name)
    TextView tvwMusicName;
    Item mItem;
    private RecyclerViewClickListener mListener;

    public ListViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
        super(itemView);
        this.mListener = listener;
        itemView.setOnClickListener(this);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Item mItem) {
        this.mItem = mItem;
        tvwMusicName.setText(mItem.getvName());
    }

    @Override
    public void onClick(View view) {
        mListener.onClick(view, getAdapterPosition());
    }
}
