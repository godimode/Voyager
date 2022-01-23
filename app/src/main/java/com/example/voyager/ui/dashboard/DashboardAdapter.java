package com.example.voyager.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.voyager.R;
import com.example.voyager.databinding.DashboardItemBinding;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ItemViewHolder> {

    Context context;
    ArrayList<DashboardItem> dashboardItems = new ArrayList<DashboardItem>();
    DashboardItemBinding binding;

    public DashboardAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DashboardItem> dashboardItems) {
        this.dashboardItems = dashboardItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DashboardItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(dashboardItems.get(position));
    }

    @Override
    public int getItemCount() {
        return dashboardItems == null ? 0 : dashboardItems.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        DashboardItemBinding binding;

        public ItemViewHolder(DashboardItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(DashboardItem item) {
            binding.tvDashItemStartTime.setText(item.getStartTime());
            binding.tvDashItemEndTime.setText(item.getEndTime());
            binding.tvDashItemScore.setText(item.getScore());
        }
    }
}

class ItemClickListener {
    void onClick() {
        
    }
}
