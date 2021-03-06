package com.example.apps;

import com.example.helper.Helper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.widget.TextView;

public class Apps extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		TextView tvLoading = (TextView) findViewById(R.id.tvLoading);

		try {
			Typeface typeface = Typeface.createFromAsset(getAssets(),
					"blazed.ttf");
			tvLoading.setTypeface(typeface);

		} catch (Exception e) {

		}
		new MyAsyncTask().execute();
	}

	private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			int userId = Helper.readPreferences(Apps.this, "userId");
			Helper.log("e", getString(R.string.app_name), "userId= " + userId);
			Intent intent;
			userId = 1;
			if (userId == -1) {
				intent = new Intent(Apps.this, LoginActivity.class);
			} else {
				intent = new Intent(Apps.this, MainActivity.class);
			}
			startActivity(intent);
			finish();

		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}

}
