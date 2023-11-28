package com.example.jobfindernew;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    private UserDao userDao;
    private User currentUser;

    private EditText etFullName;
    private EditText etEmail;
    private Button btnUpdate;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_update);

        // Khởi tạo UserDao
        this.userDao = DatabaseInitializer.getUserDao();

        // Lấy thông tin người dùng hiện tại từ Intent hoặc SharedPreferences hoặc bất kỳ phương tiện nào khác
        final int userId = this.getIntent().getIntExtra("userId", -1);
        if (-1 != userId) {
            this.currentUser = this.userDao.getUserById(userId);

            // Ánh xạ các thành phần giao diện
            this.etFullName = this.findViewById(R.id.et_full_name);
            this.etEmail = this.findViewById(R.id.et_email);
            this.btnUpdate = this.findViewById(R.id.btn_update);

            // Hiển thị thông tin hiện tại của người dùng
            this.etFullName.setText(this.currentUser.fullName);
            this.etEmail.setText(this.currentUser.email);

            // Xử lý sự kiện click của nút "Cập nhật thông tin"
            this.btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    // Cập nhật thông tin của người dùng
                    UpdateActivity.this.currentUser.fullName = UpdateActivity.this.etFullName.getText().toString();
                    UpdateActivity.this.currentUser.email = UpdateActivity.this.etEmail.getText().toString();

                    // Gọi hàm update của UserDao
                    UpdateActivity.this.userDao.update(UpdateActivity.this.currentUser);

                    // Xử lý sau khi cập nhật (ví dụ: trở về activity trước đó)
                    UpdateActivity.this.finish(); // Đóng activity hiện tại để trở về activity trước đó
                }
            });
        } else {
            // Xử lý trường hợp không có userId (ví dụ: thông báo lỗi, đóng activity, v.v.)
            Toast.makeText(this, "Không có thông tin người dùng", Toast.LENGTH_SHORT).show();
            this.finish(); // Đóng activity hiện tại nếu không có userId
        }
    }
}