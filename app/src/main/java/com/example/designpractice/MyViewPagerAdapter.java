package com.example.designpractice;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyViewPagerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<String> data;

    private Context context;

    public MyViewPagerAdapter(List<String> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate your item layout here and create a ViewHolder
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cview, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Bind data to the view holder elements
        Picasso.get().load(data.get(position)).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This Page Will Be Available Soon...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.image);
    }
}

