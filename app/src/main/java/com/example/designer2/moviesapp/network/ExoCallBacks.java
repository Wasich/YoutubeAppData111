package com.example.designer2.moviesapp.network;

public interface ExoCallBacks {


    void callbackObserver(Object obj);

    public interface playerCallBack{
        void onItemClickOnItem(Integer albumId);
        void onPlayingEnd();
    }
}







