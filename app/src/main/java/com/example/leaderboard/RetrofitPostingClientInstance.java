package com.example.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPostingClientInstance {
    private static Retrofit sRetrofit;
    public static final String BASE_URL = "https://docs.google.com/forms/d/e/";

    public static Retrofit getRetrofitInstance() {
        if (sRetrofit == null) {
            sRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
