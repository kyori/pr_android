package com.example.firstandroid;

import com.example.firstandroid.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity1 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        
//       Button startBtn = (Button)findViewById(R.id.startBtn);
//       startBtn.setOnClickListener(new OnClickListener() {
//    	   public void onClick(View v) {
//			Toast.makeText(getApplicationContext(), "���۹�ư�� ���Ƚ��ϴ�!", Toast.LENGTH_LONG).show();
//
//    	    Intent myIntent = new Intent(getApplicationContext(), NewActivity.class);
//    	    startActivity(myIntent);
//    	   }
//    	   
//       });
        
       ImageButton start02Btn = (ImageButton)findViewById(R.id.start02Btn);
       Bitmap f_image = BitmapFactory.decodeResource(getResources(), R.drawable.filter);       
       start02Btn.setImageBitmap(f_image);
       
       start02Btn.setOnClickListener(new OnClickListener() {
    	  public void onClick(View v){
      	    Intent myIntent = new Intent(getApplicationContext(), Filter.class);
      	    startActivity(myIntent);
    	  }
       });
       
       ImageButton start03Btn = (ImageButton)findViewById(R.id.start03Btn);
       Bitmap d_image = BitmapFactory.decodeResource(getResources(), R.drawable.distortion);       
       start03Btn.setImageBitmap(d_image);
       
       start03Btn.setOnClickListener(new OnClickListener() {
    	  public void onClick(View v){
      	    Intent myIntent = new Intent(getApplicationContext(), Distortion.class);
      	    startActivity(myIntent);
    	  }
       });
       
       ImageButton start04Btn = (ImageButton)findViewById(R.id.start04Btn);
       Bitmap m_image = BitmapFactory.decodeResource(getResources(), R.drawable.mix);       
       start04Btn.setImageBitmap(m_image);
       
       start04Btn.setOnClickListener(new OnClickListener() {
    	  public void onClick(View v){
    		  Intent myIntent = new Intent(getApplicationContext(), Mix.class);
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
