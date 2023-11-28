package com.example.jobfindernew;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_register);

        this.editTextEmail = this.findViewById(R.id.editTextEmail);
        this.editTextPassword = this.findViewById(R.id.editTextPassword);
        this.btnRegister = this.findViewById(R.id.btn_register);

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                RegisterActivity.this.registerUser();
            }
        });
    }

    private void registerUser() {
        // Lấy dữ liệu từ EditText
        final String email = this.editTextEmail.getText().toString();
        final String password = this.editTextPassword.getText().toString();

        // Tạo một User mới
        final User newUser = new User();
        newUser.email = email;
        newUser.password = password;

        // Thêm User mới vào cơ sở dữ liệu
        final AppDatabase appDatabase = DatabaseInitializer.initializeDatabase(this.getApplicationContext());
        final UserDao userDao = appDatabase.userDao();
        userDao.insert(newUser);

        // Đóng cơ sở dữ liệu sau khi thêm User
        DatabaseInitializer.destroyInstance();

        // (Optional) Hiển thị thông báo hoặc chuyển đến màn hình khác sau khi đăng ký thành công
    }
}