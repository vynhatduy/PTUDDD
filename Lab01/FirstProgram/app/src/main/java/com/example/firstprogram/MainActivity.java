package com.example.firstprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtX,txtY;
    TextView txtResult;
    Button btnPlus;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    Button btnDiv_W_Re;
    Button btnCamera;
    ImageView imgPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innitControl();
    }

    private void innitControl(){
        txtX=findViewById(R.id.txtX);
        txtY=findViewById(R.id.txtY);
        txtResult=findViewById(R.id.txtResult);
        btnPlus=findViewById(R.id.btnPlus);
        btnDiv=findViewById(R.id.btnDiv);
        btnMul=findViewById(R.id.btnMul);
        btnSub=findViewById(R.id.btnSub);
        btnDiv_W_Re=findViewById(R.id.btnDiv_W_Re);
        imgPhoto=findViewById(R.id.imgPhoto);
        btnCamera=findViewById(R.id.btnCamera);

        btnPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(txtX.getText().toString());
                int y=Integer.parseInt(txtY.getText().toString());
                int result=x+y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(txtX.getText().toString());
                int y=Integer.parseInt(txtY.getText().toString());
                int result=x-y;
                txtResult.setText(String.valueOf(result));
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(txtX.getText().toString());
                int y=Integer.parseInt(txtY.getText().toString());
                int result=x*y;
                txtResult.setText(String.valueOf(result));
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(txtX.getText().toString());
                int y=Integer.parseInt(txtY.getText().toString());
                int result=x/y;
                txtResult.setText(String.valueOf(result));
            }
        });
        btnDiv_W_Re.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x= Integer.parseInt(txtX.getText().toString());
                int y=Integer.parseInt(txtY.getText().toString());
                int result=x%y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode==100 && resultCode==RESULT_OK  && data!=null) {
            Bitmap bitmap =(Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

}