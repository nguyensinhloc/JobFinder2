package com.example.jobfindernew;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView rvNotificationList;
    private NotificationAdapter notificationAdapter;
    private NotificationDao notificationDao;
    private int userId;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_notification);

        this.rvNotificationList = this.findViewById(R.id.rv_notification_list);
        this.notificationDao = DatabaseInitializer.getNotificationDao();

        // Khởi tạo danh sách thông báo từ cơ sở dữ liệu
        final List<Notification> notifications = this.notificationDao.getNotificationsByUserId(this.userId); // Thay userId bằng id người dùng thích hợp

        // Khởi tạo adapter và thiết lập cho RecyclerView
        this.notificationAdapter = new NotificationAdapter(notifications);
        this.rvNotificationList.setLayoutManager(new LinearLayoutManager(this));
        this.rvNotificationList.setAdapter(this.notificationAdapter);
    }
}