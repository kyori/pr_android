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

public class Filter extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_layout);

        Button cameraBtn = (Button)findViewById(R.id.cameraBtn);
        cameraBtn.setOnClickListener(new OnClickListener() {
     	   public void onClick(View v) {
 			Toast.makeText(getApplicationContext(), "카메라 버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
 		//	finish();
 		}
     	   
        });
        
        
       Button galleryBtn = (Button)findViewById(R.id.galleryBtn);
       galleryBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "갤러리 버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
		//	finish();
		}
    	   
       });

       Button backBtn = (Button)findViewById(R.id.backBtn);
       backBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "메인으로 돌아갑니다.", Toast.LENGTH_LONG).show();
			finish();
		}
    	   
       });
       
       
       Button nextBtn = (Button)findViewById(R.id.nextBtn);
       nextBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
        	    Intent myIntent = new Intent(getApplicationContext(), Result.class);
        	    startActivity(myIntent);
//        	    finish();
   		}
    	   
       });

    }
 


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }
}
