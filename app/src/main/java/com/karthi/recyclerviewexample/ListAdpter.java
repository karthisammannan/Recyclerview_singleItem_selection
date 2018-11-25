package com.karthi.recyclerviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karthi.recyclerviewexample.Model.Item;

import java.util.List;

import static com.karthi.recyclerviewexample.MainActivity.selectPOs;

public class ListAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RecyclerViewClickListener {
    private List<Item> versionList;
    //int selectPOs = -1;
    Context context;ClickListener mClickListener;
    public ListAdpter(List<Item> musicList,Context context,ClickListener mListner) {
        this.versionList = musicList;
        this.context = context;
        this.mClickListener =mListner;
    }

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ListViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ListViewHolder) viewHolder).bind(versionList.get(position));
        if (position == selectPOs) {
            ((ListViewHolder) viewHolder).tvwMusicName.setBackgroundColor(context.getColor(R.color.selectionColor));
            ((ListViewHolder) viewHolder).tvwMusicName.
                    setTextColor(context.getColor(R.color.colorPrimaryDark));
        } else {
            ((ListViewHolder) viewHolder).tvwMusicName.setBackground(null);
            ((ListViewHolder) viewHolder).tvwMusicName.
                    setTextColor(context.getColor(R.color.textColor));
        }
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    @Override
    public void onClick(View view, int position) {
        //for multi selection
        // versionList.get(position).setSelected(true);

        selectPOs = position;
        notifyDataSetChanged();
        mClickListener.onPositionClicked(position);
    }
    interface ClickListener{
        void onPositionClicked(int poisition);
    }
}
