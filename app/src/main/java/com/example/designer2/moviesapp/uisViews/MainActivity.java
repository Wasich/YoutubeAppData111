//package com.example.designer2.moviesapp.uisViews;
//
//import android.arch.lifecycle.Observer;
//import android.arch.lifecycle.ViewModelProviders;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.ViewFlipper;
//
//
//import com.example.designer2.moviesapp.R;
//
//
//import com.example.designer2.moviesapp.adapters.BookAdapterssssss;
//import com.example.designer2.moviesapp.adapters.RecyclerViewAdapter;
//import com.example.designer2.moviesapp.adapters.RecyclerViewAdapterCircle;
//import com.example.designer2.moviesapp.model.VideosModel;
//import com.example.designer2.moviesapp.viewModel.VideoViewModel;
//
//public class MainActivity extends AppCompatActivity  {
//
//    private static String TAG = MainActivity.class.getSimpleName();
//    private RecyclerView recyclerView;
//    RecyclerViewAdapter bookAdapter;
//    private RecyclerView recyclerViewsss,circlerv;
//    RecyclerViewAdapterCircle adapterscircle;
//    BookAdapterssssss bookAdapterssssss;
//    ViewFlipper flipper;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.recyclerView);
//       recyclerView.setNestedScrollingEnabled(true);
//        recyclerViewsss = findViewById(R.id.recyclerViewsss);
//      recyclerViewsss.setNestedScrollingEnabled(false);
//
//int[]images = {R.drawable.masjid,R.drawable.pakistan,R.drawable.youtube};
//      flipper = findViewById(R.id.viewflippersss);
//      for (int i = 0; i<images.length; i++){
//          viewflipper(images[i]);
//      }
//
//
//       circlerv = findViewById(R.id.recyclerViewcircle);
//       circlerv.setNestedScrollingEnabled(false);
//
//        bookAdapter = new RecyclerViewAdapter(this, R.layout.gridrv_row_items);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        recyclerView.setAdapter(bookAdapter);
//
//        bookAdapterssssss = new BookAdapterssssss(this,R.layout.gridrv_row_items2);
//        recyclerViewsss.setLayoutManager(new GridLayoutManager(this,2));
//        recyclerViewsss.setAdapter(bookAdapterssssss);
//
//        adapterscircle = new RecyclerViewAdapterCircle(this,R.layout.cicrlerv_row_item);
//        circlerv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        circlerv.setAdapter(adapterscircle);
//
//
//        //flipper = findViewById(R.id.flipper_view);
//
//
//        final VideoViewModel bookViewModel =
//                ViewModelProviders.of(this).get(VideoViewModel.class);
//
//        observeViewModel(bookViewModel);
//    }
//
//    private void observeViewModel(VideoViewModel bookViewModel) {
//
//        // updating list based on data change
//        bookViewModel.getBookListLiveData().observe(this, new Observer<VideosModel>() {
//            @Override
//            public void onChanged(@Nullable VideosModel bookResponseModel) {
//
//                if (bookResponseModel != null)
//                    bookAdapter.addAll(bookResponseModel.getItems());
//                bookAdapterssssss.addAll(bookResponseModel.getItems());
//               adapterscircle.addAll(bookResponseModel.getItems());
//               // setlayout();
//
//                Log.e(TAG, "onChanged: " + bookResponseModel.getItems().size());
//            }
//        });
//
//    }
//
//    public void viewflipper(int image)
//    {
//        ImageView imageView = new ImageView(this);
//        imageView.setBackgroundResource(image);
//        flipper.addView(imageView);
//        flipper.setFlipInterval(2000);
//        flipper.setAutoStart(true);
//       flipper.setInAnimation(this,android.R.anim.fade_in);
//        flipper.setOutAnimation(this,android.R.anim.fade_out);
//    }
//
//
//
//}
