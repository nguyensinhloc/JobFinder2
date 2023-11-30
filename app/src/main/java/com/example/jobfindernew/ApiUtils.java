package com.example.jobfindernew;

public class ApiUtils {

    public static final String BASE_URL = "https://your-api-base-url.com/";

    public static JobPostApi getJobPostApi() {
        return RetrofitClient.getClient().create(JobPostApi.class);
    }

    public static JobApplicationApi getJobApplicationApi() {
        return RetrofitClient.getClient().create(JobApplicationApi.class);
    }

}

