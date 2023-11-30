package com.example.jobfindernew;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JobApplicationApi {

    // Lấy danh sách tất cả các ứng tuyển
    @GET("job-applications")
    Call<List<JobApplication>> getJobApplications();

    // Lấy danh sách ứng tuyển theo userId
    @GET("job-applications/user/{userId}")
    Call<List<JobApplication>> getApplicationsByUserId(@Path("userId") int userId);

    // Lấy danh sách ứng tuyển theo jobId
    @GET("job-applications/job/{jobId}")
    Call<List<JobApplication>> getApplicationsByJobId(@Path("jobId") int jobId);

    // Tạo mới một ứng tuyển
    @POST("job-applications")
    Call<Void> createJobApplication(@Body JobApplication jobApplication);
}
