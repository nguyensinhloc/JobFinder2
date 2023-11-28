package com.example.jobfindernew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);

        this.etEmail = this.findViewById(R.id.et_email);
        this.etPassword = this.findViewById(R.id.et_password);
        this.btnLogin = this.findViewById(R.id.btn_login);

        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // Lấy dữ liệu từ EditText
                final String email = LoginActivity.this.etEmail.getText().toString().trim();
                final String password = LoginActivity.this.etPassword.getText().toString().trim();

                // Kiểm tra email và password trong cơ sở dữ liệu (đã được thêm vào trước đó)
                final User user = DatabaseInitializer.getUserDao().getUserByEmail(email);

                if (null != user && user.password.equals(password)) {
                    // Nếu đăng nhập thành công, chuyển sang MainActivity
                    final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);

                    // Truyền dữ liệu sang AccountActivity
                    final Intent accountIntent = new Intent(LoginActivity.this, AccountActivity.class);
                    accountIntent.putExtra("fullName", user.fullName);
                    accountIntent.putExtra("email", user.email);
                    LoginActivity.this.startActivity(accountIntent);

                    // Kết thúc LoginActivity
                    LoginActivity.this.finish();
                } else {
                    // Nếu đăng nhập không thành công, hiển thị thông báo
                    Toast.makeText(LoginActivity.this, "Đăng nhập không thành công. Vui lòng kiểm tra lại thông tin.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.btnRegister = this.findViewById(R.id.btn_register);

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }
}