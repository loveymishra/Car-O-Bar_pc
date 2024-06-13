package com.example.designpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navbar=findViewById(R.id.bottomNavigation);

        navbar.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        navbar.add(new MeowBottomNavigation.Model(2, R.drawable.select_brand_icon));
        navbar.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_category_24));
        navbar.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_search_24));
        navbar.add(new MeowBottomNavigation.Model(5, R.drawable.compare_icon));


        navbar.show(1,true);

        navbar.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()) {
                    case 1:
                        rpl(new Home_fragment());
                        data.set_clicked_on_brnd_or_not(1);
                        data.set_clicked_on_srch_or_not(-1);
                        break;
                    case 2:
                        rpl(new Select_brands_fragment());
                        data.set_clicked_on_srch_or_not(-1);
                        data.set_clicked_on_brnd_or_not(1);
                        break;
                    case 3:
                        rpl(new Show_media_frg_page());
                        break;
                    case 4:
                        rpl(new search_bar_frg());
                        data.set_brand_selec_count(-1);
                        data.set_clicked_on_srch_or_not(1);
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, "This Page Will Be Available Soon", Toast.LENGTH_SHORT).show();
                        break;
                }

                return Unit.INSTANCE;
            }
        });


    }

    private void rpl(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
