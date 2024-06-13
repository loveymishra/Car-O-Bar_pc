package com.example.designpractice;

import android.icu.number.FractionPrecision;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Arrays;

public class Select_brands_fragment extends Fragment {

  RecyclerView Recyclerviewforbrandfrg;
    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_select_brands_fragment, container, false);

        Recyclerviewforbrandfrg=view.findViewById(R.id.Recyclerviewforbrandfrg);
//        searchView=view.findViewById(R.id.searchView);

        Brand_frg_adapter adapter=new Brand_frg_adapter(Arrays.asList(data.car_brnd_logos),data.car_brnd_names,data.origin,data.Founded_year,getContext(), getParentFragmentManager());
        StaggeredGridLayoutManager st=new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        Recyclerviewforbrandfrg.setLayoutManager(st);
        Recyclerviewforbrandfrg.setAdapter(adapter);

//        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);

//        searchEditText.setTextColor(getResources().getColor(R.color.black));
//        searchEditText.setHintTextColor(getResources().getColor(R.color.black));

        return view;
    }
}