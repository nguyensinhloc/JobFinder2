package com.example.jobfindernew;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class JobPostRepository {
    private final JobPostDao jobPostDao;
    private final LiveData<List<JobPost>> allJobPosts;

    public JobPostRepository(final Application application) {
        final AppDatabase database = AppDatabase.getInstance(application);
        this.jobPostDao = database.jobPostDao();
        this.allJobPosts = (LiveData<List<JobPost>>) this.jobPostDao.getAllJobPosts();
    }

    public LiveData<List<JobPost>> getAllJobPosts() {
        return this.allJobPosts;
    }

    public void insert(final JobPost jobPost) {
        // Thêm phương thức này nếu bạn muốn chèn một bản ghi mới
        // jobPostDao.insert(jobPost);
    }

    // Thêm các phương thức khác nếu cần thiết (ví dụ: update, delete)
}
