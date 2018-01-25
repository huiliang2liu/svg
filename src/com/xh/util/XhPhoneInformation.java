package com.xh.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * �ֻ���Ϣ�ռ� ���Ȩ�� <uses-permission
 * android:name="android.permission.READ_PHONE_STATE" /> <!-- ��SDCard�д�����ɾ���ļ�Ȩ��
 * --> <uses-permission
 * android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/> <!--
 * ��SDCardд������Ȩ�� --> <uses-permission
 * android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> <uses-permission
 * android:name="android.permission.READ_PHONE_STATE" /> <uses-permission
 * android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 * <uses-permission
 * android:name="android.permission.INTERNET"></uses-permission> <!-- wifiȨ�� -->
 * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 * <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" /> <!--
 * ��ѯ����״̬Ȩ�� --> <uses-permission
 * android:name="android.permission.ACCESS_NETWORK_STATE" />
 */
public class XhPhoneInformation {
	/**
	 * �ֻ���Ļ�߶�
	 */
	public static int height = 0;
	/**
	 * �ֻ���Ļ���
	 */
	public static int width = 0;
	/**
	 * �ֻ�����ϵ�����
	 */
	public static int widthPixels = 0;
	/**
	 * �ֻ��߶��ϵ�����
	 */
	public static int heightPixels = 0;
	/**
	 * �ֻ�IMEI �豸ID
	 */
	public static String IMEI = "";
	/**
	 * �ֻ� IESI ������ID
	 */
	public static String IESI = "";
	/**
	 * �ֻ��ͺ� MODEL
	 */
	public static String MODEL = "";
	/**
	 * �ֻ����� �е����õ����еĲ����ԣ����Ҫ���������Ƿ�ע����
	 */
	public static String numer = "";
	/**
	 * sdk�汾
	 */
	public static String sdk = "";
	/**
	 * ϵͳ�汾��
	 */
	public static String VERSION_RELEASE = "";
	/**
	 * The name of the underlying board, like "goldfish".
	 */
	public static String BOARD = "";
	/**
	 * The system bootloader version number.
	 */
	public static String BOOTLOADER = "";
	/**
	 * The brand (e.g., carrier) the software is customized for, if any.
	 */
	public static String BRAND = "";
	/**
	 * The name of the instruction set (CPU type + ABI convention) of native
	 * code.
	 */
	public static String CPU_ABI = "";
	/**
	 * The name of the second instruction set (CPU type + ABI convention) of
	 * native code.
	 */
	public static String CPU_ABI2 = "";
	/**
	 * The name of the industrial design.
	 */
	public static String DEVICE = "";
	/**
	 * A build ID string meant for displaying to the user
	 */
	public static String DISPLAY = "";
	/**
	 * A string that uniquely identifies this build.
	 */
	public static String FINGERPRINT = "";

	/**
	 * The name of the hardware (from the kernel command line or /proc).
	 */
	public static String HARDWARE = "";
	public static String HOST = "";
	/**
	 * Either a changelist number, or a label like "M4-rc20".
	 */
	public static String ID = "";
	/**
	 * The manufacturer of the product/hardware.
	 */
	public static String MANUFACTURER = "";
	/**
	 * The name of the overall product.
	 */
	public static String PRODUCT = "";
	/**
	 * The radio firmware version number.
	 */
	public static String RADIO = "";
	/**
	 * A hardware serial number, if available.
	 */
	public static String SERIAL = "";
	/**
	 * Comma-separated tags describing the build, like "unsigned,debug".
	 */
	public static String TAGS = "";
	public static long TIME = 0l;
	/**
	 * The type of build, like "user" or "eng".
	 */
	public static String TYPE = "";
	/**
	 * Value used for when a build property is unknow
	 */
	public static String UNKNOWN = "";
	public static String USER = "";
	/**
	 * �ֻ�MAC��ַ
	 */
	public static String MAC = "";
	/**
	 * cpu �ͺ�
	 */
	public static String CPU_MODE = "";
	/**
	 * cpuƵ��
	 */
	public static String CPU_FREQUENCY = "";
	/**
	 * ϵͳ���ڴ� ��λΪkb
	 */
	public static long TOTAL_RAM = 0l;
	/**
	 * ϵͳʣ���ڴ� ��λΪkb
	 */
	public static long AVAIL_RAM = 0l;
	/**
	 * SDCARD���ڴ� ��λΪkb
	 */
	public static long TOTAL_SDCARD = 0l;
	/**
	 * SDCARDʣ���ڴ浥λΪkb
	 */
	public static long AVAIL_SDCARD = 0l;

	/**
	 * ���ڴ�
	 */
	public static long TOTAL_MEMORY = 0l;

	/**
	 * ��ʣ���ڴ�
	 */
	public static long TOTAL_REMAIN_MEMORY = 0l;
	/**
	 * �����ܶ�
	 */
	public float density;
	/**
	 * �ܶ�dpi
	 */
	public float densityDpi;

	public float scaledDensity;

	public static XhPhoneInformation xhPhoneInformation;
	private final static String TAG = XhPhoneInformation.class.getName();

	/**
	 * ���췽��˽�л������贴�����
	 */
	private XhPhoneInformation(Activity activity) {
		// TODO Auto-generated constructor stub
		getPhonWidthAndHeigth(activity);
		getPixel(activity);
		getInfo(activity);
		getPhoneInformation();
		getMacAddress(activity);
		getCpuInfo();
		getTotalMemory(activity);
		getSDCARD();
		getRAM();
	}

	/**
	 * app��ʼ��ʱ�����
	 * 
	 * @param activity
	 */
	public static XhPhoneInformation initialize(Activity activity) {
		if (xhPhoneInformation != null)
			return xhPhoneInformation;
		synchronized (TAG) {
			if (xhPhoneInformation != null)
				return xhPhoneInformation;
			xhPhoneInformation = new XhPhoneInformation(activity);
		}
		return xhPhoneInformation;
	}

	/**
	 * ��ȡ���ڴ�
	 */
	public void getRAM() {
		// TODO Auto-generated method stub
		File path2 = Environment.getDataDirectory();
		StatFs stat2 = new StatFs(path2.getPath());
		@SuppressWarnings("deprecation")
		long blockSize2 = stat2.getBlockSize();
		@SuppressWarnings("deprecation")
		long totalBlocks2 = stat2.getBlockCount();
		@SuppressWarnings("deprecation")
		long availableBlocks2 = stat2.getAvailableBlocks();

		long totalSize2 = totalBlocks2 * blockSize2;
		long availSize2 = availableBlocks2 * blockSize2;

		TOTAL_MEMORY = totalSize2;
		TOTAL_REMAIN_MEMORY = availSize2;
	}

	/**
	 * ��sdc�ڴ�
	 */
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	public void getSDCARD() {
		// �õ��ļ�ϵͳ����Ϣ���洢���С���ܵĴ洢�����������ô洢������
		// ��ȡsd���ռ�
		// �洢�豸�ᱻ��Ϊ���ɸ�����
		// ÿ������Ĵ�С * �������� = �洢�豸���ܴ�С
		// ÿ������Ĵ�С * ������������� = �洢�豸���ô�С
		File path = Environment.getExternalStorageDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize;
		long totalBlocks;
		long availableBlocks;
		// ����API18��Android4.3���Ժ�getBlockSize��ʱ���Ҹ�Ϊ��getBlockSizeLong
		// ���������Ҫ���ݰ汾����ʹ����һ��API
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			blockSize = stat.getBlockSizeLong();
			totalBlocks = stat.getBlockCountLong();
			availableBlocks = stat.getAvailableBlocksLong();
		} else {
			blockSize = stat.getBlockSize();
			totalBlocks = stat.getBlockCount();
			availableBlocks = stat.getAvailableBlocks();
		}
		/**
		 * �ڴ��ܴ�С
		 * 
		 */
		TOTAL_SDCARD = blockSize * totalBlocks;
		/**
		 * �ڴ���ô�С
		 */
		AVAIL_SDCARD = blockSize * availableBlocks;
	}

	/**
	 * ��ȡϵͳ�ڴ�
	 */
	public void getTotalMemory(Activity activity) {
		ActivityManager mActivityManager = (ActivityManager) activity
				.getSystemService(Context.ACTIVITY_SERVICE);
		ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
		mActivityManager.getMemoryInfo(mi);
		long mTotalMem = 0;
		long mAvailMem = mi.availMem;
		String str1 = "/proc/meminfo";
		String str2;
		String[] arrayOfString;
		try {
			FileReader localFileReader = new FileReader(str1);
			BufferedReader localBufferedReader = new BufferedReader(
					localFileReader, 8192);
			str2 = localBufferedReader.readLine();
			arrayOfString = str2.split("\\s+");
			mTotalMem = Integer.valueOf(arrayOfString[1]).intValue() * 1024;
			localBufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TOTAL_RAM = mTotalMem;
		AVAIL_RAM = mAvailMem;
	}

	/**
	 * �ֻ�CPU��Ϣ
	 */
	private void getCpuInfo() {
		String str1 = "/proc/cpuinfo";
		String str2 = "";
		String[] arrayOfString;
		try {
			FileReader fr = new FileReader(str1);
			BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
			str2 = localBufferedReader.readLine();
			arrayOfString = str2.split("\\s+");
			for (int i = 2; i < arrayOfString.length; i++) {
				CPU_MODE = CPU_MODE + arrayOfString[i] + " ";
			}
			str2 = localBufferedReader.readLine();
			arrayOfString = str2.split("\\s+");
			CPU_FREQUENCY += arrayOfString[2];
			localBufferedReader.close();
		} catch (IOException e) {
		}
	}

	/**
	 * ��ȡ�ֻ�MAC��ַ
	 */
	public void getMacAddress(Context activity) {
		WifiManager wifiManager = (WifiManager) activity
				.getSystemService(Context.WIFI_SERVICE);
		if (wifiManager == null)
			return;
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		if (wifiInfo == null)
			return;
		MAC = wifiInfo.getMacAddress();
	}

	/**
	 * ��ȡ�ֻ��豸��Ϣ
	 */
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	private void getPhoneInformation() {
		MODEL = Build.MODEL; // �ֻ��ͺ�
		sdk = android.os.Build.VERSION.SDK;
		VERSION_RELEASE = Build.VERSION.RELEASE;
		BOARD = Build.BOARD;
		BOOTLOADER = Build.BOOTLOADER;
		BRAND = Build.BRAND;
		CPU_ABI = Build.CPU_ABI;
		CPU_ABI2 = Build.CPU_ABI2;
		DEVICE = Build.DEVICE;
		DISPLAY = Build.DISPLAY;
		FINGERPRINT = Build.FINGERPRINT;
		HARDWARE = Build.HARDWARE;
		HOST = Build.HOST;
		ID = Build.ID;
		MANUFACTURER = Build.MANUFACTURER;
		PRODUCT = Build.PRODUCT;
		RADIO = Build.RADIO;
		SERIAL = Build.SERIAL;
		TAGS = Build.TAGS;
		TIME = Build.TIME;
		TYPE = Build.TYPE;
		UNKNOWN = Build.UNKNOWN;
		USER = Build.USER;
	}

	/**
	 * ��ȡ�ֻ���Ⱥ͸߶�
	 * 
	 * @param activity
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private void getPhonWidthAndHeigth(Activity activity) {
		Display display = activity.getWindowManager().getDefaultDisplay();
		height = display.getHeight();
		width = display.getWidth();
	}

	/**
	 * ��ȡ�ֻ�����
	 * 
	 * @param activity
	 * @return
	 */
	private void getPixel(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		widthPixels = dm.widthPixels;
		heightPixels = dm.heightPixels;
		density = dm.density;
		scaledDensity = dm.scaledDensity;
		densityDpi = dm.densityDpi;
	}

	/**
	 * ��ȡ�ֻ���ʾ
	 * 
	 * @param activity
	 */
	private void getInfo(Activity activity) {
		TelephonyManager mTm = (TelephonyManager) activity
				.getSystemService(Activity.TELEPHONY_SERVICE);
		if (mTm == null)
			return;
		IMEI = mTm.getDeviceId();
		IESI = mTm.getSubscriberId();
		numer = mTm.getLine1Number();
	}

	/**
	 * �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊ px(����) xh 2017-2-15 ����6:02:54
	 * 
	 * @param context
	 * @param dpValue
	 * @return
	 */
	public int dip2px(float dpValue) {
		return (int) (dpValue * density + 0.5f);
	}

	/**
	 * �����ֻ��ķֱ��ʴ� px(����) �ĵ�λ ת��Ϊ dp xh 2017-2-15 ����6:02:59
	 * 
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public int px2dip(float pxValue) {
		return (int) (pxValue / density + 0.5f);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����5:02:11 ˵��������תΪsp
	 * 
	 * @param pxValue
	 * @return int
	 */
	public int px2sp(float pxValue) {
		return (int) (pxValue / scaledDensity + 0.5f);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����5:02:28 ˵���� spתΪ����
	 * 
	 * @param spValue
	 * @return int
	 */
	public int sp2px(float spValue) {
		return (int) (spValue * scaledDensity + 0.5f);
	}
}
