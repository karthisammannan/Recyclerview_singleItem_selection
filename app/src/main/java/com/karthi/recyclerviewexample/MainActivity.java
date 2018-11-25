package com.karthi.recyclerviewexample;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.karthi.recyclerviewexample.Adapter.ListAdpter;
import com.karthi.recyclerviewexample.Model.Item;
import com.karthi.recyclerviewexample.Model.ItemList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvw_list)
    RecyclerView rvwList;
    List<Item> versionList = new ArrayList<>();
    LinearLayoutManager layoutManager;ItemList mViewModel;
    public static int selectPOs = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mViewModel = ViewModelProviders.of(this).get(ItemList.class);
        selectPOs = mViewModel.getPosition();

        layoutManager = new LinearLayoutManager(this);
        rvwList.setLayoutManager(layoutManager);
        rvwList.setItemAnimator(new DefaultItemAnimator());
        ListAdpter.ClickListener mListner = position -> {
            mViewModel.setPosition(position);
        };
        //LoadData
        loadData();
        ListAdpter adapter = new ListAdpter(mViewModel.getVersionList(),this,mListner);
        rvwList.setAdapter(adapter);
    }
    void loadData() {
        for (int i = 0; i < 2; i++) {
            versionList.add(new Item("Cupcake", false));
            versionList.add(new Item("Donut", false));
            versionList.add(new Item("Eclair", false));
            versionList.add(new Item("Froyo", false));
            versionList.add(new Item("Gingerbread", false));
            versionList.add(new Item("Honeycomb", false));
            versionList.add(new Item("Ice Cream Sandwich", false));
            versionList.add(new Item("JellyBean", false));
            versionList.add(new Item("Kitkat", false));
            versionList.add(new Item("Lollipop", false));
            versionList.add(new Item("Marshmallow", false));
        }
        mViewModel.setVersionList(versionList);
    }
}
