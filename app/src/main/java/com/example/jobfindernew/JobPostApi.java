package com.example.jobfindernew;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JobPostApi {

    @GET("job-posts")
    Call<List<JobPost>> getAllJobPosts();

    @GET("job-posts/{jobId}")
    Call<JobPost> getJobPostById(@Path("jobId") int jobId);

    @POST("job-posts")
    Call<Void> createJobPost(@Body JobPost jobPost);

    @PUT("job-posts/{jobId}")
    Call<Void> updateJobPost(@Path("jobId") int jobId, @Body JobPost jobPost);

    @DELETE("job-posts/{jobId}")
    Call<Void> deleteJobPost(@Path("jobId") int jobId);
}
