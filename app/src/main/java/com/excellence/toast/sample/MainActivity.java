package com.excellence.toast.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.excellence.toast.InfoNoticeSystemToast;
import com.excellence.toast.InfoNoticeToast;
import com.excellence.toast.SystemToast;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.text).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// InfoNoticeToast.getInstance(MainActivity.this).showMsg("hello");
				InfoNoticeSystemToast.getInstance(MainActivity.this).showMsg("hello");
				// SystemToast.makeText(MainActivity.this, "Toast", SystemToast.TOAST_SHORT).show();
			}
		});
	}
}
