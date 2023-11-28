package com.example.jobfindernew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    private UserDao userDao;
    private User currentUser;
    private EditText etFullName;
    private EditText etEmail;
    private Button btnUpdate;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_account);


        // Tìm nút btn_logout bằng id
        final Button btnLogout = this.findViewById(R.id.btn_logout);

        // Đặt lắng nghe sự kiện click cho nút btn_logout
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // Xử lý khi nút btn_logout được click
                AccountActivity.this.logout(); // Gọi phương thức logout để chuyển sang LoginActivity
            }
        });
    }

    // Phương thức để chuyển sang LoginActivity
    private void logout() {
        final Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
        this.finish(); // Đóng Activity hiện tại nếu muốn
    }
}