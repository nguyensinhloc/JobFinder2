package com.example.jobfindernew;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_apply);

        // Trong Activity hoặc Fragment
        final RecyclerView recyclerView = this.findViewById(R.id.rv_job_list);

// Tạo một LayoutManager để quy định cách hiển thị các item trong RecyclerView
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

// Lấy danh sách JobApplication từ cơ sở dữ liệu
        final List<JobApplication> jobApplications = DatabaseInitializer.getJobApplicationDao().getAllJobApplications();

// Tạo một Adapter và kết nối nó với RecyclerView
        final JobApplicationAdapter adapter = new JobApplicationAdapter(jobApplications);
        recyclerView.setAdapter(adapter);

    }
}