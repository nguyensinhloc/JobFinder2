package com.example.jobfindernew;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ManageActivity extends AppCompatActivity {

    private JobPostViewModel jobPostViewModel;
    private JobPostAdapter jobPostAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        // Khởi tạo RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_job_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Khởi tạo ViewModel
        jobPostViewModel = new ViewModelProvider(this).get(JobPostViewModel.class);

        // Khởi tạo Adapter
        jobPostAdapter = new JobPostAdapter();

        // Gán Adapter cho RecyclerView
        recyclerView.setAdapter(jobPostAdapter);

        // Quan sát LiveData để cập nhật dữ liệu khi có thay đổi
        jobPostViewModel.getAllJobPosts().observe(this, new Observer<List<JobPost>>() {
            @Override
            public void onChanged(List<JobPost> jobPosts) {
                // Cập nhật dữ liệu mới cho Adapter
                jobPostAdapter.setJobPosts(jobPosts);
            }
        });
    }
}