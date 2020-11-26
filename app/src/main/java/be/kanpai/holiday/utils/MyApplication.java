package be.kanpai.holiday.utils;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MyApplication extends Application {

    public static Retrofit getRetrofitClient(String baseUrl) {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build();

        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
}
