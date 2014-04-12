package com.example.apps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class ApplicationActivity extends FragmentActivity implements
		OnClickListener {

	Context activeChildContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_application);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		default:
			break;
		}
	}

}
