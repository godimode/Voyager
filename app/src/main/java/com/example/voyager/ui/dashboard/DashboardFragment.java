package com.example.voyager.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.voyager.R;
import com.example.voyager.databinding.FragmentDashboardBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DashboardViewModel dashboardViewModel;
    private DashboardAdapter dashboardAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        binding.setDashboard(dashboardViewModel);
        binding.rvDashboard.setHasFixedSize(true);

        dashboardAdapter = new DashboardAdapter(requireContext());
        binding.rvDashboard.setAdapter(dashboardAdapter);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        binding.rvDashboard.setLayoutManager(mLinearLayoutManager);

        dashboardViewModel.getUserMutableLiveData().observe(getViewLifecycleOwner(), itemUpdateObserver);

        return binding.getRoot();
    }

    private Observer<ArrayList<DashboardItem>> itemUpdateObserver = new Observer<ArrayList<DashboardItem>>() {
        @Override
        public void onChanged(ArrayList<DashboardItem> dashboardItems) {
            dashboardAdapter.setData(dashboardItems);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}