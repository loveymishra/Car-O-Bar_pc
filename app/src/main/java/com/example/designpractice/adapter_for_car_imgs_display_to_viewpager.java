package com.example.designpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class adapter_for_car_imgs_display_to_viewpager extends RecyclerView.Adapter<adapter_for_car_imgs_display_to_viewpager.MyviewHolder>{
    Context context;
    String imgs[];
    adapter_for_car_imgs_display_to_viewpager(Context context, String imgslist[]){
        this.imgs=imgslist;
        this.context=context;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view_for_image_display_frg_page,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Picasso.get().load(imgs[position]).into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                // Image loaded successfully, hide Lottie animation
                holder.lottieAnimationView.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                // Handle error, hide Lottie animation
                holder.lottieAnimationView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }


    public class MyviewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        LottieAnimationView lottieAnimationView;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.car_img_display_for_viewpager);
            lottieAnimationView=itemView.findViewById(R.id.lt_animation_for_car_img_page1);
        }
    }
}
