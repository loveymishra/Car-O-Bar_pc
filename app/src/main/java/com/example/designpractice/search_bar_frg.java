package com.example.designpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Arrays;
import java.util.List;

public class search_bar_frg extends Fragment {
    ListView listView;
    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_search_bar_frg, container, false);
        searchView=view.findViewById(R.id.searchView);
        listView=view.findViewById(R.id.listview);
        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);

        searchEditText.setTextColor(getResources().getColor(R.color.black));
        searchEditText.setHintTextColor(getResources().getColor(R.color.black));


        ArrayAdapter adapter=new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,data.allmodel_nm);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=(String) parent.getItemAtPosition(position);
                List<String> d_list= Arrays.asList(data.allmodel_nm);
                int selected_itm_position=d_list.indexOf(selectedItem);
                data.set_search_iten_select_count(selected_itm_position);
//                Toast.makeText(getContext(), "Selected: "+selectedItem+" "+selected_itm_position, Toast.LENGTH_SHORT).show();
                openFragment(new car_desc_frg_page());
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}