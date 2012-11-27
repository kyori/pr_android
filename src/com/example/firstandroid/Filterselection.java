package com.example.firstandroid;

import java.io.File;

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

public class Filterselection extends Activity {

	public ImageView imv;
	private static final int CROP_FROM_CAMERA = 2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fs_layout);

//        Bundle bundle = getIntent().getExtras();
//        Bitmap bitmap = (Bitmap)bundle.get("data");
        
        imv= (ImageView)findViewById(R.id.origin);
//        imv.setImageBitmap(bitmap);
        
        
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
        	    finish();
   		}
    	   
       });
       
		final Bundle extras = getIntent().getExtras();
		
		if(extras != null)
		{
			
			Bitmap photo = extras.getParcelable("data");
			imv.setImageBitmap(photo);
		
			
			
		    
//			startActivityForResult(intent, 0);

		}

    }
 



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }
}
