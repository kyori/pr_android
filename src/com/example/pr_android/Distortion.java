package com.example.pr_android;

import com.example.pr_android.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.Toast;

public class Distortion extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_layout);
        
        Button cameraBtn = (Button)findViewById(R.id.cameraBtn);
        cameraBtn.setOnClickListener(new OnClickListener() {
     	   public void onClick(View v) {
 			Toast.makeText(getApplicationContext(), "ī�޶� ��ư�� �������ϴ�.", Toast.LENGTH_LONG).show();
 		//	finish();
 		}
     	   
        });
        
        
       Button galleryBtn = (Button)findViewById(R.id.galleryBtn);
       galleryBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "������ ��ư�� �������ϴ�.", Toast.LENGTH_LONG).show();
		//	finish();
		}
    	   
       });

       Button backBtn = (Button)findViewById(R.id.backBtn);
       backBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "�������� ���ư��ϴ�.", Toast.LENGTH_LONG).show();
			finish();
		}
    	   
       });
       
       Button nextBtn = (Button)findViewById(R.id.nextBtn);
       nextBtn.setOnClickListener(new OnClickListener() {
    	  public void onClick(View v){
      	    Intent myIntent = new Intent(getApplicationContext(), Result.class);
      	    startActivity(myIntent);
    	  }
       });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }
}
