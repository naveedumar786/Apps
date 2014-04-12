package com.example.helper;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

public class Helper {
	static SharedPreferences sp;
	static final boolean IS_DEVELOPMENT_MODE = true;

	// read integer preferences
	public static int readPreferences(Activity activity, String key) {
		sp = PreferenceManager.getDefaultSharedPreferences(activity
				.getApplicationContext());

		return sp.getInt(key, -1);
	}

	// read String preferences
	public static String readPreferences(Activity activity, String key,
			String defeaultVal) {
		sp = PreferenceManager.getDefaultSharedPreferences(activity
				.getApplicationContext());

		return sp.getString(key, defeaultVal);
	}

	public static void savePreferences(Activity activity, String key,
			String value) {
		sp = PreferenceManager.getDefaultSharedPreferences(activity
				.getApplicationContext());
		sp.edit().putString(key, value).commit();

	}

	public static void savePreferences(Activity activity, String key, int value) {
		sp = PreferenceManager.getDefaultSharedPreferences(activity
				.getApplicationContext());
		sp.edit().putInt(key, value).commit();
	}

	public static void savePreferences(Activity activity, String key,
			boolean value) {
		sp = PreferenceManager.getDefaultSharedPreferences(activity
				.getApplicationContext());
		sp.edit().putBoolean(key, value).commit();
	}

	public static void log(String logType, String tag, String msg) {
		if (IS_DEVELOPMENT_MODE) {
			if (logType.equalsIgnoreCase("e")) {
				Log.e(tag, msg);
			} else if (logType.equalsIgnoreCase("d")) {
				Log.d(tag, msg);
			} else {
				Log.i(tag, msg);
			}
		}
	}
}
