package com.example.jobfindernew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JobApplicationAdapter extends RecyclerView.Adapter<JobApplicationAdapter.ViewHolder> {

    private final List<JobApplication> jobApplications;

    public JobApplicationAdapter(final List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job_application, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final JobApplication jobApplication = this.jobApplications.get(position);
        // Hiển thị thông tin của jobApplication trong ViewHolder
        // Ví dụ: holder.textView.setText(jobApplication.getStatus());
    }

    @Override
    public int getItemCount() {
        return this.jobApplications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Khai báo các View trong ViewHolder (ví dụ: TextView, ImageView)
        // public TextView textView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            // Ánh xạ các View vào ViewHolder
            // Ví dụ: textView = itemView.findViewById(R.id.textView);
        }
    }
}

