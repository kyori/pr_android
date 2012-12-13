package com.example.firstandroid;

import java.io.File;

import com.example.firstandroid.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Filterselection extends Activity {

	private ImageView imv;
	private static final int CROP_FROM_CAMERA = 2;
	public String hello;
	public Bundle bundle;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fs_layout);

        Bundle bundle = this.getIntent().getExtras();
        
//        if(bundle != null) {
//         String value= bundle.toString();
//    		Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();

            final Bitmap bitmap = bundle.getParcelable("bitmap");
            
            imv= (ImageView)findViewById(R.id.origin);
            imv.setImageBitmap(bitmap);
//            setContrast(imv);
        	
//        }
            Button filter1= (Button)findViewById(R.id.filter01);
            filter1.setOnClickListener(new OnClickListener() {
          	   public void onClick(View v) {
          		   setContrast(imv);
          	   }
          	   
             });
            
            Button filter2= (Button)findViewById(R.id.filter02);
            filter2.setOnClickListener(new OnClickListener() {
          	   public void onClick(View v) {
          		   setReversal(imv);
          	   }
          	   
             });

            Button filter3= (Button)findViewById(R.id.filter03);
            filter3.setOnClickListener(new OnClickListener() {
          	   public void onClick(View v) {
          		   setClear(imv);
          	   }
          	   
             });
            Button nextBtn = (Button)findViewById(R.id.nextBtn);
            nextBtn.setOnClickListener(new OnClickListener() {
         	   public void onClick(View v) {
             	    Intent myIntent = new Intent(getApplicationContext(), Result.class);
             	    myIntent.putExtra("bitmap", bitmap);
             	    
             	    startActivity(myIntent);
             	    finish();
        		}
         	   
            });
 
        
        Button backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "�������� ���ư��ϴ�.", Toast.LENGTH_LONG).show();
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
//		matrix.setSaturation(.4f);//0�̸� grayscale
		ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
		v.setColorFilter(cf);
	}
	
	public void setReversal(ImageView v){
		//����
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
