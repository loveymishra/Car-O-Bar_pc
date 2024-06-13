package com.example.designpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class homepage_story_adapter extends RecyclerView.Adapter<homepage_story_adapter.viewholder> {

    List<String> img_arr;
    Context context;
    private FragmentManager fragmentManager;

    public homepage_story_adapter(List<String> img, Context context,FragmentManager fragmentManager){
        this.img_arr=img;
        this.context=context;
        this.fragmentManager=fragmentManager;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_for_top_10,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.get().load(img_arr.get(position)).into(holder.img, new Callback() {
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
                int clickedPosition = holder.getAdapterPosition();
                data.set_brand_selec_count(clickedPosition);
                openFragment(new Selec_car_model_fragment());
            }
        });

    }
    @Override
    public int getItemCount() {
        return img_arr.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        private ImageView img;
        LottieAnimationView lottieAnimationView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.logo);
            lottieAnimationView = itemView.findViewById(R.id.lt_animation_for_car_img_page2);

        }
    }


    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
