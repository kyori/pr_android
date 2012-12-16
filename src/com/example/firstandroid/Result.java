package com.example.firstandroid;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.example.firstandroid.R;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Result extends Activity {

	public ImageView imv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        
        
        Bundle bundle = this.getIntent().getExtras();

        final Bitmap bitmap = bundle.getParcelable("bitmap");
        
//        Bitmap result_bitmap = BitmapFactory.decodeResource(getResources(), R.id.origin);

        imv= (ImageView)findViewById(R.id.origin);
        imv.setImageBitmap(bitmap);
        
        
        
        
        ImageButton shareBtn = (ImageButton)findViewById(R.id.shareBtn);
	    Bitmap s_image= BitmapFactory.decodeResource(getResources(), R.drawable.btn_sns);
	    shareBtn.setImageBitmap(s_image);

        shareBtn.setOnClickListener(new OnClickListener() {
     	   public void onClick(View v) {
 			Toast.makeText(getApplicationContext(), "사진을 SNS에 공유합니다.", Toast.LENGTH_LONG).show();
 		//	finish();
     	   }
        }
        );
        
     	ImageButton downBtn = (ImageButton)findViewById(R.id.downloadBtn);
	    Bitmap d_image= BitmapFactory.decodeResource(getResources(), R.drawable.btn_save);
	    downBtn.setImageBitmap(d_image);

     	downBtn.setOnClickListener(new OnClickListener() {
     		public void onClick(View v){
     			FileOutputStream out = null;

     			try{
     				
     					File path = new File("/sdcard/PhotoRevolution");
     				     if(! path.isDirectory()) {
     				             path.mkdirs();
     				      }
     				
     				
     				out = new FileOutputStream("/sdcard/PhotoRevolution"+"/photo_"+ String.valueOf(System.currentTimeMillis())+ ".png");
     				bitmap.compress(Bitmap.CompressFormat.PNG, 50, out);
     				
     				sendBroadcast(new Intent(
     					    Intent.ACTION_MEDIA_MOUNTED,
     					    Uri.parse("file://" + Environment.getExternalStorageDirectory())));
     				
     			}
     			catch(FileNotFoundException e)
     			{
     				e.printStackTrace();
     			}
     						    
   			Toast.makeText(getApplicationContext(), "사진이 다운로드 되었습니다.", Toast.LENGTH_LONG).show();

     		}
     	}
     	);
        
        

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
    
//    public static boolean saveImageExternalStorage(Bitmap image, String imageName) throws IOException {
//        // 파일 생성
//        File file = new File(Environment.getExternalStorageDirectory(),
//                imageName);
//        
//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File new_file = new File(path, imageName);
//        
//        // Cache 폴더에 저장하려면 getExternalCacheDir()
//        new_file.createNewFile();
// 
//        BufferedOutputStream out = new BufferedOutputStream(
//                new FileOutputStream(file));
//        image.compress(CompressFormat.JPEG, 100, out);
//        out.flush();
//        out.close();
// 
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }


}
