package com.example.samy.capturecamera;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
   String pathAbsolute=null;
   int image_capture_code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void captureImage(View view) throws IOException {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       if(intent.resolveActivity(getPackageManager())!=null){
           File file=null;
           file=getFile();
           if(!file.exists()){
               file.mkdir();
           }
           if(file!=null){
               Uri uri=FileProvider.getUriForFile(this,"com.example.android.fileprovider",file);
               intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
               startActivityForResult(intent,image_capture_code);
           }

       }

    }

    public void displayImage(View view) {
        Intent intent=new Intent(this,DisplayImage.class);
        intent.putExtra("image_file",pathAbsolute);
        startActivity(intent);
    }

    public File getFile() throws IOException {
        String fileName=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File myfile=File.createTempFile(fileName,".jpg",dir);
        pathAbsolute=myfile.getAbsolutePath();
        return myfile;
    }
}
