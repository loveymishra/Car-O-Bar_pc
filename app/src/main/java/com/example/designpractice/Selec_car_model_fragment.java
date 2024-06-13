package com.example.designpractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class Selec_car_model_fragment extends Fragment {


        RecyclerView rcv_fr_mdl;
        ImageView img_logo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_selec_car_model_fragment, container, false);

        img_logo=view.findViewById(R.id.img_logo);
        rcv_fr_mdl=view.findViewById(R.id.rcv_fr_mdl);

        rcv_fr_mdl = view.findViewById(R.id.rcv_fr_mdl);
        img_logo = view.findViewById(R.id.img_logo);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rcv_fr_mdl.setLayoutManager(gridLayoutManager);

        int click_on_brnd_num = data.get_brand_selec_count();
        loadModelPage(click_on_brnd_num);




        return view;
    }

    private void loadModelPage(int brandIndex) {
        if (brandIndex >= 15) {
            Toast.makeText(getContext(), "This Page Is Not Completed Yet..", Toast.LENGTH_LONG).show();
        } else {
            openModelPage(data.getAllModelImages(brandIndex),data.getAllModelNames(brandIndex));
        }
    }

    private void openModelPage(String img[], String nm[]) {
        select_car_models_adapter adapter = new select_car_models_adapter(Arrays.asList(img), nm, getContext(), getParentFragmentManager());
        Picasso.get().load(Arrays.asList(data.car_brnd_logos).get(data.get_brand_selec_count())).placeholder(R.color.black).into(img_logo);
        rcv_fr_mdl.setAdapter(adapter);
    }


}