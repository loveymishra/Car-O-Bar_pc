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

import com.squareup.picasso.Picasso;

import java.util.List;

public class Brand_frg_adapter extends RecyclerView.Adapter<Brand_frg_adapter.viewholder> {

    List<String> img_arr;
    String name[],origin[],year[];
    Context context;
    private FragmentManager fragmentManager;

    public Brand_frg_adapter(List<String> img, String name[],String origin[],String year[], Context context,FragmentManager fragmentManager){
        this.img_arr=img;
        this.name=name;
        this.origin=origin;
        this.year=year;
        this.context=context;
        this.fragmentManager = fragmentManager;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view_for_car_brnd_page,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        Picasso.get().load(img_arr.get(position)).into(holder.img);

        holder.Brnd_name.setText(name[position]);
        holder.year.setText(year[position]);
        holder.origin.setText(origin[position]);

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
        return name.length;
    }

    class viewholder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView Brnd_name,year,origin;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.imgv);
            Brnd_name=(TextView) itemView.findViewById(R.id.Brnd_name);
            year=(TextView) itemView.findViewById(R.id.year);
            origin=(TextView) itemView.findViewById(R.id.origin);

        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}