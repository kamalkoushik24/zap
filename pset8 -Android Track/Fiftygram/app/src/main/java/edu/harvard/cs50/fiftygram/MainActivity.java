package edu.harvard.cs50.fiftygram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ViewTarget;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private ImageView imageView;
    private Bitmap bitmap;
    private Button saveImage;
    private  ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    public void choosePhoto(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {

                ParcelFileDescriptor parcelFileDescriptor =
                        getContentResolver().openFileDescriptor(uri, "r");

                FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                parcelFileDescriptor.close();
                imageView.setImageBitmap(bitmap);
                saveImage = findViewById(R.id.saveimage);
                saveImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        saveImage();
                    }
                });




            } catch (IOException e) {
                Log.e("cs50", "Image not found", e);
            }

        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @SuppressLint("CheckResult")

    public void apply(Transformation<Bitmap> filter) {
        Glide
                .with(this)
                .load(bitmap)
                .apply(RequestOptions.bitmapTransform(filter)).into(imageView);


    }

    public void applySepia(View v) {

        apply(new SepiaFilterTransformation());
    }

    public void applyBlur(View v) {
        apply(new BlurTransformation());
    }

    public void applyGrayscale(View v) {
        apply(new GrayscaleTransformation());
    }


    public void imageRevert(View view) {
        imageView.setImageBitmap(bitmap);
    }

    public void saveImage() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap1 = bitmapDrawable.getBitmap();
        MediaStore.Images.Media.insertImage(getContentResolver(), bitmap1, "", "");


    }
}