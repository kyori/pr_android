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
        
        Bitmap result_bitmap = BitmapFactory.decodeResource(getResources(), R.id.origin);

        imv= (ImageView)findViewById(R.id.origin);
        imv.setImageBitmap(bitmap);
        
        
        Button shareBtn = (Button)findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new OnClickListener() {
     	   public void onClick(View v) {
 			Toast.makeText(getApplicationContext(), "������ SNS�� �����մϴ�.", Toast.LENGTH_LONG).show();
 		//	finish();
     	   }
        }
        );
        
     	Button downBtn = (Button)findViewById(R.id.downloadBtn);
     	downBtn.setOnClickListener(new OnClickListener() {
     		public void onClick(View v){
     			FileOutputStream out = null;

     			try{
     				out=new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/photo_"+ String.valueOf(System.currentTimeMillis())+ ".png");
     				bitmap.compress(Bitmap.CompressFormat.PNG, 50, out);
     				
     				sendBroadcast(new Intent(
     					    Intent.ACTION_MEDIA_MOUNTED,
     					    Uri.parse("file://" + Environment.getExternalStorageDirectory())));
     				
     			}
     			catch(FileNotFoundException e)
     			{
     				e.printStackTrace();
     			}
     			
			    
   			Toast.makeText(getApplicationContext(), "������ �ٿ�ε� �Ǿ����ϴ�.", Toast.LENGTH_LONG).show();

     		}
     	}
     	);
        
        

       Button backBtn = (Button)findViewById(R.id.backBtn);
       backBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "�������� ���ư��ϴ�.", Toast.LENGTH_LONG).show();
			finish();
		}
    	   
       });
       
        
    }
    
//    public static boolean saveImageExternalStorage(Bitmap image, String imageName) throws IOException {
//        // ���� ����
//        File file = new File(Environment.getExternalStorageDirectory(),
//                imageName);
//        
//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File new_file = new File(path, imageName);
//        
//        // Cache ������ �����Ϸ��� getExternalCacheDir()
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
