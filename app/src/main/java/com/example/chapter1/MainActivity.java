package com.example.chapter1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get widgets
		final Button button = findViewById(R.id.button);
		final ImageView image = findViewById(R.id.image);
		final Switch sw = findViewById(R.id.sw);
		final EditText comment = findViewById(R.id.comment);

		// button listener
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Log.d("button", "clicked");
				Log.d("comment", comment.getText().toString());
				comment.setText("");
				// hide keyboard
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		});

		// switch listener
		sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if (isChecked) {
					image.setVisibility(View.VISIBLE);
					Log.d("switch", "on");
				} else {
					image.setVisibility(View.INVISIBLE);
					Log.d("switch", "off");
				}
			}
		});
	}
}
