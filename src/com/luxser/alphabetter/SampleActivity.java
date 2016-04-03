package com.luxser.alphabetter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SampleActivity extends Activity implements OnClickListener {
	private final int RESPONSE_OK = 200;
	
	private final int IMAGE_PICKER_REQUEST = 1;
	
	private TextView picNameText;
	private EditText langCodeField;
	private EditText apiKeyFiled;
    private Spinner spinner;
    private static final String[]paths = {"en", "ru", "es"};


	
	private String apiKey;
	private String langCode;
	private String fileName;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);

		//check if preference exists
		
		SharedPreferences prefs = getSharedPreferences("a", 0);//getPreferences(0); 
		String checkNull = prefs.getString("a", "DEFAULT");
		
	    if(checkNull == "DEFAULT"){
	    	defaultVariables();
	    }
	    spinner = (Spinner)findViewById(R.id.lanuageCode);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(SampleActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        
		picNameText = (TextView) findViewById(R.id.imageName);
		//langCodeField = (EditText) findViewById(R.id.lanuageCode);
		apiKeyFiled = (EditText) findViewById(R.id.apiKey);
		
		final Button preferencesButton = (Button) findViewById(R.id.preferences);
		preferencesButton.setOnClickListener(new OnClickListener() {
			@SuppressLint("NewApi") @Override
			public void onClick(View v) {
				// Starting preferences activity
				final Intent i = new Intent(SampleActivity.this,PreferencesActivity.class);
		        startActivity(i);
		        onDestroy();
	   	        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}
		});


		final Button pickButton = (Button) findViewById(R.id.picImagebutton);
		pickButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Starting image picker activity
				startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), IMAGE_PICKER_REQUEST);
			}
		});

		final Button convertButton = (Button) findViewById(R.id.convert);
		convertButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		//apiKey="QdgJmSnWjK";
		langCode="En";
		apiKey = apiKeyFiled.getText().toString();
		//langCode = langCodeField.getText().toString();
		
		// Checking are all fields set
		if (fileName != null && !apiKey.equals("") && !langCode.equals("")) {
			final ProgressDialog dialog = ProgressDialog.show( SampleActivity.this, "Loading ...", "Converting to text.", true, false);
			final Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					final OCRServiceAPI apiClient = new OCRServiceAPI(apiKey);
					apiClient.convertToText(langCode, fileName);
					
					// Doing UI related code in UI thread
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							dialog.dismiss();
							
							// Showing response dialog
							final AlertDialog.Builder alert = new AlertDialog.Builder(SampleActivity.this);
							String temp = apiClient.getResponseText();
							temp = temp.toLowerCase();
						
							for(int i =0; i<temp.length();i++){
								char x = temp.charAt(i);
								SharedPreferences prefs = getSharedPreferences(x + "", 0);//getPreferences(0); 
								String var = prefs.getString(x+"", "DEFAULT");
								switch (x){
								case 'a': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'b': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'c': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'd': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'e': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'f': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'g': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'h': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'i': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'j': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'k': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'l': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'm': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'n': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'o': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'p': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'q': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'r': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 's': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 't': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'u': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'v': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'w': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'x': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'y': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								case 'z': temp = temp.substring(0,i) + var + temp.substring(i+1);
								break;
								}
									
							}
							alert.setMessage(temp);
							alert.setPositiveButton(
								"OK",
								new DialogInterface.OnClickListener() {
									public void onClick( DialogInterface dialog, int id) {
									}
								});
							
							// Setting dialog title related from response code
							if (apiClient.getResponseCode() == RESPONSE_OK) {
								alert.setTitle("Success");
							} else {
								alert.setTitle("Failed");
							}
							
							alert.show();
						}
					});
				}
			});
			thread.start();
		} else {
			Toast.makeText(SampleActivity.this, "All data are required.", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == IMAGE_PICKER_REQUEST && resultCode == RESULT_OK) {
			fileName = getRealPathFromURI(data.getData());
			picNameText.setText("Selected: en" + getStringNameFromRealPath(fileName));
		}
	}

	/*
	 * Returns image real path.
	 */
	private String getRealPathFromURI(final Uri contentUri) {
		final String[] proj = { MediaStore.Images.Media.DATA };
		final Cursor cursor = managedQuery(contentUri, proj, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		
		return cursor.getString(column_index);
	}

	/*
	 * Cuts selected file name from real path to show in screen.
	 */
	private String getStringNameFromRealPath(final String bucketName) {
		return bucketName.lastIndexOf('/') > 0 ? bucketName.substring(bucketName.lastIndexOf('/') + 1) : bucketName;
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
	 @Override
	 public void onBackPressed() {
		 
		 
	 }
	 
	    
}