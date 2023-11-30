package com.example.jobfindernew;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobPostRepository {

    private final JobPostDao jobPostDao;
    private final LiveData<List<JobPost>> allJobPosts;
    private final JobPostApi jobPostApi;

    public JobPostRepository(final Application application) {
        final AppDatabase database = AppDatabase.getInstance(application);
        this.jobPostDao = database.jobPostDao();
        this.allJobPosts = (LiveData<List<JobPost>>) this.jobPostDao.getAllJobPosts();
        this.jobPostApi = ApiUtils.getJobPostApi();
    }

    public LiveData<List<JobPost>> getAllJobPosts() {
        return this.allJobPosts;
    }

    public void insert(final JobPost jobPost) {
        // Thêm phương thức này nếu bạn muốn chèn một bản ghi mới
        // jobPostDao.insert(jobPost);

        // Gửi yêu cầu tạo tin tuyển dụng qua API
        Call<Void> call = jobPostApi.createJobPost(jobPost);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                // Xử lý phản hồi thành công từ API nếu cần
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Xử lý lỗi nếu có
            }
        });
    }

    // Thêm các phương thức khác nếu cần thiết (ví dụ: update, delete)


}
