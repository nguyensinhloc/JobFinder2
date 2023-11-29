package com.example.jobfindernew;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class JobPostViewModel extends ViewModel {

    private final JobPostRepository repository;
    private final LiveData<List<JobPost>> allJobPosts;

    public JobPostViewModel(final Application application) {
        this.repository = new JobPostRepository(application);
        this.allJobPosts = this.repository.getAllJobPosts();
    }

    public LiveData<List<JobPost>> getAllJobPosts() {
        return this.allJobPosts;
    }
}
