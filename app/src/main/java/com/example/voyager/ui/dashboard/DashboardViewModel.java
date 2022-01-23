package com.example.voyager.ui.dashboard;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class DashboardViewModel extends ViewModel {

    MutableLiveData<ArrayList<DashboardItem>> itemLiveData;
    ArrayList<DashboardItem> userArrayList;

    public DashboardViewModel() {
        itemLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<DashboardItem>> getUserMutableLiveData() {
        return itemLiveData;
    }

    public void init() {
        populateList();
        itemLiveData.postValue(userArrayList);
        //itemLiveData.setValue(userArrayList);
    }

    public void addItem(DashboardItem item) {
        userArrayList.add(item);
        itemLiveData.postValue(userArrayList);
    }

    public void deleteItem(DashboardItem item) {
        userArrayList.remove(item);
    }

    public void populateList() {

        DashboardItem item = new DashboardItem("2022/01/23 11:23:45", "2022/01/23 12:34:32", "90");
        DashboardItem item1 = new DashboardItem("2022/01/24 11:23:45", "2022/01/24 12:34:32", "90");
        DashboardItem item2 = new DashboardItem("2022/01/25 11:23:45", "2022/01/25 12:34:32", "90");
        DashboardItem item3 = new DashboardItem("2022/01/26 11:23:45", "2022/01/26 12:34:32", "90");
        DashboardItem item4 = new DashboardItem("2022/01/27 11:23:45", "2022/01/27 12:34:32", "90");
        DashboardItem item5 = new DashboardItem("2022/01/28 11:23:45", "2022/01/28 12:34:32", "90");

        userArrayList = new ArrayList<>();
        userArrayList.add(item);
        userArrayList.add(item1);
        userArrayList.add(item2);
        userArrayList.add(item3);
        userArrayList.add(item4);
        userArrayList.add(item5);
    }

    public void fabClick(View view) {
        Toast.makeText(view.getContext(), "aaa", Toast.LENGTH_LONG).show();
        DashboardItem item = new DashboardItem("2022/01/23 11:23:45", "2022/01/23 12:34:32", "90");
        DashboardItem item1 = new DashboardItem("2022/01/24 11:23:45", "2022/01/24 12:34:32", "90");
        DashboardItem item2 = new DashboardItem("2022/01/25 11:23:45", "2022/01/25 12:34:32", "90");
        addItem(item);
        addItem(item1);
        addItem(item2);
    }
}