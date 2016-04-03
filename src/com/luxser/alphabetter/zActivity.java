package com.luxser.alphabetter;

//alphaBetter

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class zActivity extends Activity {
	@Override
	 public void onBackPressed() {
		 
		 
	 }
	private ImageButton button1;
	private Button button2;
	private Button button3;
	private MediaPlayer player;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_zz);
        button1 = (ImageButton) findViewById(R.id.Button1);
		button2 = (Button) findViewById(R.id.Button2);
		button3 = (Button) findViewById(R.id.Button3);
		button1.setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	stopPlaying(player);
		    	player = MediaPlayer.create(zActivity.this, R.raw.z);
		    	player.start();
		    	
		    }
		});
		button2.setOnClickListener( new View.OnClickListener() {
		    @SuppressLint("NewApi") @Override
		    public void onClick(View v) {
		    	createSaved("z","z");
		    	final Intent i = new Intent(zActivity.this,SampleActivity.class);
		    	onDestroy();
		        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	   	        
		    }
		});
		button3.setOnClickListener( new View.OnClickListener() {
		    @SuppressLint("NewApi") @Override
		    public void onClick(View v) {
		    	createSaved("z","N");
		    	final Intent i = new Intent(zActivity.this,SampleActivity.class);
		    	onDestroy();
		        startActivity(i);
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		    }
		});
		
		
        
        SharedPreferences prefs = getSharedPreferences("a", 0);//getPreferences(0); 
	    if(prefs == null){
	    	defaultVariables();
	    }
	}

	
	 public void defaultVariables(){
		 createSaved("a", "a");
		 createSaved("b", "b");
		 createSaved("c", "c");
		 createSaved("d", "d");
		 createSaved("e", "e");
		 createSaved("f", "f");
		 createSaved("g", "g");
		 createSaved("h", "h");
		 createSaved("i", "i");
		 createSaved("j", "j");
		 createSaved("k", "k");
		 createSaved("l", "l");
		 createSaved("m", "m");
		 createSaved("n", "n");
		 createSaved("o", "o");
		 createSaved("p", "p");
		 createSaved("q", "q");
		 createSaved("r", "r");
		 createSaved("s", "s");
		 createSaved("t", "t");
		 createSaved("u", "u");
		 createSaved("v", "v");
		 createSaved("w", "w");
		 createSaved("x", "x");
		 createSaved("y", "y");
		 createSaved("z", "z");
	 }
	public void createSaved(String name, String value){
    	SharedPreferences prefs = getSharedPreferences(name, Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = prefs.edit();
    	editor.putString(name, value);
    	editor.commit();
    }
	 private void stopPlaying(MediaPlayer mp) {
         if (mp != null) {
             mp.stop();
             mp.release();
             mp = null;
        }
     }
	
}
