package com.example.apps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ApplicationActivity {
	Button btnGestures;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activeChildContext = this;
		setContentView(R.layout.activity_main);

		btnGestures = (Button) findViewById(R.id.btnGestures);
		btnGestures.setOnClickListener(this);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}

	@Override
	public void onClick(View view) {

		super.onClick(view);
		switch (view.getId()) {

		case R.id.btnGestures:
			mStartActivity(GestureDemo.class);
			break;
		default:
			break;
		}
	}

	private void mStartActivity(Class mClass) {
		Intent intent = new Intent(this, mClass);
		startActivity(intent);
		finish();
	}
}
