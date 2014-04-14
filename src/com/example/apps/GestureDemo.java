package com.example.apps;

import com.example.apps.PagerFragment.OnFragmentInteractionListener;
import com.example.classes.SwipeDetector;
import com.example.interfaces.SwipeInterface;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

public class GestureDemo extends ApplicationActivity implements SwipeInterface,
		OnFragmentInteractionListener {

	PagerFragment mPagerFragment;
	int pageCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture_demo);
		activeChildContext = this;

		mPagerFragment = new PagerFragment();

		// gesture instancess
		SwipeDetector swipe = new SwipeDetector(this);
		RelativeLayout swipe_layout = (RelativeLayout) findViewById(R.id.rlFragmentContainer);
		swipe_layout.setOnTouchListener(swipe);
		replaceFragment(mPagerFragment);
	}

	@Override
	public void bottom2top(View v) {

	}

	@Override
	public void left2right(View v) {

		--pageCount;
		mPagerFragment = new PagerFragment();
		replaceFragment(mPagerFragment);
	}

	@Override
	public void right2left(View v) {

		if (pageCount == 0) {
			return;
		}

		++pageCount;

		mPagerFragment = new PagerFragment();
		replaceFragment(mPagerFragment);
	}

	@Override
	public void top2bottom(View v) {

	}

	@Override
	public void onFragmentInteraction(Uri uri) {
		// TODO Auto-generated method stub

	}

	/**
	 * @fragment view name
	 * @text used as a flag
	 * 
	 */

	private void replaceFragment(Fragment fragment) {

		String backStateName = fragment.getClass().getName();

		Bundle args = new Bundle();
		args.putInt("pageCount", pageCount);

		fragment.setArguments(args);
		if (mPagerFragment.isVisible()) {

			getSupportFragmentManager()
					.beginTransaction()
					.remove(getSupportFragmentManager().findFragmentByTag(
							backStateName)).commit();
		}

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.rlFragmentContainer, fragment, backStateName);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		ft.addToBackStack(null);
		ft.commit();

	}

	@Override
	public void onBackPressed() {
		if (mPagerFragment != null && mPagerFragment.isVisible()) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
		super.onBackPressed();
	}

}
