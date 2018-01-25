package com.xh.util;

import android.util.Log;

/**
 * @version 创建时间：2017-11-14 下午3:52:48 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.utils 文件名：TVBLog.java 作者：lhl 说明:日志控制类
 */

public class XhLog {
	private static final boolean IS_DEBUG = true;
	private static String TAG = XhLog.class.getName();

	// private void man() {
	// // TODO Auto-generated method stub
	//
	// }
	/**
	 * 
	 * lhl 2017-11-14 下午3:57:32 说明：蓝色日志
	 * 
	 * @param tag
	 * @param msg
	 *            void
	 */
	public static void d(String tag, String msg) {
		d(tag, msg, null);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:52:36 说明：蓝色日志
	 * 
	 * @param msg
	 *            void
	 */
	public static void d(String msg) {
		d(null, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:52:44 说明：蓝色日志
	 * 
	 * @param tag
	 * @param msg
	 * @param tr
	 *            void
	 */
	public static void d(String tag, String msg, Throwable tr) {
		if (IS_DEBUG && msg != null) {
			if (tag == null)
				tag = TAG;
			if (tr == null) {
				Log.d(tag, msg);
			} else {
				Log.d(tag, msg, tr);
			}
		}
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:56:28 说明：红色日志
	 * 
	 * @param msg
	 *            void
	 */
	public static void e(String msg) {
		e(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:56:42 说明：红色日志
	 * 
	 * @param tag
	 * @param msg
	 *            void
	 */
	public static void e(String tag, String msg) {
		e(tag, msg, null);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:56:47 说明：红色日志
	 * 
	 * @param tag
	 * @param msg
	 * @param tr
	 *            void
	 */
	public static void e(String tag, String msg, Throwable tr) {
		if (IS_DEBUG && msg != null) {
			if (tag == null)
				tag = TAG;
			if (tr == null) {
				Log.e(tag, msg);
			} else {
				Log.e(tag, msg, tr);
			}
		}
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:59:16 说明：绿色日志
	 * 
	 * @param msg
	 *            void
	 */
	public static void i(String msg) {
		i(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:59:33 说明：绿色日志
	 * 
	 * @param tag
	 * @param msg
	 *            void
	 */
	public static void i(String tag, String msg) {
		i(tag, msg, null);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午4:59:39 说明：绿色日志
	 * 
	 * @param tag
	 * @param msg
	 * @param tr
	 *            void
	 */
	public static void i(String tag, String msg, Throwable tr) {
		if (IS_DEBUG && msg != null) {
			if (tag == null)
				tag = TAG;
			if (tr == null) {
				Log.i(tag, msg);
			} else {
				Log.i(tag, msg, tr);
			}
		}
	}

	/**
	 * 
	 * lhl 2017-11-14 下午5:02:02 说明：黑色日志
	 * 
	 * @param msg
	 *            void
	 */
	public static void v(String msg) {
		v(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午5:02:13 说明：黑色日志
	 * 
	 * @param tag
	 * @param msg
	 *            void
	 */
	public static void v(String tag, String msg) {
		v(tag, msg, null);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午5:02:19 说明：黑色日志
	 * 
	 * @param tag
	 * @param msg
	 * @param tr
	 *            void
	 */
	public static void v(String tag, String msg, Throwable tr) {
		if (IS_DEBUG && msg != null) {
			if (tag == null)
				tag = TAG;
			if (tr == null) {
				Log.v(tag, msg);
			} else {
				Log.v(tag, msg, tr);
			}
		}
	}

	/**
	 * 
	 * lhl 2017-11-14 下午5:04:14 说明：橙色日志
	 * 
	 * @param msg
	 *            void
	 */
	public static void w(String msg) {
		w(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午5:04:25 说明：橙色日志
	 * 
	 * @param tag
	 * @param msg
	 *            void
	 */
	public static void w(String tag, String msg) {
		w(tag, msg, null);
	}

	/**
	 * 
	 * lhl 2017-11-14 下午5:04:30 说明：橙色日志
	 * 
	 * @param tag
	 * @param msg
	 * @param tr
	 *            void
	 */
	public static void w(String tag, String msg, Throwable tr) {
		if (IS_DEBUG && msg != null) {
			if (tag == null)
				tag = TAG;
			if (tr == null) {
				Log.w(tag, msg);
			} else {
				Log.w(tag, msg, tr);
			}
		}
	}
}
