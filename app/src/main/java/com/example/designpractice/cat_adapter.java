package com.example.designpractice;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class cat_adapter extends RecyclerView.Adapter<cat_adapter.viewholder> {

    List<String> img_arr;

    String title[];
    Context context;

    public cat_adapter(List<String> img,String title[], Context context){
        this.img_arr=img;
        this.title=title;
        this.context=context;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view_for_cat,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.get().load(img_arr.get(position)).into(holder.img);
        holder.ttl.setText(title[position]);

        holder.ttl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This Page Will Be Available Soon..", Toast.LENGTH_SHORT).show();
            }
        });

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This Page Will Be Available Soon..", Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    public int getItemCount() {
        return img_arr.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView ttl;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.bkgimg);
            ttl=(TextView) itemView.findViewById(R.id.title);
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

}
