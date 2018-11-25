package com.karthi.recyclerviewexample.Model;

import android.arch.lifecycle.ViewModel;

import java.util.List;

public class ItemList extends ViewModel {
    List<Item> versionList;
    private int position;
    public List<Item> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<Item> versionList) {
        this.versionList = versionList;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
