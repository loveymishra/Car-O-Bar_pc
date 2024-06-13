package com.example.designpractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;


public class Home_fragment extends Fragment {

   RecyclerView Recyclerviewforbrandstory,Recyclerviewforcat;
   ViewPager2 viewpagerforfastest2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home_fragment2, container, false);

//        data.set_clicked_on_brnd_or_not(1);



        Recyclerviewforbrandstory=view.findViewById(R.id.Recyclerviewforbrandstory);
        Recyclerviewforcat=view.findViewById(R.id.Recyclerviewforcat);
        viewpagerforfastest2=view.findViewById(R.id.viewpagerforfastest2);

        homepage_story_adapter adapter1=new homepage_story_adapter(Arrays.asList(data.Top_10_logos), getContext(),getParentFragmentManager());
        Recyclerviewforbrandstory.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        Recyclerviewforbrandstory.setLayoutManager(linearLayoutManager);
        Recyclerviewforbrandstory.setAdapter(adapter1);

        cat_adapter adapter2=new cat_adapter(Arrays.asList(data.cat),data.catname,getContext());
        StaggeredGridLayoutManager st=new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        Recyclerviewforcat.setLayoutManager(st);
        Recyclerviewforcat.setAdapter(adapter2);

        MyViewPagerAdapter adapter3=new MyViewPagerAdapter(Arrays.asList(data.Porsche_918_Spyder),getContext());
        viewpagerforfastest2.setAdapter(adapter3);


        return view;
    }
}