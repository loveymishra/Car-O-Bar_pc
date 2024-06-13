package com.example.designpractice;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class full_imageview_for_show_media_frg extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    ImageView imageView;

    ImageButton dwnld_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_imageview_for_show_media_frg);

        imageView=(ImageView) findViewById(R.id.imageView2);
        lottieAnimationView=(LottieAnimationView)findViewById(R.id.lt_animation_for_car_img_page);
        dwnld_btn=(ImageButton) findViewById(R.id.dwnld_btn);


        int c=data.get_clicked_position_of_img();
        Picasso.get().load(data.allimg[c]).into(imageView, new Callback() {
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


        dwnld_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageToGallery();
            }
        });


    }

    private void saveImageToGallery() {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        String displayName = "image_" + System.currentTimeMillis() + ".jpg";

        // Prepare values for inserting to MediaStore
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, displayName);
        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);
        }

        // Get content resolver
        ContentResolver resolver = getContentResolver();

        // Insert image to MediaStore
        Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

        try {
            // Open output stream
            OutputStream outputStream = resolver.openOutputStream(Objects.requireNonNull(imageUri));

            // Compress bitmap and write to output stream
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

            // Close output stream
            outputStream.close();

            // Show success message
            Toast.makeText(this, "Image saved to gallery", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // Show error message
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}