package com.example.firstandroid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.example.firstandroid.R;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Filterselection extends Activity {

	private ImageView imv;
	private static final int CROP_FROM_CAMERA = 2;
	public String hello;
	public Bundle bundle;
//	public Bitmap result_bmp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fs_layout);

        Bundle bundle = this.getIntent().getExtras();

            final Bitmap bitmap = bundle.getParcelable("bitmap");
            
            imv= (ImageView)findViewById(R.id.origin);
            imv.setImageBitmap(bitmap);

            
            ImageButton filter1= (ImageButton)findViewById(R.id.filter01);
    	    Bitmap f_image1= BitmapFactory.decodeResource(getResources(), R.drawable.filter_cont);
    	    filter1.setImageBitmap(f_image1);

            filter1.setOnClickListener(new OnClickListener() {
          	   public void onClick(View v) {
          		   setContrast(imv);          		   
          	   }
          	   
             });
            
            ImageButton filter2= (ImageButton)findViewById(R.id.filter02);
            Bitmap f_image2= BitmapFactory.decodeResource(getResources(), R.drawable.filter_rever);
    	    filter2.setImageBitmap(f_image2);
            
    	    filter2.setOnClickListener(new OnClickListener() {
          	   public void onClick(View v) {
          		   setReversal(imv);
          	   }
          	   
             });

            ImageButton filter3= (ImageButton)findViewById(R.id.filter03);
            Bitmap f_image3= BitmapFactory.decodeResource(getResources(), R.drawable.filter_class);
    	    filter3.setImageBitmap(f_image3);
    	    
            filter3.setOnClickListener(new OnClickListener() {
          	   public void onClick(View v) {
          		   setClear(imv);
          	   }
          	   
             });
            
            ImageButton nextBtn = (ImageButton)findViewById(R.id.nextBtn);
            Bitmap n_image= BitmapFactory.decodeResource(getResources(), R.drawable.btn_next);
    	    nextBtn.setImageBitmap(n_image);
    	    
            nextBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
         		   Intent myIntent = new Intent(getApplicationContext(), Result.class);
             	   myIntent.putExtra("bitmap", bitmap);
             	    
             	    startActivity(myIntent);
             	    finish();
        		}
         	   
            });
 
        
        ImageButton backBtn = (ImageButton)findViewById(R.id.backBtn);
        Bitmap b_image= BitmapFactory.decodeResource(getResources(), R.drawable.btn_main);
	    backBtn.setImageBitmap(b_image);
        
        backBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "메인으로 돌아갑니다.", Toast.LENGTH_LONG).show();
			finish();
		}
    	   
       });
       
       
       
    }
    

	public void setContrast(ImageView v){
		ColorMatrix matrix = new ColorMatrix(new float[]{
				1, 0, 0, 0, 50,
				0, 1, 0, 0, 50,
				0, 0, 1, 0, 50,
				0, 0, 0, 1, 0
		});
//		matrix.setSaturation(.4f);//0이면 grayscale
		ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
		v.setColorFilter(cf);
	}
	
	public void setReversal(ImageView v){
		//반전
		ColorMatrix matrix = new ColorMatrix(new float[]{
				-1, 0, 0, 0, 255,
				0, -1, 0, 0, 255,
				0, 0, -1, 0, 255,
				0, 0, 0, 1, 0});		
		ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
		v.setColorFilter(cf);
	}
	
	public void setClear(ImageView v){
		ColorMatrix matrix = new ColorMatrix(new float[]{
				1.438f, -.062f, -0.062f, 0, 10,
				-0.122f, 1.378f, -0.122f, 0, 30,
				-0.016f, -0.016f, 1.483f, 0, 10,
				-0.03f, 0.05f, -0.02f, 1, 0});		
//		ColorMatrix matrix = new ColorMatrix(new float[]{
//				-1, 0, 0, 0, 255,
//				0, -1, 0, 0, 255,
//				0, 0, -1, 0, 255,
//				0, 0, 0, 1, 0});		

		ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
		v.setColorFilter(cf);
	}

// 
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data)
//	{
//		if(resultCode != RESULT_OK)
//		{
//			return;
//		}
//
//		switch(requestCode)
//		{
//			case SELECT_FILTER: {
//				
//	 			Toast.makeText(getApplicationContext(), "success!", Toast.LENGTH_LONG).show();
//				final Bundle extras = data.getExtras();
//				String know = extras.toString();
//	 			Toast.makeText(getApplicationContext(), know, Toast.LENGTH_LONG).show();
//
//				if(extras != null)
//				{
//					
//					Bitmap photo = extras.getParcelable("data");
//					String hello = photo.toString();
//		 			Toast.makeText(getApplicationContext(), hello, Toast.LENGTH_LONG).show();
//
//					imv.setImageBitmap(photo);
//					
//
//			}
//		}
//	}
//
//}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }
}
