package com.example.designer2.moviesapp.network;


import com.example.designer2.moviesapp.model.VideosModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;




public interface ApiInterface {


    @GET("books/v1/volumes")
    Call<VideosModel> getBooksInfo(@Query("q") String queue);


    @GET("books/vol/v2")
    Call<VideosModel> getbooksinfro();

}
