package com.example.designer2.moviesapp.repositry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import android.util.Log;


import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.network.ApiClient;
import com.example.designer2.moviesapp.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Response;




public class Repository {

    private static String TAG = Repository.class.getSimpleName();
    private ApiInterface apiInterface;

    public Repository() {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public LiveData<VideosModel> getBooksDetails() {

        final MutableLiveData<VideosModel> mBookList =
                new MutableLiveData<>();

        apiInterface.getBooksInfo("start").enqueue(new retrofit2.Callback<VideosModel>() {
            @Override
            public void onResponse(Call<VideosModel> call, Response<VideosModel> response) {

                mBookList.setValue(response.body());
                Log.e(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<VideosModel> call, Throwable t) {

                Log.e(TAG, "onFailure: something went wrong: " + t.toString());
            }
        });

        return mBookList;
    }






}
