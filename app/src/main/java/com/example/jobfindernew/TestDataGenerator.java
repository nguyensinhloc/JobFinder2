package com.example.jobfindernew;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum TestDataGenerator {
    ;

    public static void addTestData() {
        final UserDao userDao = DatabaseInitializer.getUserDao();

        // Kiểm tra xem đã có dữ liệu test chưa
        if (userDao.getAllUsers().isEmpty()) {
            // Tạo một User mới làm test data
            final User testUser = new User();
            testUser.email = "test@example.com";
            testUser.password = "testpassword";
            testUser.socialMediaId = "123456";
            testUser.userName = "test_user";
            testUser.fullName = "Test User";
            testUser.createdAt = TestDataGenerator.getCurrentDateTime();

            // Thêm User vào cơ sở dữ liệu
            userDao.insert(testUser);
        }
    }

    private static String getCurrentDateTime() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
