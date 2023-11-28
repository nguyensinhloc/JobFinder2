package com.example.jobfindernew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class JobPostAdapter extends ArrayAdapter<JobPost> {

    private final List<JobPost> jobPosts;

    public JobPostAdapter(final List<JobPost> jobPosts) {
        super(context, 0, jobPosts);
        this.jobPosts = jobPosts;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        if (null == convertView) {
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item_job_post, parent, false);
        }

        // Bind data to views
        final JobPost jobPost = this.getItem(position);
        if (null != jobPost) {
            final TextView tvTitle = convertView.findViewById(R.id.tv_title);
            final TextView tvPosition = convertView.findViewById(R.id.tv_position);
            final TextView tvIndustry = convertView.findViewById(R.id.tv_industry);
            final TextView tvLocation = convertView.findViewById(R.id.tv_location);

            tvTitle.setText(jobPost.getDescription());
            tvPosition.setText("Position: " + jobPost.getPosition());
            tvIndustry.setText("Industry: " + jobPost.getIndustry());
            tvLocation.setText("Location: " + jobPost.getLocation());
        }

        return convertView;
    }
}
