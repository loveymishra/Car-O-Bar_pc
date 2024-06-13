package com.example.designpractice;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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

public class select_car_models_adapter extends RecyclerView.Adapter<select_car_models_adapter.viewholder> {

    List<String> img_arr;
    String name[];
    Context context;
    private FragmentManager fragmentManager;


    public select_car_models_adapter(List<String> img, String name[], Context context, FragmentManager fragmentManager){
        this.img_arr=img;
        this.name=name;
        this.context=context;
        this.fragmentManager=fragmentManager;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view_for_car_model_page,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.lottieAnimationView.setAnimation("loading_animation.json");
        holder.lottieAnimationView.playAnimation();
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

        holder.txtv.setText(name[position]);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                data.set_model_selec_count(clickedPosition);
                openFragment(new car_desc_frg_page());
            }
        });

    }
    @Override
    public int getItemCount() {
        return name.length;
    }

    class viewholder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtv;
        private LottieAnimationView lottieAnimationView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.imgv_fr_cr_mdl);
            txtv=(TextView) itemView.findViewById(R.id.txtv_fr_cr_mdl_nm);
            lottieAnimationView=(LottieAnimationView) itemView.findViewById(R.id.lt_animation_for_car_model_page);
            reduceBrightness(img, 0.7f);
            adjustExposure(img,0.7f);
        }
    }

    private void reduceBrightness(ImageView imageView, float brightness) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(brightness);

        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        imageView.setColorFilter(colorFilter);
    }
    private void adjustExposure(ImageView imageView, float exposure) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                exposure, 0, 0, 0, 0,  // Red component
                0, exposure, 0, 0, 0,  // Green component
                0, 0, exposure, 0, 0,  // Blue component
                0, 0, 0, 1, 0         // Alpha component
        });

        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        imageView.setColorFilter(colorFilter);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
