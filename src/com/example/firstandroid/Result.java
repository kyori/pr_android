package com.example.firstandroid;

import com.example.firstandroid.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Result extends Activity {

	public ImageView imv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        
        
        Bundle bundle = this.getIntent().getExtras();

        Bitmap bitmap = bundle.getParcelable("bitmap");
        
        imv= (ImageView)findViewById(R.id.origin);
        imv.setImageBitmap(bitmap);
        
        
        Button shareBtn = (Button)findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new OnClickListener() {
     	   public void onClick(View v) {
 			Toast.makeText(getApplicationContext(), "사진을 SNS에 공유합니다.", Toast.LENGTH_LONG).show();
 		//	finish();
 		}
     	   
        });
        
        
       Button downloadBtn = (Button)findViewById(R.id.downloadBtn);
       downloadBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "사진을 다운로드합니다.", Toast.LENGTH_LONG).show();
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
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }
}
