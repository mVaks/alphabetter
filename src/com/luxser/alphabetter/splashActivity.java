package com.luxser.alphabetter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class splashActivity extends Activity {
	
	public void onBackPressed() {
	    Log.d("CDA", "onBackPressed Called");
	    Intent setIntent = new Intent(Intent.ACTION_MAIN);
	    setIntent.addCategory(Intent.CATEGORY_HOME);
	    setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    startActivity(setIntent);
	 }
   
  //Set waktu lama splashscreen
  private static int splashInterval = 1500;
 private ImageView imageView;
  @SuppressLint("NewApi") @Override
  protected void onCreate(Bundle savedInstanceState) {
	  
   super.onCreate(savedInstanceState);
  requestWindowFeature(Window.FEATURE_NO_TITLE);
  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    WindowManager.LayoutParams.FLAG_FULLSCREEN);   
   overridePendingTransition(R.anim.fadei, R.anim.fadeo);
  
   
   setContentView(R.layout.splashscreen);
   
   imageView = (ImageView)findViewById(R.id.imageView2);
   imageView.setBackgroundResource(R.drawable.movie);
   AnimationDrawable anim = (AnimationDrawable) imageView.getBackground();
   anim.start();

   new Handler().postDelayed(new Runnable() {
     
     
    @Override
    public void run() {
     // TODO Auto-generated method stub
  

     Intent i = new Intent(splashActivity.this, SampleActivity.class);
     overridePendingTransition(R.anim.fadei, R.anim.fadeo);

     startActivity(i);
     overridePendingTransition(R.anim.fadei, R.anim.fadeo);

  
                                 //jeda selesai Splashscreen
     this.finish();
        }

 private void finish() {
  // TODO Auto-generated method stub
  
 }
     }, splashInterval);
     
   };
     
  }
