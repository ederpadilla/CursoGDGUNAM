package dev.eder.padilla.cursogdgunam.camer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.eder.padilla.cursogdgunam.R;

public class CameraActivity extends AppCompatActivity {
    @BindView(R.id.imgv)
    ImageView imageView;
    @BindView(R.id.btn_take_pic)
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            checkCameraPermission();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            Log.e("CameraActivity","El permiso no existe");
            requestPermissions(new String[]{Manifest.permission.CAMERA},20);
        }else{
            Log.e("CameraActivity","El permiso existe");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 20:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Log.e("CameraActivity","El permiso existe");
                }else{
                    Log.e("CameraActivity","El permiso existe");
                }
                break;
        }
    }
    static final int REQUEST_PIC =1 ;
    @OnClick(R.id.btn_take_pic) public void takePic(){
        Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePicIntent,REQUEST_PIC);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PIC&&resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}
