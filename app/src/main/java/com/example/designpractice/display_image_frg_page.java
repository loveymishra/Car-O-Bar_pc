package com.example.designpractice;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.squareup.picasso.Picasso;

public class display_image_frg_page extends Fragment {
    private ViewPager2 viewPagerForCarModelImgDisplay;
    private ImageView imgLogo;
    private TextView modelName, txtSwipeInfo;
    private Handler handler = new Handler();

    private int brandSelectCount = data.get_brand_selec_count();
    private int modelSelectCount = data.get_model_selec_count();
    private int searchItemSelectCount = data.get_search_iten_select_count();
    private int clickedOnSearchOrNot = data.get_clicked_on_srch_or_not();
    private int clickedOnBrandOrNot = data.get_clicked_on_brnd_or_not();
    private int currentPage = 1;

    private int[] brandLengths = {
            data.ferrari_allmodel_nm.length,
            data.lambo_allmodel_nm.length,
            data.pagani_allmodel_nm.length,
            data.porsche_allmodel_nm.length,
            data.Bugatti_allmodel_nm.length,
            data.Koenigsegg_allmodel_nm.length,
            data.mclaren_allmodel_nm.length,
            data.astonmartin_allmodel_nm.length,
            data.de_tomaso_allmodel_nm.length,
            data.SSC_allmodel_nm.length,
            data.w_motors_nm.length,
            data.Maserati_allmodel_nm.length,
            data.Mercedes_allmodel_nm.length,
            data.Jaguar_allmodel_nm.length,
            data.Rolls_Royce_allmodel_nm.length
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_image_frg_page, container, false);

        viewPagerForCarModelImgDisplay = view.findViewById(R.id.viewPager_for_car_model_img_display);
        imgLogo = view.findViewById(R.id.img_logo_for_display_page);
        modelName = view.findViewById(R.id.model_name);
        txtSwipeInfo = view.findViewById(R.id.txt_swipe_info);

        hideSwipeInfo();
        updateCurrentPage();

        if (clickedOnSearchOrNot == 1) {
            int[] searchCounts = calculateSearchCounts();
            brandSelectCount = searchCounts[0];
            modelSelectCount = searchCounts[1];
        }

        displayBrandImages(brandSelectCount, modelSelectCount);

        return view;
    }

    private void hideSwipeInfo() {
        handler.postDelayed(() -> txtSwipeInfo.setVisibility(View.GONE), 3000);
    }

    private void updateCurrentPage() {
        handler.postDelayed(() -> viewPagerForCarModelImgDisplay.setCurrentItem(currentPage, true), 2000);
    }

    private int[] calculateSearchCounts() {
        int remainingCount = searchItemSelectCount;
        int searchBrandSelectCount = 0;
        int searchModelSelectCount = 0;

        for (int i = 0; i < brandLengths.length; i++) {
            if (remainingCount < brandLengths[i]) {
                searchBrandSelectCount = i;
                searchModelSelectCount = remainingCount % brandLengths[i];
                break;
            }
            remainingCount -= brandLengths[i];
        }

        return new int[]{searchBrandSelectCount, searchModelSelectCount};
    }

    private void displayBrandImages(int brandSelectCount, int modelSelectCount) {
        Picasso.get().load(data.car_brnd_logos[brandSelectCount]).into(imgLogo);
        String[] images = getImagesForBrandAndModel(brandSelectCount, modelSelectCount);
        String[] modelNames = data.getAllModelNames(brandSelectCount);
        setImages(images, modelNames);
    }

    private String[] getImagesForBrandAndModel(int brandSelectCount, int modelSelectCount) {
        switch (brandSelectCount) {
            case 0:
                switch (modelSelectCount) {
                    case 0:
                        return data.ferrari_kc23_imgs;
                    case 1:
                        return data.ferrari_purosangue;
                    case 2:
                        return data.ferrari_sf90_spider;
                    case 3:
                        return data.ferrari_daytona_sp3;
                    case 4:
                        return data.Ferrari_Monza_SP;
                    case 5:
                        return data.Ferrari_812_Competizione;
                    case 6:
                        return data.Ferrari_812_Superfast;
                    case 7:
                        return data.Ferrari_29_6GTB;
                    case 8:
                        return data.Ferrari_F8_Tributo;
                    case 9:
                        return data.Ferrari_roma;
                    case 10:
                        return data.Ferrari_sf90;
                    case 11:
                        return data.Ferrari_portofino;
                    case 12:
                        return data.Ferrari_GTC4Lusso;
                    case 13:
                        return data.Ferrari_488_gtb;
                    case 14:
                        return data.Ferrari_laferrari;
                    case 15:
                        return data.Ferrari_458_itl;
                    case 16:
                        return data.Ferrari_califrnia;
                    case 17:
                        return data.Ferrari_f430;
                    case 18:
                        return data.Ferrari_enzo;
                    case 19:
                        return data.Ferrari_360modena;
                    case 20:
                        return data.Ferrari_f50;
                    case 21:
                        return data.Ferrari_348;
                    case 22:
                        return data.Ferrari_f40;
                    case 23:
                        return data.Ferrari_testrosa;
                    case 24:
                        return data.Ferrari_512;
                    case 25:
                        return data.Ferrari_308;
                    case 26:
                        return data.Ferrari_dtna_365gtb;
                    case 27:
                        return data.Ferrari_dino246;
                    case 28:
                        return data.Ferrari_275gtb;
                    case 29:
                        return data.Ferrari_250gto;
                    case 30:
                        return data.Ferrari_250_tstrosa;
                    case 31:
                        return data.Ferrari_europa_gt_coupe;
                    case 32:
                        return data.Ferrari_250_gt_sbw;
                }
            case 1:
                switch (modelSelectCount) {
                    case 0:
                        return data.lambo_venano;
                    case 1:
                        return data.lambo_Reventón;
                    case 2:
                        return data.lambo_Revuelto;
                    case 3:
                        return data.lambo_Countach;
                    case 4:
                        return data.lambo_Huracan;
                    case 5:
                        return data.lambo_Sián;
                    case 6:
                        return data.lambo_Urus;
                    case 7:
                        return data.lambo_Aventador;
                    case 8:
                        return data.lambo_SVJ;
                    case 9:
                        return data.lambo_Gallardo;
                    case 10:
                        return data.lambo_Murciélago;
                    case 11:
                        return data.lambo_Diablo;
                    case 12:
                        return data.lambo_Countach_cl;
                    case 13:
                        return data.lambo_Miura;
                    case 14:
                        return data.lambo_350GT;
                }
            case 2:
                switch (modelSelectCount) {
                    case 0:
                        return data.pagani_utopia;
                    case 1:
                        return data.pagani_hermes;
                    case 2:
                        return data.pagani_coda;
                    case 3:
                        return data.pagani_H_R;
                    case 4:
                        return data.pagani_ZONDA_HP;
                    case 5:
                        return data.pagani_R_bc;
                    case 6:
                        return data.pagani_212;
                    case 7:
                        return data.pagani_zonda_r;
                    case 8:
                        return data.pagani_zonda_rd_f;
                    case 9:
                        return data.pagani_zonda_c12;

                }
            case 3:
                switch (modelSelectCount) {
                    case 0:
                        return data.Porsche_Mission_X;
                    case 1:
                        return data.Porsche_718_Spyder;
                    case 2:
                        return data.Porsche_718_Cayman_GT4_RS;
                    case 3:
                        return data.Porsche_911_Turbo_S;
                    case 4:
                        return data.Porsche_911_GT3_RS;
                    case 5:
                        return data.Porsche_Taycan;
                    case 6:
                        return data.Porsche_Taycan_Turismo;
                    case 7:
                        return data.Porsche_Panamera;
                    case 8:
                        return data.Porsche_Cayenne;
                    case 9:
                        return data.Porsche_Carrera_GT;
                    case 10:
                        return data.Porsche_918_Spyder;
                    case 11:
                        return data.Porsche_959;
                    case 12:
                        return data.Porsche_911_GT1;
                    case 13:
                        return data.Porsche_Gunther_Speedster;
                    case 14:
                        return data.Porsche_917;
                }
            case 4:
                switch (modelSelectCount) {
                    case 0:
                        return data.Bugatti_Mistral;
                    case 1:
                        return data.Bugatti_Golden_Era;
                    case 2:
                        return data.Bugatti_Bolide;
                    case 3:
                        return data.Bugatti_Divo;
                    case 4:
                        return data.Bugatti_Chiron_Hermes;
                    case 5:
                        return data.Bugatti_Ladybyg;
                    case 6:
                        return data.Bugatti_Veyron;
                    case 7:
                        return data.Bugatti_La_Voiture_Noire;
                    case 8:
                        return data.Bugatti_Centodieci;
                    case 9:
                        return data.Type_57_Atlantic_COUPÉ;
                    case 10:
                        return data.Bugatti_Chiron_Super_Sport;
                    case 11:
                        return data.Bugatti_EB110;
                }
            case 5:
                switch (modelSelectCount) {
                    case 0:
                        return data.Koenigsegg_Gemera;
                    case 1:
                        return data.Koenigsegg_Jesko_Absolute;
                    case 2:
                        return data.Koenigsegg_Regera;
                    case 3:
                        return data.Koenigsegg_One;
                    case 4:
                        return data.Koenigsegg_Agera_S;
                    case 5:
                        return data.Koenigsegg_CC850;
                    case 6:
                        return data.Koenigsegg_CCX;
                    case 7:
                        return data.Koenigsegg_CCXR;
                    case 8:
                        return data.Koenigsegg_CC_Prototype;
                }
            case 6:
                switch (modelSelectCount) {
                    case 0:
                        return data.McLaren_Artura;
                    case 1:
                        return data.McLaren_SOLUS_GT;
                    case 2:
                        return data.McLaren_P1;
                    case 3:
                        return data.McLaren_P1_GTR;
                    case 4:
                        return data.McLaren_ELVA;
                    case 5:
                        return data.McLaren_765LT_SPIDER;
                    case 6:
                        return data.MCLAREN_F1;
                    case 7:
                        return data.McLaren_675LT_SPIDER;
                    case 8:
                        return data.McLaren_620R;
                    case 9:
                        return data.McLaren_750S;
                    case 10:
                        return data.McLaren_GT;
                    case 11:
                        return data.McLaren_SENNA;
                    case 12:
                        return data.McLaren_SENNA_LM;
                    case 13:
                        return data.McLaren_SPEEDTAIL;
                    case 14:
                        return data.McLaren_720S_SPIDER;
                    case 15:
                        return data.McLaren_600LT_SPIDER;
                    case 16:
                        return data.McLaren_570S;
                    case 17:
                        return data.McLaren_570GT;
                    case 18:
                        return data.McLaren_540C;
                    case 19:
                        return data.McLaren_12C_SPIDER;
                    case 20:
                        return data.McLaren_M6GT;
                }
            case 7:
                switch (modelSelectCount) {
                    case 0:
                        return data.Aston_Martin_DB12;
                    case 1:
                        return data.Aston_Martin_Valhalla;
                    case 2:
                        return data.Aston_Martin_DB12_Volante;
                    case 3:
                        return data.Aston_Martin_DBS_770;
                    case 4:
                        return data.Aston_Martin_DBS_Volante;
                    case 5:
                        return data.Aston_Martin_Vantage_V8_Roadster;
                    case 6:
                        return data.Aston_Martin_Vantage_V12_Coupe;
                    case 7:
                        return data.Aston_Martin_Valour;
                    case 8:
                        return data.Aston_Martin_Valkyrie;
                    case 9:
                        return data.Aston_Martin_Vulcan;
                    case 10:
                        return data.Aston_Martin_DBR22;
                    case 11:
                        return data.Aston_Martin_V12_SPEEDSTER;
                    case 12:
                        return data.Aston_Martin_Rapide;
                    case 13:
                        return data.Aston_Martin_V12_Zagato;
                    case 14:
                        return data.Aston_Martin_Vanquish;
                    case 15:
                        return data.Aston_Martine_CC100;
                    case 16:
                        return data.Aston_Martin_DB5_Goldfinger;
                    case 17:
                        return data.Aston_Martin_DB4GT_ZAGATO;
                    case 18:
                        return data.Aston_Martin_DB5;
                    case 19:
                        return data.Aston_Martin_DB6;
                    case 20:
                        return data.Aston_Martin_Lagonda;
                    case 21:
                        return data.Aston_Martin_DBR1;
                }
            case 8:
                switch (modelSelectCount) {
                    case 0:
                        return data.De_Tomaso_P900;
                    case 1:
                        return data.De_Tomaso_P72;
                    case 2:
                        return data.De_Tomaso_P70;
                    case 3:
                        return data.De_Tomaso_Vallelunga;
                    case 4:
                        return data.De_Tomaso_Pantera;
                    case 5:
                        return data.De_Tomaso_Guarà;
                    case 6:
                        return data.De_Tomasp_Mangusta;
                    case 7:
                        return data.De_Tomaso_2000;
                }
            case 9:
                switch (modelSelectCount) {
                    case 0:
                        return data.ssc_tuatara;
                    case 1:
                        return data.SSC_Ultimate_Aero;
                }
            case 10:
                switch (modelSelectCount) {
                    case 0:
                        return data.Fenyr_Supersport;
                    case 1:
                        return data.Lykan_Hypersport;
                }
            case 11:
                switch (modelSelectCount) {
                    case 0:
                        return data.Maserati_MC20;
                    case 1:
                        return data.Maserati_MC20_Cielo;
                    case 2:
                        return data.Maserati_GranTurismo;
                    case 3:
                        return data.Maserati_MC12;
                    case 4:
                        return data.Maserati_3500_GT;
                    case 5:
                        return data.Maserati_Quattroporte;
                    case 6:
                        return data.Maserati_Ghibli;
                    case 7:
                        return data.Maserati_A6GCS_53_Berlinetta;
                }
            case 12:
                switch (modelSelectCount) {
                    case 0:
                        return data.Mercedes_AMG_ONE;
                    case 1:
                        return data.Mercedes_AMG_GT;
                    case 2:
                        return data.Mercedes_AMG_SL;
                    case 3:
                        return data.Mercedes_Maybach_S_Class;
                    case 4:
                        return data.Mercedes_Maybach_GLS;
                    case 5:
                        return data.Mercedes_Benz_SLR_McLaren;
                    case 6:
                        return data.Mercedes_Benz_SLS_AMG;
                    case 7:
                        return data.Mercedes_Benz_C112;
                    case 8:
                        return data.Mercedes_Benz_CLR;
                    case 9:
                        return data.Mercedes_Benz_CLK_GTR;
                    case 10:
                        return data.Mercedes_AMG_G63;
                    case 11:
                        return data.Mercedes_Benz_540K;
                    case 12:
                        return data.Mercedes_Benz_280_SL_Pagoda;
                    case 13:
                        return data.Mercedes_Benz_300_SLR;
                    case 14:
                        return data.Mercedes_Benz_300_SL_Gullwing;
                    case 15:
                        return data.Mercedes_Benz_SSK;
                }
            case 13:
                switch (modelSelectCount) {
                    case 0:
                        return data.Jaguar_F_Type;
                    case 1:
                        return data.Jaguar_F_TYPE_Convertible;
                    case 2:
                        return data.Jaguar_XJ220;
                    case 3:
                        return data.Jaguar_E_Type;
                    case 4:
                        return data.Jaguar_F_Pace;
                    case 5:
                        return data.Jaguar_XE;
                    case 6:
                        return data.Jaguar_XK120;
                }
            case 14:
                switch (modelSelectCount) {
                    case 0:
                        return data.Rolls_Royce_La_rose;
                    case 1:
                        return data.Rolls_Royce_Spectre;
                    case 2:
                        return data.Rolls_Royce_Dawn;
                    case 3:
                        return data.Rolls_Royce_Wraith;
                    case 4:
                        return data.Rolls_Royce_Sweptail;
                    case 5:
                        return data.Rolls_Royce_Boat_Tail;
                    case 6:
                        return data.Rolls_Royce_Ghost;
                    case 7:
                        return data.Rolls_Royce_Cullinan;
                    case 8:
                        return data.Rolls_Royce_Phantom;
                }
        }
        return new String[0];
    }

    private void setImages(String[] images, String[] modelNames) {
        adapter_for_car_imgs_display_to_viewpager adapter = new adapter_for_car_imgs_display_to_viewpager(getContext(), images);
        modelName.setText(modelNames[modelSelectCount]);
        viewPagerForCarModelImgDisplay.setAdapter(adapter);
    }
}
