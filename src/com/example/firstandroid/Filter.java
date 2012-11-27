package com.example.firstandroid;

import java.io.File;

import com.example.firstandroid.R;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Filter extends Activity implements OnClickListener {

	private static final int PICK_FROM_CAMERA = 0;
	private static final int PICK_FROM_ALBUM = 1;
	private static final int CROP_FROM_CAMERA = 2;

	private Uri mImageCaptureUri;
	private ImageView mPhotoImageView;
	private Button mButton;

	public Button mGalleryButton;
	public Button mFotoButton;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.f_layout);

		mPhotoImageView = (ImageView) findViewById(R.id.origin);
        mFotoButton = (Button)findViewById(R.id.cameraBtn);
        mFotoButton.setOnClickListener(new OnClickListener() {
     	   public void onClick(View v) {
     		  doTakePhotoAction();
 		}
     	   
        });
        
        
       mGalleryButton = (Button)findViewById(R.id.galleryBtn);
       mGalleryButton.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
    		   doTakeAlbumAction();
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
    	   public void onClick(View v) {
        	    Intent myIntent = new Intent(getApplicationContext(), Filterselection.class);
        	    startActivity(myIntent);
        	    finish();
   		}
    	   
       });

	}

	/**
	 * ī�޶󿡼� �̹��� ��������
	 */
	private void doTakePhotoAction()
	{
		/*
		 * ���� �غ���
		 * http://2009.hfoss.org/Tutorial:Camera_and_Gallery_Demo
		 * http://stackoverflow.com/questions/1050297/how-to-get-the-url-of-the-captured-image
		 * http://www.damonkohler.com/2009/02/android-recipes.html
		 * http://www.firstclown.us/tag/android/
		 */

		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		
		// �ӽ÷� ����� ������ ��θ� ����
		String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
		mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
		
		intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
		intent.putExtra("return-data", true);

		startActivityForResult(intent, PICK_FROM_CAMERA);

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
	
	
	/**
	 * �ٹ����� �̹��� ��������
	 */
	private void doTakeAlbumAction()
	{
		// �ٹ� ȣ��
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);

		startActivityForResult(intent, PICK_FROM_ALBUM);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(resultCode != RESULT_OK)
		{
			return;
		}

		switch(requestCode)
		{
			case CROP_FROM_CAMERA:
			{
				// ũ���� �� ������ �̹����� �Ѱ� �޽��ϴ�. �̹����信 �̹����� �����شٰų� �ΰ����� �۾� ���Ŀ�
				// �ӽ� ������ �����մϴ�.
//				final Bundle extras = data.getExtras();
//	
//				if(extras != null)
//				{
//					
//					Bitmap photo = extras.getParcelable("data");
//					mPhotoImageView.setImageBitmap(photo);
					
					// ���⼭ intent �����ؼ� photo�� resultŬ������ �Ѱ��ָ�ǳ�????
//					Intent i = new Intent(getApplicationContext(), Filterselection.class);
//					i.putExtra(name, value);
					
	//				setContrast(mPhotoImageView);
					
				    
//					startActivityForResult(intent, 0);

//				}
				
			    Intent myIntent = new Intent(getApplicationContext(), Filterselection.class);
			    myIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
			    
				startActivity(myIntent);
	
				// �ӽ� ���� ����
				File f = new File(mImageCaptureUri.getPath());
				if(f.exists())
				{
					f.delete();
				}
				
				finish();
				break;
			}
	
			case PICK_FROM_ALBUM:
			{
				// ������ ó���� ī�޶�� �����Ƿ� �ϴ�  break���� �����մϴ�.
				// ���� �ڵ忡���� ���� �ո����� ����� �����Ͻñ� �ٶ��ϴ�.				
				mImageCaptureUri = data.getData();
			}
			
			case PICK_FROM_CAMERA:
			{
				// �̹����� ������ ������ ���������� �̹��� ũ�⸦ �����մϴ�.
				// ���Ŀ� �̹��� ũ�� ���ø����̼��� ȣ���ϰ� �˴ϴ�.
	
				Intent intent = new Intent("com.android.camera.action.CROP");
				intent.setDataAndType(mImageCaptureUri, "image/*");
	
				intent.putExtra("outputX", 150);
				intent.putExtra("outputY", 150);
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);
				intent.putExtra("scale", true);
				intent.putExtra("return-data", true);
				intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
				
				startActivityForResult(intent, CROP_FROM_CAMERA);
				
				break;
			}
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }
}
