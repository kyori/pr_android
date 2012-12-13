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
 			Toast.makeText(getApplicationContext(), "사진을 SNS에 공유합니다.", Toast.LENGTH_LONG).show();
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
     				
//    			    MediaScannerConnection.scanFile(this,
//			                new String[] { out.toString() }, null,
//			                new MediaScannerConnection.OnScanCompletedListener() {
//			            public void onScanCompleted(String path, Uri uri) {
//			                Log.i("ExternalStorage", "Scanned " + path + ":");
//			                Log.i("ExternalStorage", "-> uri=" + uri);
//			            }
//			        });     			

     			}
     			catch(FileNotFoundException e)
     			{
     				e.printStackTrace();
     			}
     			
			    
   			Toast.makeText(getApplicationContext(), "사진이 다운로드 되었습니다.", Toast.LENGTH_LONG).show();

     		}
//     		public void onClick(View v) {
//     		  try {
//				saveImageExternalStorage(bitmap, String.valueOf(System.currentTimeMillis()));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//     		
//   			Toast.makeText(getApplicationContext(), "사진이 다운로드 되었습니다.", Toast.LENGTH_LONG).show();
//
//     	   }
     	}
     	);
        
        

       Button backBtn = (Button)findViewById(R.id.backBtn);
       backBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "메인으로 돌아갑니다.", Toast.LENGTH_LONG).show();
			finish();
		}
    	   
       });
       
        
    }
    
    public static boolean saveImageExternalStorage(Bitmap image, String imageName) throws IOException {
        // 파일 생성
        File file = new File(Environment.getExternalStorageDirectory(),
                imageName);
        
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File new_file = new File(path, imageName);
        
        // Cache 폴더에 저장하려면 getExternalCacheDir()
        new_file.createNewFile();
 
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(file));
        image.compress(CompressFormat.JPEG, 100, out);
        out.flush();
        out.close();
 
        return true;
    }

//    void createExternalStoragePublicPicture() {
//        // Create a path where we will place our picture in the user's
//        // public pictures directory.  Note that you should be careful about
//        // what you place here, since the user often manages these files.  For
//        // pictures and other media owned by the application, consider
//        // Context.getExternalMediaDir().
//        File path = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File file = new File(path, "DemoPicture.jpg");
//
//        try {
//            // Make sure the Pictures directory exists.
//            path.mkdirs();
//
//            // Very simple code to copy a picture from the application's
//            // resource into the external file.  Note that this code does
//            // no error checking, and assumes the picture is small (does not
//            // try to copy it in chunks).  Note that if external storage is
//            // not currently mounted this will silently fail.
//            InputStream is = getResources().openRawResourceFd("bitmap");
//            OutputStream os = new FileOutputStream(file);
//            byte[] data = new byte[is.available()];
//            is.read(data);
//            os.write(data);
//            is.close();
//            os.close();
//
//            // Tell the media scanner about the new file so that it is
//            // immediately available to the user.
//            MediaScannerConnection.scanFile(this,
//                    new String[] { file.toString() }, null,
//                    new MediaScannerConnection.OnScanCompletedListener() {
//                public void onScanCompleted(String path, Uri uri) {
//                    Log.i("ExternalStorage", "Scanned " + path + ":");
//                    Log.i("ExternalStorage", "-> uri=" + uri);
//                }
//            });
//        } catch (IOException e) {
//            // Unable to create file, likely because external storage is
//            // not currently mounted.
//            Log.w("ExternalStorage", "Error writing " + file, e);
//        }
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout1, menu);
        return true;
    }


}
