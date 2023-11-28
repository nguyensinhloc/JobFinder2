package com.example.jobfindernew;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "JobPost", foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "userId",
        childColumns = "userId",
        onDelete = ForeignKey.CASCADE))
public class JobPost {
    @PrimaryKey
    public int jobId;

    @ColumnInfo(name = "userId")
    public int userId;

    public String position;
    public String industry;
    public String description;
    public String requirements;
    public String location;

    @ColumnInfo(name = "contactInfo")
    public String contactInfo;

    @ColumnInfo(name = "createdAt")
    public String createdAt;

    public String getPosition() {
        return this.position;
    }

    public String getIndustry() {
        return this.industry;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDescription() {
        return this.description;
    }
}

