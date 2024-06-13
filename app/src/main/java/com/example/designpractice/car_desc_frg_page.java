package com.example.designpractice;

import android.animation.ValueAnimator;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class car_desc_frg_page extends Fragment {

    ImageView img_car_logo,img_bkg_1,img_gal_btn,Eximg,INimg,DRimg;
    TextView txt_car_launch_yr,txt_brandnm,txt_modelnm,txt_price,txt_eng_aspect,txt_hp,txt_topspeed,txt_torque,txt_specification,txt_description,txt_0_60,txt_no_of_units_made;

    LottieAnimationView lottieAnimationView;
    int brand_selec_count=data.get_brand_selec_count();
    int model_select_count=data.get_model_selec_count();
    int srch_brand_selec_count;
    int srch_model_select_count;

    int search_iten_select_count=data.get_search_iten_select_count();
    int clicked_on_srch_or_not=data.get_clicked_on_srch_or_not();
    int clicked_on_brnd_or_not=data.get_clicked_on_brnd_or_not();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_car_desc_frg_page, container, false);


// Managing Searchlist
        int[] lengths = {
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

        int cumulativeLength = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (search_iten_select_count < cumulativeLength + lengths[i]) {
                srch_brand_selec_count = i;
                srch_model_select_count = (search_iten_select_count - cumulativeLength) % lengths[i];
                break;
            }
            cumulativeLength += lengths[i];
        }


        lottieAnimationView=view.findViewById(R.id.lt_animationn);


//      Finding Id's
        img_car_logo=view.findViewById(R.id.img_car_logo);
        img_bkg_1=view.findViewById(R.id.img_bkg_1);
        img_gal_btn=view.findViewById(R.id.img_gal_btn);

        Eximg=view.findViewById(R.id.Eximg);
        INimg=view.findViewById(R.id.INimg);
        DRimg=view.findViewById(R.id.DRimg);


        reduceBrightness(Eximg, 0.7f);
        adjustExposure(Eximg,0.7f);

        reduceBrightness(INimg, 0.7f);
        adjustExposure(INimg,0.7f);

        reduceBrightness(DRimg, 0.7f);
        adjustExposure(DRimg,0.7f);




//      adjusting imageview
        reduceBrightness(img_bkg_1,0.5f);
        adjustExposure(img_bkg_1,0.5f);

        txt_car_launch_yr=view.findViewById(R.id.txt_car_launch_yr);
        txt_brandnm=view.findViewById(R.id.txt_brandnm);
        txt_modelnm=view.findViewById(R.id.txt_modelnm);
        txt_price=view.findViewById(R.id.txt_price);
        txt_eng_aspect=view.findViewById(R.id.txt_eng_aspect);
        txt_hp=view.findViewById(R.id.txt_hp);
        txt_topspeed=view.findViewById(R.id.txt_topspeed);
        txt_torque=view.findViewById(R.id.txt_torque);
        txt_specification=view.findViewById(R.id.specification);
        txt_description=view.findViewById(R.id.description);
        txt_0_60=view.findViewById(R.id.txt_0_60);
        txt_no_of_units_made=view.findViewById(R.id.txt_no_of_units_made);

        img_gal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new display_image_frg_page());
            }
        });

        if(clicked_on_brnd_or_not==1) {
//            For brand select page
            if (brand_selec_count == 0) {
                car_des(data.ferrari_allmodel_img, data.ferrari_allmodel_years, data.ferrari_allmodel_nm, data.ferrari_allmodel_engines, data.ferrari_allmodel_price, data.ferrari_allmodel_0_to_60, data.ferrari_allmodel_units, data.ferrari_allmodel_desc, data.ferrari_allmodel_spec, data.ferrari_allmodel_horsepower, data.ferrari_allmodel_torque, data.ferrari_allmodel_topspeed);
            } else if (brand_selec_count == 1) {
                car_des(data.lambo_allmodel_img, data.lambo_allmodel_years, data.lambo_allmodel_nm, data.lambo_allmodel_engines, data.lambo_allmodel_price, data.lambo_allmodel_0_to_60, data.lambo_allmodel_units, data.lambo_allmodel_des, data.lambo_allmodel_spec, data.lambo_allmodel_horsepower, data.lambo_allmodel_torque, data.lambo_allmodel_topspeed);
            } else if (brand_selec_count == 2) {
                car_des(data.pagani_allmodel_img, data.pagani_allmodel_years, data.pagani_allmodel_nm, data.pagani_allmodel_engine, data.pagani_allmodel_price, data.pagani_allmodel_0_to_60, data.pagani_allmodel_units, data.pagani_allmodel_desc, data.pagani_allmodel_spec, data.pagani_allmodel_horsepower, data.pagani_allmodel_torque, data.pagani_allmodel_topspeed);
            } else if (brand_selec_count == 3) {
                car_des(data.porsche_allmodel_img, data.porsche_allmodel_years, data.porsche_allmodel_nm, data.porsche_allmodel_engine, data.porsche_allmodel_price, data.porsche_allmodel_0_to_60, data.porsche_allmodel_units, data.porsche_allmodel_desc, data.porsche_allmodel_spec, data.porsche_allmodel_horsepower, data.porsche_allmodel_torque, data.porsche_allmodel_topspeed);
            } else if (brand_selec_count == 4) {
                car_des(data.Bugatti_allmodel_img, data.Bugatti_allmodel_years, data.Bugatti_allmodel_nm, data.Bugatti_allmodel_engines, data.Bugatti_allmodel_prices, data.Bugatti_allmodel_0_to_60, data.Bugatti_allmodel_units, data.Bugatti_allmodel_desc, data.Bugatti_allmodel_spec, data.Bugatti_allmodel_horsepower, data.Bugatti_allmodel_torque, data.Bugatti_allmodel_top_speed);
            } else if (brand_selec_count == 5) {
                car_des(data.Koenigsegg_allmodel_img, data.Koenigsegg_allmodel_years, data.Koenigsegg_allmodel_nm, data.Koenigsegg_allmodel_engine, data.Koenigsegg_allmodel_price, data.Koenigsegg_allmodel_0_to_60, data.Koenigsegg_allmodel_units, data.Koenigsegg_allmodel_desc, data.Koenigsegg_allmodel_spec, data.Koenigsegg_allmodel_horsepower, data.Koenigsegg_allmodel_torque, data.Koenigsegg_allmodel_topspeed);
            } else if (brand_selec_count == 6) {
                car_des(data.mclaren_allmodel_img, data.mclaren_allmodel_years, data.mclaren_allmodel_nm, data.mclaren_allmodel_engine, data.mclaren_allmodel_price, data.mclaren_allmodel_0_to_60, data.mclaren_allmodel_units, data.mclaren_allmodel_desc, data.mclaren_allmodel_spec, data.mclaren_allmodel_horsepower, data.mclaren_allmodel_torque, data.mclaren_allmodel_topspeed);
            } else if (brand_selec_count == 7) {
                car_des(data.astonmartin_allmodel_img, data.astonmartin_allmodel_years, data.astonmartin_allmodel_nm, data.astonmartin_allmodel_engine, data.astonmartin_allmodel_price, data.astonmartin_allmodel_0_to_60, data.astonmartin_allmodel_units, data.astonmartin_allmodel_desc, data.astonmartin_allmodel_spec, data.astonmartin_allmodel_horsepower, data.astonmartin_allmodel_torque, data.astonmartin_allmodel_topspeed);
            }
            else if (brand_selec_count == 8) {
                car_des(data.de_tomaso_allmodel_img,data.de_tomaso_allmodel_years,data.de_tomaso_allmodel_nm,data.de_tomaso_allmodel_engine,data.de_tomaso_allmodel_price,data.de_tomaso_allmodel_0_to_60,data.de_tomaso_allmodel_units,data.de_tomaso_allmodel_desc,data.de_tomaso_allmodel_spec,data.de_tomaso_allmodel_horsepower,data.de_tomaso_allmodel_torque,data.de_tomaso_allmodel_topspeed);
            }
            else if (brand_selec_count == 9) {
                car_des(data.SSC_allmodel_img, data.SSC_allmodel_years, data.SSC_allmodel_nm, data.SSC_allmodel_engine, data.SSC_allmodel_price, data.SSC_allmodel_0_to_60, data.SSC_allmodel_units, data.SSC_allmodel_desc, data.SSC_allmodel_spec, data.SSC_allmodel_horsepower, data.SSC_allmodel_torque, data.SSC_allmodel_topspeed);
            }
            else if (brand_selec_count == 10) {
                car_des(data.w_motors_img, data.w_motors_years, data.w_motors_nm, data.w_motors_engine, data.w_motors_price, data.w_motors_0_to_60, data.w_motors_units, data.w_motors_desc, data.w_motors_spec, data.w_motors_horsepower, data.w_motors_torque, data.w_motors_topspeed);
            }
            else if (brand_selec_count == 11) {
                car_des(data.Maserati_allmodel_img, data.Maserati_allmodel_years, data.Maserati_allmodel_nm, data.Maserati_allmodel_engine, data.Maserati_allmodel_price, data.Maserati_allmodel_0_to_60, data.Maserati_allmodel_units, data.Maserati_allmodel_desc, data.Maserati_allmodel_spec, data.Maserati_allmodel_horsepower, data.Maserati_allmodel_torque, data.Maserati_allmodel_topspeed);
            }
            else if (brand_selec_count == 12) {
                car_des(data.Mercedes_allmodel_img, data.Mercedes_allmodel_years, data.Mercedes_allmodel_nm, data.Mercedes_allmodel_engine, data.Mercedes_allmodel_price, data.Mercedes_allmodel_0_to_60, data.Mercedes_allmodel_units, data.Mercedes_allmodel_desc, data.Mercedes_allmodel_spec, data.Mercedes_allmodel_horsepower, data.Mercedes_allmodel_torque, data.Mercedes_allmodel_topspeed);
            }
            else if (brand_selec_count == 13) {
                car_des(data.Jaguar_allmodel_img, data.Jaguar_allmodel_years, data.Jaguar_allmodel_nm, data.Jaguar_allmodel_engine, data.Jaguar_allmodel_price, data.Jaguar_allmodel_0_to_60, data.Jaguar_allmodel_units, data.jaguar_allmodel_desc, data.Jaguar_allmodel_spec, data.Jaguar_allmodel_horsepower, data.Jaguar_allmodel_torque, data.Jaguar_allmodel_topspeed);
            }
            else if (brand_selec_count == 14) {
                car_des(data.Rolls_Royce_allmodel_img, data.Rolls_Royce_allmodel_years, data.Rolls_Royce_allmodel_nm, data.Rolls_Royce_allmodel_engine, data.Rolls_Royce_allmodel_price, data.Rolls_Royce_allmodel_0_to_60, data.Rolls_Royce_allmodel_units, data.Rolls_Royce_allmodel_desc, data.Rolls_Royce_allmodel_spec, data.Rolls_Royce_allmodel_horsepower, data.Rolls_Royce_allmodel_torque, data.Rolls_Royce_allmodel_topspeed);
            }
        }

        if (clicked_on_srch_or_not==1){
//          for search item select page
            if (srch_brand_selec_count==0) {
                car_des2(data.ferrari_allmodel_img, data.ferrari_allmodel_years, data.ferrari_allmodel_nm, data.ferrari_allmodel_engines, data.ferrari_allmodel_price, data.ferrari_allmodel_0_to_60, data.ferrari_allmodel_units, data.ferrari_allmodel_desc, data.ferrari_allmodel_spec, data.ferrari_allmodel_horsepower, data.ferrari_allmodel_torque, data.ferrari_allmodel_topspeed);
            } else if (srch_brand_selec_count==1) {
                car_des2(data.lambo_allmodel_img, data.lambo_allmodel_years, data.lambo_allmodel_nm, data.lambo_allmodel_engines, data.lambo_allmodel_price, data.lambo_allmodel_0_to_60, data.lambo_allmodel_units, data.lambo_allmodel_des, data.lambo_allmodel_spec, data.lambo_allmodel_horsepower, data.lambo_allmodel_torque, data.lambo_allmodel_topspeed);
            } else if (srch_brand_selec_count==2) {
                car_des2(data.pagani_allmodel_img, data.pagani_allmodel_years, data.pagani_allmodel_nm, data.pagani_allmodel_engine, data.pagani_allmodel_price, data.pagani_allmodel_0_to_60, data.pagani_allmodel_units, data.pagani_allmodel_desc, data.pagani_allmodel_spec, data.pagani_allmodel_horsepower, data.pagani_allmodel_torque, data.pagani_allmodel_topspeed);
            } else if (srch_brand_selec_count==3) {
                car_des2(data.porsche_allmodel_img, data.porsche_allmodel_years, data.porsche_allmodel_nm, data.porsche_allmodel_engine, data.porsche_allmodel_price, data.porsche_allmodel_0_to_60, data.porsche_allmodel_units, data.porsche_allmodel_desc, data.porsche_allmodel_spec, data.porsche_allmodel_horsepower, data.porsche_allmodel_torque, data.porsche_allmodel_topspeed);
            } else if (srch_brand_selec_count==4) {
                car_des2(data.Bugatti_allmodel_img, data.Bugatti_allmodel_years, data.Bugatti_allmodel_nm, data.Bugatti_allmodel_engines, data.Bugatti_allmodel_prices, data.Bugatti_allmodel_0_to_60, data.Bugatti_allmodel_units, data.Bugatti_allmodel_desc, data.Bugatti_allmodel_spec, data.Bugatti_allmodel_horsepower, data.Bugatti_allmodel_torque, data.Bugatti_allmodel_top_speed);
            }else if (srch_brand_selec_count==5) {
                car_des2(data.Koenigsegg_allmodel_img, data.Koenigsegg_allmodel_years, data.Koenigsegg_allmodel_nm, data.Koenigsegg_allmodel_engine, data.Koenigsegg_allmodel_price, data.Koenigsegg_allmodel_0_to_60, data.Koenigsegg_allmodel_units, data.Koenigsegg_allmodel_desc, data.Koenigsegg_allmodel_spec, data.Koenigsegg_allmodel_horsepower, data.Koenigsegg_allmodel_torque, data.Koenigsegg_allmodel_topspeed);
            } else if (srch_brand_selec_count==6) {
                car_des2(data.mclaren_allmodel_img, data.mclaren_allmodel_years, data.mclaren_allmodel_nm, data.mclaren_allmodel_engine, data.mclaren_allmodel_price, data.mclaren_allmodel_0_to_60, data.mclaren_allmodel_units, data.mclaren_allmodel_desc, data.mclaren_allmodel_spec, data.mclaren_allmodel_horsepower, data.mclaren_allmodel_torque, data.mclaren_allmodel_topspeed);
            } else if (srch_brand_selec_count==7) {
                car_des2(data.astonmartin_allmodel_img, data.astonmartin_allmodel_years, data.astonmartin_allmodel_nm, data.astonmartin_allmodel_engine, data.astonmartin_allmodel_price, data.astonmartin_allmodel_0_to_60, data.astonmartin_allmodel_units, data.astonmartin_allmodel_desc, data.astonmartin_allmodel_spec, data.astonmartin_allmodel_horsepower, data.astonmartin_allmodel_torque, data.astonmartin_allmodel_topspeed);
            }else if (srch_brand_selec_count == 8) {
                car_des2(data.de_tomaso_allmodel_img,data.de_tomaso_allmodel_years,data.de_tomaso_allmodel_nm,data.de_tomaso_allmodel_engine,data.de_tomaso_allmodel_price,data.de_tomaso_allmodel_0_to_60,data.de_tomaso_allmodel_units,data.de_tomaso_allmodel_desc,data.de_tomaso_allmodel_spec,data.de_tomaso_allmodel_horsepower,data.de_tomaso_allmodel_torque,data.de_tomaso_allmodel_topspeed);
            }else if (srch_brand_selec_count == 9) {
                car_des2(data.SSC_allmodel_img, data.SSC_allmodel_years, data.SSC_allmodel_nm, data.SSC_allmodel_engine, data.SSC_allmodel_price, data.SSC_allmodel_0_to_60, data.SSC_allmodel_units, data.SSC_allmodel_desc, data.SSC_allmodel_spec, data.SSC_allmodel_horsepower, data.SSC_allmodel_torque, data.SSC_allmodel_topspeed);
            }else if (srch_brand_selec_count == 10) {
                car_des2(data.w_motors_img, data.w_motors_years, data.w_motors_nm, data.w_motors_engine, data.w_motors_price, data.w_motors_0_to_60, data.w_motors_units, data.w_motors_desc, data.w_motors_spec, data.w_motors_horsepower, data.w_motors_torque, data.w_motors_topspeed);
            }else if (srch_brand_selec_count == 11) {
                car_des2(data.Maserati_allmodel_img, data.Maserati_allmodel_years, data.Maserati_allmodel_nm, data.Maserati_allmodel_engine, data.Maserati_allmodel_price, data.Maserati_allmodel_0_to_60, data.Maserati_allmodel_units, data.Maserati_allmodel_desc, data.Maserati_allmodel_spec, data.Maserati_allmodel_horsepower, data.Maserati_allmodel_torque, data.Maserati_allmodel_topspeed);
            }else if (srch_brand_selec_count == 12) {
                car_des2(data.Mercedes_allmodel_img, data.Mercedes_allmodel_years, data.Mercedes_allmodel_nm, data.Mercedes_allmodel_engine, data.Mercedes_allmodel_price, data.Mercedes_allmodel_0_to_60, data.Mercedes_allmodel_units, data.Mercedes_allmodel_desc, data.Mercedes_allmodel_spec, data.Mercedes_allmodel_horsepower, data.Mercedes_allmodel_torque, data.Mercedes_allmodel_topspeed);
            }else if (srch_brand_selec_count == 13) {
                car_des2(data.Jaguar_allmodel_img, data.Jaguar_allmodel_years, data.Jaguar_allmodel_nm, data.Jaguar_allmodel_engine, data.Jaguar_allmodel_price, data.Jaguar_allmodel_0_to_60, data.Jaguar_allmodel_units, data.jaguar_allmodel_desc, data.Jaguar_allmodel_spec, data.Jaguar_allmodel_horsepower, data.Jaguar_allmodel_torque, data.Jaguar_allmodel_topspeed);
            }else if (srch_brand_selec_count == 14) {
                car_des2(data.Rolls_Royce_allmodel_img, data.Rolls_Royce_allmodel_years, data.Rolls_Royce_allmodel_nm, data.Rolls_Royce_allmodel_engine, data.Rolls_Royce_allmodel_price, data.Rolls_Royce_allmodel_0_to_60, data.Rolls_Royce_allmodel_units, data.Rolls_Royce_allmodel_desc, data.Rolls_Royce_allmodel_spec, data.Rolls_Royce_allmodel_horsepower, data.Rolls_Royce_allmodel_torque, data.Rolls_Royce_allmodel_topspeed);
            }

        }
//
        return view;
    }
//    for brnd page
    private void car_des(String car_allmodel_img[],String car_allmodel_yrs[],String allmodel_nm[],String car_allmodel_engines[],String car_allmodel_prices[],String car_allmodel_0_to_60[],String car_allmodel_units[],String car_allmodel_desc[],String car_allmodel_spec[],String car_allmodel_horsepower[],String car_allmodel_torque[],String car_allmodel_top_speed[]){

        Picasso.get().load(data.car_brnd_logos[brand_selec_count]).into(img_car_logo);



        Picasso.get().load(car_allmodel_img[model_select_count]).into(img_bkg_1, new Callback() {
            @Override
            public void onSuccess() {
                // Image loaded successfully, hide Lottie animation
                lottieAnimationView.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                // Handle error, hide Lottie animation
                lottieAnimationView.setVisibility(View.VISIBLE);
            }
        });


//        for images page
        Picasso.get().load(car_allmodel_img[model_select_count]).into(Eximg);
        Picasso.get().load(car_allmodel_img[model_select_count]).into(INimg);
        Picasso.get().load(car_allmodel_img[model_select_count]).into(DRimg);

        txt_car_launch_yr.setText(car_allmodel_yrs[model_select_count]);
        txt_brandnm.setText(data.car_brnd_names[brand_selec_count]);
        txt_modelnm.setText(allmodel_nm[model_select_count]);
        txt_eng_aspect.setText(car_allmodel_engines[model_select_count]);
        txt_price.setText(car_allmodel_prices[model_select_count]);
        txt_0_60.setText(car_allmodel_0_to_60[model_select_count]+" Second's");
        txt_no_of_units_made.setText(car_allmodel_units[model_select_count]+" Units");
        txt_description.setText(car_allmodel_desc[model_select_count]);
        txt_specification.setText(car_allmodel_spec[model_select_count]);

        startCountAnimation(txt_hp, Integer.parseInt(car_allmodel_horsepower[model_select_count])," HP");
        startCountAnimation(txt_topspeed, Integer.parseInt(car_allmodel_top_speed[model_select_count])," KM/H");
        startCountAnimation(txt_torque, Integer.parseInt(car_allmodel_torque[model_select_count])," NM");

    }

//    for searchlist
    private void car_des2(String car_allmodel_img[],String car_allmodel_yrs[],String allmodel_nm[],String car_allmodel_engines[],String car_allmodel_prices[],String car_allmodel_0_to_60[],String car_allmodel_units[],String car_allmodel_desc[],String car_allmodel_spec[],String car_allmodel_horsepower[],String car_allmodel_torque[],String car_allmodel_top_speed[]){

        Picasso.get().load(data.car_brnd_logos[srch_brand_selec_count]).into(img_car_logo);

        Picasso.get().load(car_allmodel_img[srch_model_select_count]).into(img_bkg_1);


//        for images page
        Picasso.get().load(car_allmodel_img[srch_model_select_count]).into(Eximg);
        Picasso.get().load(car_allmodel_img[srch_model_select_count]).into(INimg);
        Picasso.get().load(car_allmodel_img[srch_model_select_count]).into(DRimg);



        txt_car_launch_yr.setText(car_allmodel_yrs[srch_model_select_count]);
        txt_brandnm.setText(data.car_brnd_names[srch_brand_selec_count]);
        txt_modelnm.setText(allmodel_nm[srch_model_select_count]);
        txt_eng_aspect.setText(car_allmodel_engines[srch_model_select_count]);
        txt_price.setText(car_allmodel_prices[srch_model_select_count]);
        txt_0_60.setText(car_allmodel_0_to_60[srch_model_select_count]+" Second's");
        txt_no_of_units_made.setText(car_allmodel_units[srch_model_select_count]+" Units");

        txt_description.setText(car_allmodel_desc[srch_model_select_count]);
        txt_specification.setText(car_allmodel_spec[srch_model_select_count]);

        startCountAnimation(txt_hp, Integer.parseInt(car_allmodel_horsepower[srch_model_select_count])," HP");
        startCountAnimation(txt_topspeed, Integer.parseInt(car_allmodel_top_speed[srch_model_select_count])," KM/H");
        startCountAnimation(txt_torque, Integer.parseInt(car_allmodel_torque[srch_model_select_count])," NM");

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

    private void startCountAnimation(TextView txt,int n,String s) {
        ValueAnimator animator = ValueAnimator.ofInt(0, n); //0 is min number, 600 is max number
        animator.setDuration(5000); //Duration is in milliseconds
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                txt.setText(animation.getAnimatedValue().toString()+s);
            }
        });
        animator.start();

    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}