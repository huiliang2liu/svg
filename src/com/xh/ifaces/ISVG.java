package com.xh.ifaces;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * @version ����ʱ�䣺2018-1-9 ����4:17:43 ��Ŀ��repair ������com.xh.svg �ļ�����SVG.java ���ߣ�lhl
 *          ˵��:
 */

public interface ISVG {
	/**
	 * 
	 * lhl 2018-1-9 ����4:22:35 ˵��������λͼ
	 * 
	 * @param width
	 * @param heigth
	 * @return Bitmap
	 */
	public Bitmap createBitmap(int width, int heigth);

	/**
	 * 
	 * lhl 2018-1-9 ����4:23:04 ˵��������λͼ
	 * 
	 * @param view
	 * @return Bitmap
	 */
	public Bitmap createBitmap(View view);

	/**
	 * 
	 * lhl 2018-1-9 ����4:23:32 ˵��������λͼ
	 * 
	 * @param factor
	 * @return Bitmap
	 */
	public Bitmap createBitmap(float factor);

	/**
	 * 
	 * lhl 2018-1-9 ����4:23:15 ˵��������λͼ
	 * 
	 * @return Bitmap
	 */
	public Bitmap createBitmap();

	/**
	 * 
	 * lhl 2018-1-9 ����4:23:43 ˵��������drawable
	 * 
	 * @param width
	 * @param heigth
	 * @return Drawable
	 */
	public Drawable createDrawable(int width, int heigth);

	/**
	 * 
	 * lhl 2018-1-9 ����4:24:14 ˵��������drawable
	 * 
	 * @param view
	 * @return Drawable
	 */
	public Drawable createDrawable(View view);

	/**
	 * 
	 * lhl 2018-1-9 ����4:24:29 ˵��������drawable
	 * 
	 * @param factor
	 * @return Drawable
	 */
	public Drawable createDrawable(float factor);

	/**
	 * 
	 * lhl 2018-1-9 ����4:24:02 ˵��������drawable
	 * 
	 * @return Drawable
	 */
	public Drawable createDrawable();

	/**
	 * 
	 * lhl 2018-1-9 ����4:25:31 ˵��������·��
	 * 
	 * @param width
	 * @param heigth
	 * @return Path
	 */
	public Path createPath(int width, int heigth);

	/**
	 * 
	 * lhl 2018-1-9 ����4:26:05 ˵����������·��
	 * 
	 * @param view
	 * @return Path
	 */
	public Path createPath(View view);

	/**
	 * 
	 * lhl 2018-1-9 ����4:26:14 ˵����������·��
	 * 
	 * @param factor
	 * @return Path
	 */
	public Path createPath(float factor);

	/**
	 * 
	 * lhl 2018-1-9 ����4:25:56 ˵����������·��
	 * 
	 * @return Path
	 */
	public Path createPath();

	/**
	 * 
	 * lhl 2018-1-9 ����4:26:38 ˵������ȡ��ɫ
	 * 
	 * @return int
	 */
	public int color();

	/**
	 * 
	 * lhl 2018-1-9 ����4:21:18 ˵������ȡͼƬ���
	 * 
	 * @return int
	 */
	public int getWidth();

	/**
	 * 
	 * lhl 2018-1-9 ����4:20:53 ˵������ȡͼƬ�߶�
	 * 
	 * @return int
	 */
	public int getHeigth();

	/**
	 * 
	 * lhl 2018-1-9 ����4:20:30 ˵������ȡ�����߶�
	 * 
	 * @return int
	 */
	public int getViewBoxWidth();

	/**
	 * 
	 * lhl 2018-1-9 ����4:19:56 ˵������ȡ�����߶�
	 * 
	 * @return int
	 */
	public int getViewBoxHeigth();

	/**
	 * 
	 * lhl 2018-1-9 ����4:19:37 ˵������ȡ�������ƫ����
	 * 
	 * @return float
	 */
	public float getX();

	/**
	 * 
	 * lhl 2018-1-9 ����4:18:42 ˵������ȡ������ı�����
	 * 
	 * @return float
	 */
	public float getY();
}
