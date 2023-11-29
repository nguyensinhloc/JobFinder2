package com.example.jobfindernew;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface JobApplicationDao {
    @Insert
    void insert(JobApplication jobApplication);

    @Update
    void update(JobApplication jobApplication);

    @Delete
    void delete(JobApplication jobApplication);

    @Query("SELECT * FROM JobApplication WHERE applicationId = :applicationId")
    JobApplication getJobApplicationById(int applicationId);

    @Query("SELECT * FROM JobApplication WHERE userId = :userId")
    List<JobApplication> getApplicationsByUserId(int userId);

    @Query("SELECT * FROM JobApplication WHERE jobId = :jobId")
    List<JobApplication> getApplicationsByJobId(int jobId);

    @Query("SELECT * FROM JobApplication")
    List<JobApplication> getAllJobApplications();

}

