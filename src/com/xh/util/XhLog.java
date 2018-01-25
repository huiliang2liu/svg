package com.xh.util;

import android.util.Log;

/**
 * @version ����ʱ�䣺2017-11-14 ����3:52:48 ��Ŀ��TvBlackAD-eclipse
 *          ������com.tvblack.tv.utils �ļ�����TVBLog.java ���ߣ�lhl ˵��:��־������
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
	 * lhl 2017-11-14 ����3:57:32 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����4:52:36 ˵������ɫ��־
	 * 
	 * @param msg
	 *            void
	 */
	public static void d(String msg) {
		d(null, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 ����4:52:44 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����4:56:28 ˵������ɫ��־
	 * 
	 * @param msg
	 *            void
	 */
	public static void e(String msg) {
		e(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 ����4:56:42 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����4:56:47 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����4:59:16 ˵������ɫ��־
	 * 
	 * @param msg
	 *            void
	 */
	public static void i(String msg) {
		i(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 ����4:59:33 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����4:59:39 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����5:02:02 ˵������ɫ��־
	 * 
	 * @param msg
	 *            void
	 */
	public static void v(String msg) {
		v(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 ����5:02:13 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����5:02:19 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����5:04:14 ˵������ɫ��־
	 * 
	 * @param msg
	 *            void
	 */
	public static void w(String msg) {
		w(TAG, msg);
	}

	/**
	 * 
	 * lhl 2017-11-14 ����5:04:25 ˵������ɫ��־
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
	 * lhl 2017-11-14 ����5:04:30 ˵������ɫ��־
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
