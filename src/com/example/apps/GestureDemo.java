package com.example.apps;

import com.example.classes.SwipeDetector;
import com.example.interfaces.SwipeInterface;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GestureDemo extends ApplicationActivity implements SwipeInterface {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture_demo);
		//gesture instancess
		SwipeDetector swipe = new SwipeDetector(this);
		RelativeLayout swipe_layout = (RelativeLayout) findViewById(R.id.gesture_control);
		swipe_layout.setOnTouchListener(swipe);
	}

	@Override
	public void bottom2top(View v) {

		
	}

	@Override
	public void left2right(View v) {

		
	}

	@Override
	public void right2left(View v) {

		
	}

	@Override
	public void top2bottom(View v) {

		
	}

	

}
