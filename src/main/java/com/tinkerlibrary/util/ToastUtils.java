package com.tinkerlibrary.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * 
 */
public class ToastUtils {
	//短时间吐司
	public static void show(Context ctx, String text) {
		Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show();
	}
	//长时间吐司
	public static void showLong(Context ctx, String text) {
		Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
	}
}
