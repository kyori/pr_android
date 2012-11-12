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

public class Activity1 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        
//       Button startBtn = (Button)findViewById(R.id.startBtn);
//       startBtn.setOnClickListener(new OnClickListener() {
//    	   public void onClick(View v) {
//			Toast.makeText(getApplicationContext(), "시작버튼이 눌렸습니다!", Toast.LENGTH_LONG).show();
//
//    	    Intent myIntent = new Intent(getApplicationContext(), NewActivity.class);
//    	    startActivity(myIntent);
//    	   }
//    	   
//       });
       
       Button start02Btn = (Button)findViewById(R.id.start02Btn);
       start02Btn.setOnClickListener(new OnClickListener() {
    	  public void onClick(View v){
      	    Intent myIntent = new Intent(getApplicationContext(), Filter.class);
      	    startActivity(myIntent);
    	  }
       });
       
       Button start03Btn = (Button)findViewById(R.id.start03Btn);
       start03Btn.setOnClickListener(new OnClickListener() {
    	  public void onClick(View v){
      	    Intent myIntent = new Intent(getApplicationContext(), Distortion.class);
      	    startActivity(myIntent);
    	  }
       });
       
       Button start04Btn = (Button)findViewById(R.id.start04Btn);
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
