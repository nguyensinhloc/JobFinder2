package com.example.jobfindernew;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://your-api-base-url.com/"; // Thay đổi đúng base URL của bạn

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            // Add logging interceptor for debugging
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logging);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
