package com.example.designpractice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class Show_Media_frg_adapter extends RecyclerView.Adapter<Show_Media_frg_adapter.Myviewholder> {

    Context context;
    String img[];
    FragmentManager fragmentManager;

    Show_Media_frg_adapter(Context context, String img[], FragmentManager fragmentManager){
        this.context=context;
        this.img=img;
        this.fragmentManager=fragmentManager;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_for_show_media_frg,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        Random random=new Random();
        int pos2=random.nextInt(img.length);
        Picasso.get().load(img[pos2]).into(holder.img, new Callback() {
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

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int c=holder.getAdapterPosition();
                data.set_clicked_position_of_img(pos2);
//                openFragment(new Full_img_display_frg());
                Intent intent=new Intent(context,full_imageview_for_show_media_frg.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        ImageView img;
        LottieAnimationView lottieAnimationView;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgv_fr_cr_mdl);
            lottieAnimationView=itemView.findViewById(R.id.lt_animation_for_car_model_page);
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void openFragment2(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
