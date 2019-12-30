package com.pawan.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;

public class GallaryActivity extends AppCompatActivity {
    ImageView gallaryView;
    Button btnGallary;
    String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        gallaryView=findViewById(R.id.gallaryView);
        btnGallary=findViewById(R.id.btnGallary);

        btnGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });

    }

    private void BrowseImage() {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            if(data==null)
            {
                Toast.makeText(this, "PLease Select image", Toast.LENGTH_SHORT).show();

            }


        }
        Uri uri=data.getData();
//        imagePath=getRealPathFromUri(uri);
        gallaryView.setImageURI(uri);
    }

//    private String getRealPathFromUri(Uri uri) {
//    }

}
