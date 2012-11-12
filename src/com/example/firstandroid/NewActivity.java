package com.example.firstandroid;

import com.example.firstandroid.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);
        
       Button backBtn = (Button)findViewById(R.id.backBtn);
       backBtn.setOnClickListener(new OnClickListener() {
    	   public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "���ư��� ��ư�� ���Ⱦ��.", Toast.LENGTH_LONG).show();
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
