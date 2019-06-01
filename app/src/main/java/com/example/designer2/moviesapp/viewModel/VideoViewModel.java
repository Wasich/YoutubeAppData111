package com.example.designer2.moviesapp.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;


import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.repositry.Repository;




public class VideoViewModel extends ViewModel {

    private LiveData<VideosModel> modelLiveData = null;

    public VideoViewModel() {

        // reading book details from Repository class.
        Repository repository = new Repository();
        modelLiveData = repository.getBooksDetails();
    }

    /**
     * Emits Book list to the UI for observe and update
     */
    public LiveData<VideosModel> getBookListLiveData() {
        return modelLiveData;
    }
}
