package com.example.designpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


public class Show_media_frg_page extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_show_media_frg_page, container, false);
        recyclerView=view.findViewById(R.id.rcv_forpin);

        Show_Media_frg_adapter adapter=new Show_Media_frg_adapter(getContext(),data.allimg,getParentFragmentManager());
        StaggeredGridLayoutManager st=new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(st);
        recyclerView.setAdapter(adapter);


        return view;
    }
}