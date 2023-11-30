package com.example.jobfindernew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JobPostAdapter extends RecyclerView.Adapter<JobPostAdapter.ViewHolder> {

    private List<JobPost> jobPosts = new ArrayList<>();

    public void setJobPosts(List<JobPost> jobPosts) {
        this.jobPosts = jobPosts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobPost jobPost = jobPosts.get(position);

        holder.tvTitle.setText(jobPost.getDescription());
        holder.tvPosition.setText("Position: " + jobPost.getPosition());
        holder.tvIndustry.setText("Industry: " + jobPost.getIndustry());
        holder.tvLocation.setText("Location: " + jobPost.getLocation());
    }

    @Override
    public int getItemCount() {
        return jobPosts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPosition, tvIndustry, tvLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPosition = itemView.findViewById(R.id.tv_position);
            tvIndustry = itemView.findViewById(R.id.tv_industry);
            tvLocation = itemView.findViewById(R.id.tv_location);
        }
    }
}

