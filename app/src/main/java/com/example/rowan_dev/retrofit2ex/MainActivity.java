package com.example.rowan_dev.retrofit2ex;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitExService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitExService retrofitExService = retrofit.create(RetrofitExService.class);
        retrofitExService.getData("1").enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                if (response.isSuccessful()) {
                    Data body = response.body();
                    if (body != null) {
                        Log.d("data.getUserId()", body.getUserId() + "");
                        Log.d("data.getId()", body.getId() + "");
                        Log.d("data.getTitle()", body.getTitle());
                        Log.d("data.getBody()", body.getBody());
                        Log.e("getData end", "======================================");
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {

            }
        });

        retrofitExService.getData2("1").enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(@NonNull Call<List<Data>> call, @NonNull Response<List<Data>> response) {
                if (response.isSuccessful()) {
                    List<Data> datas = response.body();
                    if (datas != null) {
                        for (int i = 0; i < datas.size(); i++) {
                            Log.e("data" + i, datas.get(i).getUserId() + "");
                        }
                        Log.e("getData2 end", "======================================");
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Data>> call, @NonNull Throwable t) {

            }
        });

        HashMap<String, Object> input = new HashMap<>();
        input.put("userId", 1);
        input.put("title", "this is title!!");
        input.put("body", "this is body!");
        retrofitExService.postData(input).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                if (response.isSuccessful()) {
                    Data body = response.body();
                    if (body != null) {
                        Log.d("data.getUserId()", body.getUserId() + "");
                        Log.d("data.getId()", body.getId() + "");
                        Log.d("data.getTitle()", body.getTitle()+"");
                        Log.d("data.getBody()", body.getBody()+"");
                        Log.e("postData end", "======================================");
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {

            }
        });

        retrofitExService.putData(new Data(1, 1, "title", "body")).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                if (response.isSuccessful()) {
                    Data body = response.body();
                    if (body != null) {
                        Log.d("data.getUserId()", body.getUserId() + "");
                        Log.d("data.getId()", body.getId() + "");
                        Log.d("data.getTitle()", body.getTitle());
                        Log.d("data.getBody()", body.getBody());
                        Log.e("putData end", "======================================");
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {

            }
        });

        retrofitExService.patchData("1").enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                if (response.isSuccessful()) {
                    Data body = response.body();
                    if (body != null) {
                        Log.d("data.getUserId()", body.getUserId() + "");
                        Log.d("data.getId()", body.getId() + "");
                        Log.d("data.getTitle()", body.getTitle());
                        Log.d("data.getBody()", body.getBody());
                        Log.e("patchData end", "======================================");
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {

            }
        });

        retrofitExService.deleteData().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        Log.d("body", body.toString() + "");
                        Log.e("patchData end", "======================================");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
