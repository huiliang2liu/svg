package com.xh.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;

/**
 * @version ����ʱ�䣺2017-12-19 ����5:04:12 ��Ŀ��repair ������com.xh.util �ļ�����XHBitmap.java
 *          ���ߣ�lhl ˵��:
 */

public class XhImageUtile {
	{
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(Color.RED);// ���û�����ɫ
		paint.setARGB(0xff, 0xff, 0xff, 0xff);// ���û���argbֵ
		paint.setAlpha(0x00);// ���û���alphaֵ
		paint.setTextSize(1);// ���û��������С
		paint.setStyle(Style.FILL);// ���û��ʷ��
		paint.setStrokeWidth(2.0f);// ���ÿ��ı߿�Ŀ��
	}

	/**
	 * 
	 * lhl 2017-12-19 ����5:16:13 ˵�������ľ���
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap rectStroke(int width, int height, int color,
			float strokeWidth) {
		return rect(width, height, color, Style.STROKE, strokeWidth);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����5:50:35 ˵����ʵ�ľ���
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap rectFill(int width, int height, int color) {
		return rect(width, height, color, Style.FILL, 1.0f);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:03:45 ˵��������
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap rect(int width, int height, int color, Style style,
			float strokeWidth) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, height,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		canvas.drawRect(strokeWidth, strokeWidth, width - strokeWidth, height
				- strokeWidth, paint);
		return bitmapWithReflection;
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:06:28 ˵����ʵ��Բ�Ǿ���
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param rx
	 * @param ry
	 * @return Bitmap
	 */
	public static Bitmap roundRectFill(int width, int height, int color,
			float rx, float ry) {
		return roundRect(width, height, color, rx, ry, Style.FILL, 1.0f);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:05:25 ˵��������Բ�Ǿ���
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param rx
	 * @param ry
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap roundRectStroke(int width, int height, int color,
			float rx, float ry, float strokeWidth) {
		return roundRect(width, height, color, rx, ry, Style.STROKE,
				strokeWidth);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:04:17 ˵����Բ�Ǿ���
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param rx
	 * @param ry
	 * @param style
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap roundRect(int width, int height, int color, float rx,
			float ry, Style style, float strokeWidth) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, height,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		RectF rect = new RectF(strokeWidth, strokeWidth, width - strokeWidth,
				height - strokeWidth);
		canvas.drawRoundRect(rect, rx, ry, paint);
		return bitmapWithReflection;
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:18:56 ˵����ʵ��Բ��
	 * 
	 * @param radius
	 * @param color
	 * @return Bitmap
	 */
	public static Bitmap circleFill(int radius, int color) {
		return circle(radius, color, Style.FILL, 1.0f);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:18:47 ˵��������Բ��
	 * 
	 * @param radius
	 * @param color
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap circleStroke(int radius, int color, float strokeWidth) {
		return circle(radius, color, Style.STROKE, strokeWidth);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:18:30 ˵����Բ��
	 * 
	 * @param radius
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap circle(int radius, int color, Style style,
			float strokeWidth) {
		int width = radius << 1;
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, width,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		canvas.drawCircle(radius, radius, radius - strokeWidth, paint);
		return bitmapWithReflection;
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:40:03 ˵����ʵ������
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arcFillUserCenter(int width, int height, int color,
			float startAngle, float sweepAngle) {
		return arcFill(width, height, color, true, startAngle, sweepAngle);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:40:42 ˵��������Բ��
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param strokeWidth
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arcStroke(int width, int height, int color,
			float strokeWidth, float startAngle, float sweepAngle) {
		return arcStroke(width, height, color, strokeWidth, false, startAngle,
				sweepAngle);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:40:03 ˵����ʵ��Բ��
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arcFill(int width, int height, int color,
			float startAngle, float sweepAngle) {
		return arcFill(width, height, color, false, startAngle, sweepAngle);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:40:42 ˵������������
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param strokeWidth
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arcStrokeUseCenter(int width, int height, int color,
			float strokeWidth, float startAngle, float sweepAngle) {
		return arcStroke(width, height, color, strokeWidth, true, startAngle,
				sweepAngle);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:41:00 ˵����Բ����������
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arcUseCenter(int width, int height, int color,
			Style style, float strokeWidth, float startAngle, float sweepAngle) {
		return arc(width, height, color, style, strokeWidth, true, startAngle,
				sweepAngle);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:41:23 ˵����ʵ�ĵ�Բ��������
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param useCenter
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arcFill(int width, int height, int color,
			boolean useCenter, float startAngle, float sweepAngle) {
		return arc(width, height, color, Style.FILL, 1.0f, useCenter,
				startAngle, sweepAngle);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:41:52 ˵�������ĵ�Բ��������
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param strokeWidth
	 * @param useCenter
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arcStroke(int width, int height, int color,
			float strokeWidth, boolean useCenter, float startAngle,
			float sweepAngle) {
		return arc(width, height, color, Style.STROKE, strokeWidth, useCenter,
				startAngle, sweepAngle);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:43:08 ˵����Բ��������
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @param useCenter
	 * @param startAngle
	 * @param sweepAngle
	 * @return Bitmap
	 */
	public static Bitmap arc(int width, int height, int color, Style style,
			float strokeWidth, boolean useCenter, float startAngle,
			float sweepAngle) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, height,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		RectF oval = new RectF(strokeWidth, strokeWidth, width - strokeWidth,
				height - strokeWidth);
		canvas.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
		return bitmapWithReflection;
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:45:40 ˵����ʵ����Բ
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @return Bitmap
	 */
	public static Bitmap ovalFill(int width, int height, int color) {
		return oval(width, height, color, Style.FILL, 1.0f);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:45:50 ˵����������Բ
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap ovalStroke(int width, int height, int color,
			float strokeWidth) {
		return oval(width, height, color, Style.STROKE, strokeWidth);
	}

	/**
	 * 
	 * lhl 2017-12-19 ����6:45:59 ˵������Բ
	 * 
	 * @param width
	 * @param height
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap oval(int width, int height, int color, Style style,
			float strokeWidth) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, height,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		RectF oval = new RectF(strokeWidth, strokeWidth, width - strokeWidth,
				height - strokeWidth);
		canvas.drawOval(oval, paint);
		return bitmapWithReflection;
	}

	public static Bitmap text(int width, int height, int color, float textSize,
			float strokeWidth, String text) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, height,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(Style.FILL);// ���û��ʷ��
		paint.setTextSize(textSize);
		paint.setStrokeWidth(strokeWidth);
		canvas.drawText(text, 0, height * 0.5f - textSize * .5f, paint);
		return bitmapWithReflection;
	}

	public static Bitmap text(int width, int height, int color, float textSize,
			float strokeWidth, String text, float[] pos) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, height,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(Style.FILL);// ���û��ʷ��
		paint.setTextSize(textSize);
		paint.setStrokeWidth(strokeWidth);
		canvas.drawPosText(text, pos, paint);
		return bitmapWithReflection;
	}

	/**
	 * 
	 * lhl 2017-12-20 ����10:10:37 ˵����ʵ�Ķ����
	 * 
	 * @param width
	 * @param color
	 * @param polygons
	 * @return Bitmap
	 */
	public static Bitmap polygonFill(int width, int color, int polygons) {
		return polygon(width, color, Style.FILL, 1.0f, polygons);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����10:09:45 ˵�������Ķ����
	 * 
	 * @param width
	 * @param color
	 * @param strokeWidth
	 * @param polygons
	 * @return Bitmap
	 */
	public static Bitmap polygonStroke(int width, int color, float strokeWidth,
			int polygons) {
		return polygon(width, color, Style.STROKE, strokeWidth, polygons);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����10:08:41 ˵���������
	 * 
	 * @param width
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @param polygons
	 * @return Bitmap
	 */
	public static Bitmap polygon(int width, int color, Style style,
			float strokeWidth, int polygons) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, width,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		float cX = width * .5f;
		float length = cX - strokeWidth;
		Path path = new Path();
		canvas.translate(strokeWidth, strokeWidth);
		path.moveTo(length, 0);
		for (int i = 1; i < polygons; i++) {
			float[] xy = new float[2];
			double angle = i * 360 / polygons + 90;
			if (angle < 180) {
				angle = Math.toRadians(180 - angle);
				xy[0] = (float) (length + length * Math.cos(angle));
				xy[1] = (float) (length - length * Math.sin(angle));
			} else if (angle < 270) {
				angle = Math.toRadians(angle - 180);
				xy[0] = (float) (length + length * Math.cos(angle));
				xy[1] = (float) (length + length * Math.sin(angle));
			} else if (angle < 360) {
				angle = Math.toRadians(360 - angle);
				xy[1] = (float) (length + length * Math.sin(angle));
				xy[0] = (float) (length - length * Math.cos(angle));
			} else {
				angle = Math.toRadians(angle - 360);
				xy[1] = (float) (length - length * Math.sin(angle));
				xy[0] = (float) (length - length * Math.cos(angle));
			}
			path.lineTo(xy[0], xy[1]);
		}
		path.close();
		canvas.drawPath(path, paint);
		return bitmapWithReflection;
	}

	/**
	 * 
	 * lhl 2017-12-20 ����10:38:54 ˵����ʵ������
	 * 
	 * @param width
	 * @param color
	 * @return Bitmap
	 */
	public static Bitmap heartFill(int width, int color) {
		return heart(width, color, Style.FILL, .1f);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����10:39:05 ˵������������
	 * 
	 * @param width
	 * @param color
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap heartStroke(int width, int color, float strokeWidth) {
		return heart(width, color, Style.STROKE, strokeWidth);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����10:22:06 ˵��������
	 * 
	 * @param width
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap heart(int width, int color, Style style,
			float strokeWidth) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, width,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		float cX = width * .5f;
		float length = cX - strokeWidth;
		Path path = new Path();
		canvas.translate(strokeWidth, strokeWidth);
		float rate = length / 17;
		// ·������ʼ��
		path.moveTo(length, length - 5 * rate);
		// �������κ�����ͼ
		for (double i = 0; i <= 2 * Math.PI; i += 0.001) {
			float x = (float) (16 * Math.sin(i) * Math.sin(i) * Math.sin(i));
			float y = (float) (13 * Math.cos(i) - 5 * Math.cos(2 * i) - 2
					* Math.cos(3 * i) - Math.cos(4 * i));
			x *= rate;
			y *= rate;
			x = length - x;
			y = length - y;
			path.lineTo(x, y);
		}
		path.close();
		paint.setAntiAlias(true);
		canvas.drawPath(path, paint);
		return bitmapWithReflection;
	}

	/**
	 * 
	 * lhl 2017-12-20 ����11:08:29 ˵����ʵ�ĵ�����
	 * 
	 * @param width
	 * @param color
	 * @return Bitmap
	 */
	public static Bitmap starFill(int width, int color) {
		return star(width, color, Style.FILL, .1f);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����11:08:44 ˵�������ĵ�����
	 * 
	 * @param width
	 * @param color
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap starStroke(int width, int color, float strokeWidth) {
		return star(width, color, Style.STROKE, strokeWidth);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����11:08:54 ˵��������
	 * 
	 * @param width
	 * @param color
	 * @param style
	 * @param strokeWidth
	 * @return Bitmap
	 */
	public static Bitmap star(int width, int color, Style style,
			float strokeWidth) {
		Bitmap bitmapWithReflection = Bitmap.createBitmap(width, width,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmapWithReflection);
		Paint paint = new Paint();
		paint.setAntiAlias(true);// ���û��ʾ��Ч��
		paint.setColor(color);
		paint.setStyle(style);// ���û��ʷ��
		paint.setStrokeWidth(strokeWidth);
		Path path = new Path();
		double lw = width * .5f - strokeWidth;
		canvas.translate(strokeWidth, strokeWidth);
		path.moveTo((float) lw, 0);
		double length;
		for (int i = 1; i < 10; i++) {
			float[] xy = new float[2];
			double angle = i * 36 + 90;
			if (i % 2 == 0)
				length = lw;
			else
				length = lw * 0.618f;
			if (angle < 180) {
				angle = Math.toRadians(180 - angle);
				xy[0] = (float) (lw + length * Math.cos(angle));
				xy[1] = (float) (lw - length * Math.sin(angle));
			} else if (angle < 270) {
				angle = Math.toRadians(angle - 180);
				xy[0] = (float) (lw + length * Math.cos(angle));
				xy[1] = (float) (lw + length * Math.sin(angle));
			} else if (angle < 360) {
				angle = Math.toRadians(360 - angle);
				xy[1] = (float) (lw + length * Math.sin(angle));
				xy[0] = (float) (lw - length * Math.cos(angle));
			} else {
				angle = Math.toRadians(angle - 360);
				xy[1] = (float) (lw - length * Math.sin(angle));
				xy[0] = (float) (lw - length * Math.cos(angle));
			}
			path.lineTo(xy[0], xy[1]);
		}
		path.close();
		canvas.drawPath(path, paint);
		return bitmapWithReflection;
	}

	/**
	 * ��ô���Ӱ��ͼƬ����
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap reflection_with_origin(Bitmap bitmap) {
		final int reflectionGap = 4;
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		Matrix matrix = new Matrix();
		matrix.preScale(1, -1);

		Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, height / 2,
				width, height / 2, matrix, false);

		Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
				(height + height / 2), Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmapWithReflection);
		canvas.drawBitmap(bitmap, 0, 0, null);
		// Paint deafalutPaint = new Paint();
		// canvas.drawRect(0, height, width, height + reflectionGap,
		// deafalutPaint);

		canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

		Paint paint = new Paint();
		LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,
				bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,
				0x00ffffff, TileMode.CLAMP);
		paint.setShader(shader);
		// Set the Transfer mode to be porter duff and destination in
		paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
		// Draw a rectangle using the paint with our linear gradient
		canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
				+ reflectionGap, paint);

		return bitmapWithReflection;
	}

	/**
	 * ���ɴ���
	 * 
	 * @param bmp
	 * @return
	 */
	public static Bitmap nostalgia(Bitmap bmp) {
		/*
		 * ���ɴ����㷨�������µ�RGB R=0.393r+0.769g+0.189b G=0.349r+0.686g+0.168b
		 * B=0.272r+0.534g+0.131b
		 */
		float[] fs = { 0.393f, 0.769f, 0.189f, 0, 0, 0.349f, 0.686f, 0.168f, 0,
				0, 0.272f, 0.534f, 0.131f, 0, 0, 0, 0, 0, 1, 0 };
		return fs(bmp, fs);
	}

	/**
	 * ������
	 * 
	 * @param bmp
	 * @return
	 */
	public static Bitmap relief(Bitmap bmp) {
		/*
		 * �㷨ԭ��(ǰһ�����ص�RGB-��ǰ���ص�RGB+127)��Ϊ��ǰ���ص�RGBֵ ��ABC�м���B�㸡��Ч��(RGBֵ��0~255)
		 * B.r = C.r - B.r + 127 B.g = C.g - B.g + 127 B.b = C.b - B.b + 127
		 */
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		int pixColor = 0;
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int newR = 0;
		int newG = 0;
		int newB = 0;
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 1; i < height - 1; i++) {
			for (int k = 1; k < width - 1; k++) {
				// ��ȡǰһ��������ɫ
				pixColor = pixels[width * i + k];
				pixR = Color.red(pixColor);
				pixG = Color.green(pixColor);
				pixB = Color.blue(pixColor);
				// ��ȡ��ǰ����
				pixColor = pixels[(width * i + k) + 1];
				newR = Color.red(pixColor) - pixR + 127;
				newG = Color.green(pixColor) - pixG + 127;
				newB = Color.blue(pixColor) - pixB + 127;
				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));
				pixels[width * i + k] = Color.argb(255, newR, newG, newB);
			}
		}
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	/**
	 * ģ������
	 * 
	 * @param bmp
	 * @return
	 */
	public static Bitmap fuzzy(Bitmap bmp) {
		/*
		 * �㷨ԭ�� ���㷨��������Χ�˸�����������Ÿ���RGBֵ�ֱ���Ӻ�ƽ��,��ǰ���ص��RGBֵ �����㷨���ø�˹ģ�� ��˹����
		 * int[] gauss = new int[] { 1, 2, 1, 2, 4, 2, 1, 2, 1 };
		 * ���Ÿ����RGBֵ�ֱ����˹�����еĶ�Ӧ����˵ĺ�,�ٳ���һ����Ӧ��ֵ��Ϊ��ǰ���ص��RGB
		 */
		int[] gauss = new int[] { 1, 2, 1, 2, 4, 2, 1, 2, 1 }; // ��˹����
		int delta = 16; // ����ֵ ֵԽСͼƬ��Խ��,Խ����Խ��
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		int pixColor = 0;
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int newR, newG, newB;
		int pos = 0; // λ��
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		// ѭ����ֵ
		for (int i = 1; i < height - 1; i++) {
			for (int k = 1; k < width - 1; k++) {
				pos = 0;
				newR = 0;
				newG = 0;
				newB = 0;
				for (int m = -1; m <= 1; m++) // ����
				{
					for (int n = -1; n <= 1; n++) // ���ȱ�
					{
						pixColor = pixels[(i + m) * width + k + n];
						pixR = Color.red(pixColor);
						pixG = Color.green(pixColor);
						pixB = Color.blue(pixColor);
						// 3*3�������
						newR = newR + (int) (pixR * gauss[pos]);
						newG = newG + (int) (pixG * gauss[pos]);
						newB = newB + (int) (pixB * gauss[pos]);
						pos++;
					}
				}
				newR /= delta;
				newG /= delta;
				newB /= delta;
				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));
				pixels[i * width + k] = Color.argb(255, newR, newG, newB);
			}
		}
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	/**
	 * ����Ч��
	 * 
	 * @param bmp
	 * @return
	 */
	public static Bitmap sunshine(Bitmap bmp, int ligth_x, int ligth_y) {
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		int pixColor = 0;
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int newR = 0;
		int newG = 0;
		int newB = 0;
		// Χ��Բ�ι���
		int radius = Math.min(ligth_x, ligth_y);
		float strength = 150F; // ����ǿ��100-150
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 1; i < height - 1; i++) {
			for (int k = 1; k < width - 1; k++) {
				// ��ȡǰһ��������ɫ
				pixColor = pixels[width * i + k];
				pixR = Color.red(pixColor);
				pixG = Color.green(pixColor);
				pixB = Color.blue(pixColor);
				newR = pixR;
				newG = pixG;
				newB = pixB;
				// ���㵱ǰ�㵽�������ĵľ���,ƽ������ϵ������֮��ľ���
				int distance = (int) (Math.pow((ligth_y - i), 2) + Math.pow(
						(ligth_x - k), 2));
				if (distance < radius * radius) {
					// ���վ����С������ǿ�Ĺ���ֵ
					int result = (int) (strength * (1.0 - Math.sqrt(distance)
							/ radius));
					newR = pixR + result;
					newG = newG + result;
					newB = pixB + result;
				}
				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));
				pixels[width * i + k] = Color.argb(255, newR, newG, newB);
			}
		}
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	/**
	 * �񻯴���
	 * 
	 * @param bmp
	 * @return
	 */
	public static Bitmap sharpen(Bitmap bmp) {
		/*
		 * �񻯻���˼���Ǽ�ǿͼ���о���ı�Ե������,ʹͼ�������� ��ͼ��ƽ����ʹͼ���б߽���������ģ��
		 * 
		 * ������˹����ͼ���� ��ȡ��Χ9����ľ������ģ��9���ľ��� ���
		 */
		// ������˹����ģ�� { 0, -1, 0, -1, -5, -1, 0, -1, 0 } { -1, -1, -1, -1, 9, -1,
		// -1, -1, -1 }
		int[] laplacian = new int[] { -1, -1, -1, -1, 9, -1, -1, -1, -1 };
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int pixColor = 0;
		int newR = 0;
		int newG = 0;
		int newB = 0;
		int idx = 0;
		float alpha = 0.3F; // ͼƬ͸����
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		// ͼ����
		for (int i = 1; i < height - 1; i++) {
			for (int k = 1; k < width - 1; k++) {
				idx = 0;
				newR = 0;
				newG = 0;
				newB = 0;
				for (int n = -1; n <= 1; n++) // ȡ��ͼ��3*3��������
				{
					for (int m = -1; m <= 1; m++) // n�������� m�б任
					{
						pixColor = pixels[(i + n) * width + k + m]; // ��ǰ��(i,k)
						pixR = Color.red(pixColor);
						pixG = Color.green(pixColor);
						pixB = Color.blue(pixColor);
						// ͼ���������Ӧ�������
						newR = newR + (int) (pixR * laplacian[idx] * alpha);
						newG = newG + (int) (pixG * laplacian[idx] * alpha);
						newB = newB + (int) (pixB * laplacian[idx] * alpha);
						idx++;
					}
				}
				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));
				// ��ֵ
				pixels[i * width + k] = Color.argb(255, newR, newG, newB);
			}
		}
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	/**
	 * ��������
	 * 
	 * @param bmp
	 * @return
	 */
	public static Bitmap ice(Bitmap bmp) {
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		int pixColor = 0;
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int newColor = 0;
		int newR = 0;
		int newG = 0;
		int newB = 0;
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 0; i < height; i++) {
			for (int k = 0; k < width; k++) {
				// ��ȡǰһ��������ɫ
				pixColor = pixels[width * i + k];
				pixR = Color.red(pixColor);
				pixG = Color.green(pixColor);
				pixB = Color.blue(pixColor);
				// ��ɫ
				newColor = pixR - pixG - pixB;
				newColor = newColor * 3 / 2;
				if (newColor < 0) {
					newColor = -newColor;
				}
				if (newColor > 255) {
					newColor = 255;
				}
				newR = newColor;
				// ��ɫ
				newColor = pixG - pixB - pixR;
				newColor = newColor * 3 / 2;
				if (newColor < 0) {
					newColor = -newColor;
				}
				if (newColor > 255) {
					newColor = 255;
				}
				newG = newColor;
				// ��ɫ
				newColor = pixB - pixG - pixR;
				newColor = newColor * 3 / 2;
				if (newColor < 0) {
					newColor = -newColor;
				}
				if (newColor > 255) {
					newColor = 255;
				}
				newB = newColor;
				pixels[width * i + k] = Color.argb(255, newR, newG, newB);
			}
		}
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	/**
	 * ���账��
	 * 
	 * @param bmp
	 * @return
	 */
	public static Bitmap sketch(Bitmap bmp) {
		// ������Bitmap
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		int[] pixels = new int[width * height]; // �洢�任ͼ��
		int[] linpix = new int[width * height]; // �洢�Ҷ�ͼ��
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		int pixColor = 0;
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		// �Ҷ�ͼ��
		for (int i = 1; i < height - 1; i++)
			// ������˹����ģ�� { 0, -1, 0, -1, -5,
			for (int j = 1; j < width - 1; j++) {
				// -1, 0, -1, 0
				{
					// ��ȡǰһ��������ɫ
					pixColor = pixels[width * i + j];
					pixR = Color.red(pixColor);
					pixG = Color.green(pixColor);
					pixB = Color.blue(pixColor);
					// �Ҷ�ͼ��
					int gray = (int) (0.3 * pixR + 0.59 * pixG + 0.11 * pixB);
					linpix[width * i + j] = Color.argb(255, gray, gray, gray);
					// ͼ����
					gray = 255 - gray;
					pixels[width * i + j] = Color.argb(255, gray, gray, gray);
				}
			}
		int[] copixels = gaussBlur(pixels, width, height, 10, 10 / 3); // ��˹ģ��
																		// ���ð뾶10
		int[] result = colorDodge(linpix, copixels); // ����ͼ�� ��ɫ����
		bitmap.setPixels(result, 0, width, 0, 0, width, height);
		return bitmap;
	}

	// ��˹ģ��
	public static int[] gaussBlur(int[] data, int width, int height,
			int radius, float sigma) {

		float pa = (float) (1 / (Math.sqrt(2 * Math.PI) * sigma));
		float pb = -1.0f / (2 * sigma * sigma);

		// generate the Gauss Matrix
		float[] gaussMatrix = new float[radius * 2 + 1];
		float gaussSum = 0f;
		for (int i = 0, x = -radius; x <= radius; ++x, ++i) {
			float g = (float) (pa * Math.exp(pb * x * x));
			gaussMatrix[i] = g;
			gaussSum += g;
		}

		for (int i = 0, length = gaussMatrix.length; i < length; ++i) {
			gaussMatrix[i] /= gaussSum;
		}

		// x direction
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				float r = 0, g = 0, b = 0;
				gaussSum = 0;
				for (int j = -radius; j <= radius; ++j) {
					int k = x + j;
					if (k >= 0 && k < width) {
						int index = y * width + k;
						int color = data[index];
						int cr = (color & 0x00ff0000) >> 16;
						int cg = (color & 0x0000ff00) >> 8;
						int cb = (color & 0x000000ff);

						r += cr * gaussMatrix[j + radius];
						g += cg * gaussMatrix[j + radius];
						b += cb * gaussMatrix[j + radius];

						gaussSum += gaussMatrix[j + radius];
					}
				}

				int index = y * width + x;
				int cr = (int) (r / gaussSum);
				int cg = (int) (g / gaussSum);
				int cb = (int) (b / gaussSum);

				data[index] = cr << 16 | cg << 8 | cb | 0xff000000;
			}
		}

		// y direction
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				float r = 0, g = 0, b = 0;
				gaussSum = 0;
				for (int j = -radius; j <= radius; ++j) {
					int k = y + j;
					if (k >= 0 && k < height) {
						int index = k * width + x;
						int color = data[index];
						int cr = (color & 0x00ff0000) >> 16;
						int cg = (color & 0x0000ff00) >> 8;
						int cb = (color & 0x000000ff);

						r += cr * gaussMatrix[j + radius];
						g += cg * gaussMatrix[j + radius];
						b += cb * gaussMatrix[j + radius];

						gaussSum += gaussMatrix[j + radius];
					}
				}

				int index = y * width + x;
				int cr = (int) (r / gaussSum);
				int cg = (int) (g / gaussSum);
				int cb = (int) (b / gaussSum);
				data[index] = cr << 16 | cg << 8 | cb | 0xff000000;
			}
		}

		return data;
	}

	// ��ɫ����
	public static int[] colorDodge(int[] baseColor, int[] mixColor) {

		for (int i = 0, length = baseColor.length; i < length; ++i) {
			int bColor = baseColor[i];
			int br = (bColor & 0x00ff0000) >> 16;
			int bg = (bColor & 0x0000ff00) >> 8;
			int bb = (bColor & 0x000000ff);

			int mColor = mixColor[i];
			int mr = (mColor & 0x00ff0000) >> 16;
			int mg = (mColor & 0x0000ff00) >> 8;
			int mb = (mColor & 0x000000ff);

			int nr = colorDodgeFormular(br, mr);
			int ng = colorDodgeFormular(bg, mg);
			int nb = colorDodgeFormular(bb, mb);

			baseColor[i] = nr << 16 | ng << 8 | nb | 0xff000000;
		}
		return baseColor;
	}

	private static int colorDodgeFormular(int base, int mix) {

		int result = base + (base * mix) / (255 - mix);
		result = result > 255 ? 255 : result;
		return result;

	}

	/**
	 * 
	 * lhl 2017-12-20 ����12:38:49 ˵����ȥɫЧ��
	 * 
	 * @param bitmap
	 * @return Bitmap
	 */
	public static Bitmap quse(Bitmap bitmap) {
		float[] fs = { 1.5f, 1.5f, 1.5f, 0, -1, 1.5f, 1.5f, 1.5f, 0, -1, 1.5f,
				1.5f, 1.5f, 0, -1, 0, 0, 0, 1, 0 };
		return fs(bitmap, fs);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����12:41:09 ˵�����߱��Ͷ�
	 * 
	 * @return Bitmap
	 */
	public static Bitmap highDegreeSaturation(Bitmap bitmap) {
		float[] fs = { 1.438f, -.122f, -.016f, 0, -.03f, -.062f, 1.378f,
				-.016f, 0, .05f, -.062f, -.122f, 1.438f, 0, -.02f, 0, 0, 0, 1,
				0 };
		return fs(bitmap, fs);
	}

	/**
	 * 
	 * lhl 2017-12-20 ����12:41:09 ˵������Ƭ
	 * 
	 * @return Bitmap
	 */
	public static Bitmap film(Bitmap bitmap) {
		float[] fs = { -1, 0, 0, 0, 255, 0, -1, 0, 0, 255, 0, 0, -1, 0, 255, 0,
				0, 0, 1, 0 };
		return fs(bitmap, fs);
	}

	// /**
	// *
	// * lhl
	// * 2017-12-20 ����12:41:09
	// * ˵������Ƭ
	// * @return Bitmap
	// */
	// public static Bitmap film1(Bitmap bitmap){
	// int width=bitmap.getWidth();
	// int height=bitmap.getHeight();
	// int len=width*height;
	// int oldPx[]=new int[len];
	// int newPx[]=new int[len];
	// int a;
	// int r;
	// int g;
	// int b;
	// bitmap.getPixels(oldPx, 0, width, 0, 0, width, height);
	// for (int i = 0; i < len; i++) {
	// int color=oldPx[i];
	// a=Color.alpha(color);
	// r=Color.red(color);
	// g=Color.green(color);
	// b=Color.blue(color);
	// r=255-r;
	// g=255-g;
	// b=255-b;
	// if(r>255)
	// r=255;
	// else if(r<0)
	// r=0;
	//
	// if(g>255)
	// g=255;
	// else if(g<0)
	// g=0;
	//
	// if(b>255)
	// b=255;
	// else if(b<0)
	// b=0;
	// newPx[i]=Color.argb(a, r, g, b);
	// }
	// Bitmap bmp=Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
	// bmp.setPixels(newPx, 0, width, 0, 0, width, height);
	// return bmp;
	// }
	private static Bitmap fs(Bitmap bmp, float[] fs) {
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		ColorMatrix matrix = new ColorMatrix();
		matrix.set(fs);
		Paint paint = new Paint();
		paint.setColorFilter(new ColorMatrixColorFilter(matrix));
		canvas.drawBitmap(bmp, 0, 0, paint);
		return bitmap;
	}

	/**
	 * ͼƬ�ϳ�
	 * 
	 * @param bm
	 * @param bmp
	 */
	public static Bitmap addFrameToImage(Bitmap bm, Bitmap bmp) // bmpԭͼ(ǰ��)
																// bm��ԴͼƬ(����)
	{
		Bitmap drawBitmap = Bitmap.createBitmap(bmp.getWidth(),
				bmp.getHeight(), bmp.getConfig());
		Canvas canvas = new Canvas(drawBitmap);
		Paint paint = new Paint();
		canvas.drawBitmap(bmp, 0, 0, paint);
		paint.setXfermode(new PorterDuffXfermode(
				android.graphics.PorterDuff.Mode.LIGHTEN));
		// �Ա߿��������
		int w = bm.getWidth();
		int h = bm.getHeight();
		// ���ű� ���ͼƬ�ߴ糬���߿�ߴ� ���Զ�ƥ��
		float scaleX = bmp.getWidth() * 1F / w;
		float scaleY = bmp.getHeight() * 1F / h;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleX, scaleY); // ����ͼƬ
		Bitmap copyBitmap = Bitmap.createBitmap(bm, 0, 0, w, h, matrix, true);
		canvas.drawBitmap(copyBitmap, 0, 0, paint);
		return drawBitmap;
	}

	/**
	 * ͼƬ�ϳ�
	 * 
	 * @param frameBitmap
	 * @param bmp
	 * @return
	 */
	public static Bitmap addFrameToImageTwo(Bitmap frameBitmap, Bitmap bmp) // bmpԭͼ
																			// frameBitmap��ԴͼƬ(�߿�)
	{
		// bmpԭͼ ������λͼ
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap drawBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
		// �Ա߿��������
		int w = frameBitmap.getWidth();
		int h = frameBitmap.getHeight();
		float scaleX = width * 1F / w; // ���ű� ���ͼƬ�ߴ糬���߿�ߴ� ���Զ�ƥ��
		float scaleY = height * 1F / h;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleX, scaleY); // ����ͼƬ
		Bitmap copyBitmap = Bitmap.createBitmap(frameBitmap, 0, 0, w, h,
				matrix, true);

		int pixColor = 0;
		int layColor = 0;
		int newColor = 0;

		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int pixA = 0;

		int newR = 0;
		int newG = 0;
		int newB = 0;
		int newA = 0;

		int layR = 0;
		int layG = 0;
		int layB = 0;
		int layA = 0;

		float alpha = 0.8F;
		float alphaR = 0F;
		float alphaG = 0F;
		float alphaB = 0F;

		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				pixColor = bmp.getPixel(i, k);
				layColor = copyBitmap.getPixel(i, k);
				// ��ȡԭͼƬ��RGBAֵ
				pixR = Color.red(pixColor);
				pixG = Color.green(pixColor);
				pixB = Color.blue(pixColor);
				pixA = Color.alpha(pixColor);
				// ��ȡ�߿�ͼƬ��RGBAֵ
				layR = Color.red(layColor);
				layG = Color.green(layColor);
				layB = Color.blue(layColor);
				layA = Color.alpha(layColor);
				// ��ɫ�봿��ɫ����ĵ�
				if (layR < 20 && layG < 20 && layB < 20) {
					alpha = 1F;
				} else {
					alpha = 0.3F;
				}
				alphaR = alpha;
				alphaG = alpha;
				alphaB = alpha;
				// ������ɫ����
				newR = (int) (pixR * alphaR + layR * (1 - alphaR));
				newG = (int) (pixG * alphaG + layG * (1 - alphaG));
				newB = (int) (pixB * alphaB + layB * (1 - alphaB));
				layA = (int) (pixA * alpha + layA * (1 - alpha));
				// ֵ��0~255֮��
				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));
				newA = Math.min(255, Math.max(0, layA));
				// ����
				newColor = Color.argb(newA, newR, newG, newB);
				drawBitmap.setPixel(i, k, newColor);
			}
		}
		return drawBitmap;
	}

	/**
	 * ѹ��ͼƬ��ָ����С������
	 * 
	 * @return
	 */
	@SuppressLint("NewApi")
	public static Bitmap compression(long size, String url) {
		Options opts = new Options();
		opts.inJustDecodeBounds = false;
		Bitmap bitmap = BitmapFactory.decodeFile(url, opts);
		return compression(size, bitmap);
	}

	/**
	 * ѹ��ͼƬ��ָ����С
	 * 
	 * @param size
	 * @param bitmap
	 * @return
	 */
	@SuppressLint("NewApi")
	public static Bitmap compression(long size, Bitmap bitmap) {
		int bs = 0;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
			bs = bitmap.getByteCount();
		} else
			bs = bitmap.getRowBytes() * bitmap.getHeight();
		int proportion = 1;
		while (bs >= size * proportion) {
			proportion = proportion << 1;
		}
		if (proportion == 1)
			return bitmap;
		Matrix matrix = new Matrix();
		float p = proportion * 0.5f;
		float sx = 1 / p;
		float sy = 1 / p;
		matrix.postScale(sx, sy);
		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
				bitmap.getHeight(), matrix, true);
	}

	/**
	 * ��������ת��Ϊbyte����
	 * 
	 * @param is
	 * @return
	 */
	public static byte[] inputStream2byte(InputStream is) {
		try {
			// TODO Auto-generated method stub
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte[] arr = bos.toByteArray();
			bos.close();
			is.close();
			// new DashPathEffect(intervals, phase)
			return arr;
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage().getBytes();
		}
	}

	/**
	 * ��ͼ��ת��Ϊ byte����
	 * 
	 * @param bmp
	 * @return
	 */
	public static byte[] bitmap2byte(Bitmap bmp) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
			byte[] b = baos.toByteArray();
			baos.close();
			return b;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ��ͼ��ת��Ϊ������
	 * 
	 * @param bmp
	 * @return
	 */
	public static InputStream bitmap2InputStream(Bitmap bmp) {
		byte[] b = bitmap2byte(bmp);
		if (b != null)
			return new ByteArrayInputStream(b);
		return null;
	}

	/**
	 * ��ͼƬת��Ϊ�ļ�
	 * 
	 * @param bmp
	 * @return
	 */
	public static boolean bitmap2File(Bitmap bmp, String fileName) {
		try {

			// Toast.makeText(MainActivity.this,"ͼƬ��ַ------"+bitmap.compress(Bitmap.CompressFormat.PNG,
			// 70, out) , 2).show();
			FileOutputStream out = new FileOutputStream(fileName);
			if (bmp.compress(Bitmap.CompressFormat.PNG, 30, out)) {
				out.flush();
				out.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressLint("SimpleDateFormat")
	private static String getPhotoFileName() {
		// TODO Auto-generated method stub
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"'IMG'_yyyyMMdd_HHmmss");
		return dateFormat.format(date) + ".jpg";
	}

	/**
	 * ��src�л�ȡͼƬ
	 * 
	 * @param heigth
	 *            ���ź�ĸ߶�
	 * @param width
	 *            ���ź�Ŀ��
	 * @param src
	 *            src��ַ
	 * @param context
	 *            ������
	 * @return
	 */
	public static Bitmap src(int heigth, int width, int src, Context context) {
		if (heigth <= 0 && width <= 0)
			return src(src, context);
		Options opts = new Options();
		opts.inJustDecodeBounds = true;// ������ͼƬ��ֻ�ǽ���ͼƬ
		Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(),
				src, opts);
		int bHeigth = opts.outHeight;
		int bWidth = opts.outWidth;
		int multiple = 0;
		if (heigth > 0 && width > 0) {
			int heightScale = bHeigth / heigth;
			int widthScale = bWidth / width;
			multiple = heightScale > widthScale ? widthScale : heightScale;
		} else if (heigth > 0)
			multiple = bHeigth / heigth;
		else
			multiple = bWidth / width;
		opts.inSampleSize = multiple > 1 ? multiple : 1;
		opts.inJustDecodeBounds = false;
		bitmap1 = BitmapFactory.decodeResource(context.getResources(), src,
				opts);

		return zoom(heigth, width, bitmap1);
	}

	/**
	 * ��ȡ src�е�ͼƬ
	 * 
	 * @param src
	 * @param context
	 * @return
	 */
	public static Bitmap src(int src, Context context) {
		return BitmapFactory.decodeResource(context.getResources(), src);
	}

	/**
	 * ���ļ����л�ȡͼƬ��������ܻ��ò���ͼƬ
	 * 
	 * @param heigth
	 *            ���ź�߶�
	 * @param width
	 *            ���ź���
	 * @param url
	 *            ��ַ
	 * @return
	 */
	public static Bitmap url(int heigth, int width, String url) {
		if (heigth <= 0 && width <= 0) {
			return url(url);
		}
		Options opts = new Options();
		opts.inJustDecodeBounds = true;
		Bitmap bitmap1 = BitmapFactory.decodeFile(url, opts);
		int bHeigth = opts.outHeight;
		int bWidth = opts.outWidth;
		int multiple = 0;
		int heightScale = 0;
		int widthScale = 0;
		if (width > 0 && heigth > 0) {
			heightScale = bHeigth / heigth;
			widthScale = bWidth / width;
			multiple = heightScale > widthScale ? widthScale : heightScale;
		} else if (width > 0) {
			multiple = bWidth / width;
		} else {
			multiple = bHeigth / heigth;
		}
		opts.inSampleSize = multiple > 1 ? multiple : 1;
		opts.inJustDecodeBounds = false;
		bitmap1 = BitmapFactory.decodeFile(url, opts);
		return zoom(heigth, width, bitmap1);
	}

	/**
	 * ���ļ����л�ȡͼƬ��������ܻ��ò���ͼƬ
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap url(String url) {

		return BitmapFactory.decodeFile(url);
	}

	/**
	 * ���ļ����л�ȡͼƬ��������ܻ��ò���ͼƬ
	 * 
	 * @param heigth
	 *            ���ź�߶�
	 * @param width
	 *            ���ź���
	 * @param url
	 *            ��ַ
	 * @param context
	 *            ������
	 * @return
	 */
	public static Bitmap url(int heigth, int width, String url, Context context) {
		try {
			if (heigth <= 0 && width <= 0)
				return url(url, context);
			Options opts = new Options();
			opts.inJustDecodeBounds = true;
			Bitmap bitmap1 = BitmapFactory.decodeStream(context
					.getContentResolver().openInputStream(Uri.parse(url)),
					null, opts);
			int bHeigth = opts.outHeight;
			int bWidth = opts.outWidth;
			int multiple = 0;
			if (heigth > 0 && width > 0) {
				int heightScale = bHeigth / heigth;
				int widthScale = bWidth / width;
				multiple = heightScale > widthScale ? widthScale : heightScale;
			} else if (heigth > 0)
				multiple = bHeigth / heigth;
			else
				multiple = bWidth / width;
			opts.inSampleSize = multiple > 1 ? multiple : 1;
			opts.inJustDecodeBounds = false;
			bitmap1 = BitmapFactory.decodeStream(context.getContentResolver()
					.openInputStream(Uri.parse(url)), null, opts);
			return zoom(heigth, width, bitmap1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ���ļ����л�ȡͼƬ��������ܻ��ò���ͼƬ
	 * 
	 * @param url
	 * @param context
	 * @return
	 */
	public static Bitmap url(String url, Context context) {
		try {

			return BitmapFactory.decodeStream(context.getContentResolver()
					.openInputStream(Uri.parse(url)));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * �ַ�����ת��ΪͼƬ
	 * 
	 * @param heigth
	 * @param width
	 * @param buff
	 * @return
	 */
	public static Bitmap bytes2Bitmap(int heigth, int width, byte[] buff) {
		if (width <= 0 && heigth <= 0)
			return bytes2Bitmap(buff);
		Options opts = new Options();
		opts.inJustDecodeBounds = true;
		Bitmap bitmap1 = BitmapFactory.decodeStream(new ByteArrayInputStream(
				buff), null, opts);
		int bHeigth = opts.outHeight;
		int bWidth = opts.outWidth;
		int multiple = 0;
		if (width > 0 && heigth > 0) {
			int heightScale = bHeigth / heigth;
			int widthScale = bWidth / width;
			// ��ȡ���Ա��� ��֤��С��������Ҫ��
			multiple = heightScale > widthScale ? widthScale : heightScale;
		} else if (heigth > 0)
			multiple = bHeigth / heigth;
		else
			multiple = bWidth / width;
		opts.inSampleSize = multiple > 1 ? multiple : 1;
		opts.inJustDecodeBounds = false;
		bitmap1 = BitmapFactory.decodeStream(new ByteArrayInputStream(buff),
				null, opts);
		return zoom(heigth, width, bitmap1);
	}

	/**
	 * �ַ�����ת��ΪͼƬ
	 * 
	 * @param buff
	 * @return
	 */
	public static Bitmap bytes2Bitmap(byte[] buff) {
		return BitmapFactory.decodeStream(new ByteArrayInputStream(buff));
	}

	/**
	 * ��������ת��ΪͼƬ
	 * 
	 * @param heigth
	 * @param width
	 * @param inputStream
	 * @return
	 */
	public static Bitmap inputStream2Bitmap(int heigth, int width,
			InputStream inputStream) {
		if (heigth <= 0 && width <= 0)
			return inputStream2Bitmap(inputStream);
		byte[] buff = inputStream2byte(inputStream);
		return bytes2Bitmap(heigth, width, buff);
	}

	/**
	 * ��������ת��ΪͼƬ
	 * 
	 * @param inputStream
	 * @return
	 */
	public static Bitmap inputStream2Bitmap(InputStream inputStream) {
		return BitmapFactory.decodeStream(inputStream);
	}

	/**
	 * ����ͼƬ��ȷ���� ������
	 * 
	 * @param heigth
	 *            ���ź�ĸ߶�
	 * @param width
	 *            ���ź�Ŀ��
	 * @param bmp
	 *            ��Ҫ���ŵ�ͼƬ
	 * @return
	 */
	public static Bitmap zoom(int heigth, int width, Bitmap bmp) {
		if (heigth <= 0 && width <= 0)
			return bmp;
		if (bmp == null) {
			return null;
		}
		Matrix matrix = new Matrix(); // ��������ͼƬ��������
		float zoom = 0;
		if (heigth > 0 && width > 0) {
			float mW = width * 1.0f / bmp.getWidth();
			float mH = heigth * 1.0f / bmp.getHeight();
			zoom = mW > mH ? mW : mH;
		} else if (heigth > 0)
			zoom = heigth * 1.0f / bmp.getHeight();
		else
			zoom = width * 1.0f / bmp.getWidth();
		matrix.postScale(zoom, zoom); // ���ø߿�
		bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(),
				matrix, true);
		return bmp;
	}

	/**
	 * ����ͼƬ��ȷ���� ����
	 * 
	 * @param heigth
	 *            ���ź�ĸ߶�
	 * @param width
	 *            ���ź�Ŀ��
	 * @param bmp
	 *            ��Ҫ���ŵ�ͼƬ
	 * @return
	 */
	public static Bitmap zoom1(int heigth, int width, Bitmap bmp) {
		if (heigth <= 0 && width <= 0)
			return bmp;
		if (bmp == null) {
			return null;
		}
		bmp = zoom(heigth, width, bmp);
		Matrix matrix = new Matrix(); // ��������ͼƬ��������
		matrix.postScale(width * 1.0f / bmp.getWidth(),
				heigth * 1.0f / bmp.getHeight()); // ���ø߿�
		bmp = Bitmap.createBitmap(bmp, 0, 0, width, heigth, matrix, true);
		return bmp;
	}

	/**
	 * �� Drawable ����ת��Ϊbitmap����
	 * 
	 * @param drawable
	 * @return
	 */
	public static Bitmap drawable2bitmap(Drawable drawable) {
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		return drawable2bitmap(drawable, width, height);

	}

	public static Bitmap drawable2bitmap(Drawable drawable, int width,
			int heigth) {
		if (width <= 0)
			width = drawable.getIntrinsicWidth();
		if (heigth <= 0)
			heigth = drawable.getIntrinsicHeight();
		if (width <= 0 || heigth <= 0)
			throw new RuntimeException("width<=0 or heigth<=0");
		Bitmap bitmap = Bitmap.createBitmap(width, heigth, drawable
				.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
				: Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, heigth);
		drawable.draw(canvas);
		return bitmap;

	}

	/**
	 * �� Drawable ����ת��Ϊbitmap����
	 * 
	 * @param drawable
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Drawable bitmap2drawable(Bitmap bitmap) {
		return new BitmapDrawable(bitmap);

	}

	/**
	 * ��ȡԲ��ͼƬ
	 * 
	 * @param bitmap
	 * @param roundPx
	 * @return
	 */
	public static Bitmap rounded_bitmap(Bitmap bitmap, float roundPx) {

		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), bitmap.getConfig());
		Canvas canvas = new Canvas(output);
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

	public static Bitmap circle_bitmap(Bitmap bitmap) {
		int width = bitmap.getWidth();
		int heigth = bitmap.getHeight();
		return circle_bitmap(bitmap, 0, 0,
				(width > heigth ? heigth : width) >> 1);
	}

	/**
	 * ���Բ��ͼƬ
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap circle_bitmap(Bitmap bitmap, int start_x, int start_y,
			int r) {
		Bitmap out = load_figure(bitmap, start_x, start_y, r << 1, r << 1);
		int width = out.getWidth();
		Bitmap output = Bitmap.createBitmap(width, width, bitmap.getConfig());
		Canvas canvas = new Canvas(output);
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, width, width);
		paint.setAntiAlias(true);
		canvas.drawCircle(width * .5f, width * .5f, width * .5f, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

	/**
	 * ��ͼ xh 2017-3-7 ����11:26:59
	 * 
	 * @param bmp
	 * @param start_x
	 * @param start_y
	 * @param width
	 * @param height
	 * @return
	 */
	public static Bitmap load_figure(Bitmap bitmap, int start_x, int start_y,
			int width, int height) {
		int b_heigth = bitmap.getHeight();
		int b_width = bitmap.getWidth();
		if (start_x < 0 || start_x >= b_width)
			start_x = 0;
		if (start_y < 0 || start_y >= b_heigth)
			start_y = 0;
		if (width <= 0 || width + start_x > b_width)
			width = b_width - start_x;
		if (height <= 0 || height + start_y > b_heigth)
			height = b_heigth - start_y;
		return Bitmap.createBitmap(bitmap, start_x, start_y, width, height);
	}

	/**
	 * ����λͼ xh 2017-3-7 ����12:06:40
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap heart_bitmap(Bitmap bitmap) {
		return heart_bitmap(bitmap, 0, 0,
				bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight()
						: bitmap.getWidth());
	}

	public static Bitmap heart_bitmap(Bitmap bitmap, int start_x, int start_y,
			int width) {
		Bitmap bitmap2 = load_figure(bitmap, start_x, start_y, width, width);
		int height = bitmap2.getWidth();
		Bitmap out = Bitmap.createBitmap(height, height, bitmap.getConfig());
		Path path = new Path();
		float px = height * 1.0f / 2;
		float py = height * 1.0f / 2;
		float rate = height / 34;
		// ·������ʼ��
		path.moveTo(px, py - 5 * rate);
		// �������κ�����ͼ
		for (double i = 0; i <= 2 * Math.PI; i += 0.001) {
			float x = (float) (16 * Math.sin(i) * Math.sin(i) * Math.sin(i));
			float y = (float) (13 * Math.cos(i) - 5 * Math.cos(2 * i) - 2
					* Math.cos(3 * i) - Math.cos(4 * i));
			x *= rate;
			y *= rate;
			x = px - x;
			y = py - y;
			path.lineTo(x, y);
		}
		path.close();
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		Canvas canvas = new Canvas(out);
		canvas.drawPath(path, paint);
		Rect src = new Rect(0, 0, height, height);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap2, src, src, paint);
		return out;
	}

	/**
	 * �������λͼ xh 2017-3-12 ����5:53:35
	 * 
	 * @param bitmap
	 * @param variable
	 * @return
	 */
	public static Bitmap polygon_bitmap(Bitmap bitmap, int variable) {
		int wid = bitmap.getWidth();
		int hei = bitmap.getHeight();
		return polygon_bitmap(bitmap, variable, 0, 0, wid > hei ? hei : wid);
	}

	/**
	 * �������λͼ xh 2017-3-7 ����2:07:06
	 * 
	 * @param bitmap
	 * @param variable
	 * @param start_x
	 * @param start_y
	 * @param width
	 * @return
	 */
	public static Bitmap polygon_bitmap(Bitmap bitmap, int variable,
			int start_x, int start_y, int width) {
		Bitmap bitmap2 = load_figure(bitmap, start_x, start_y, width, width);
		int b_width = bitmap2.getWidth();
		Bitmap out = Bitmap.createBitmap(b_width, b_width, bitmap.getConfig());
		Canvas canvas = new Canvas(out);
		Paint paint = new Paint();
		Path path = new Path();
		float r = b_width * .5f;
		path.moveTo(width / 2, 0);
		for (int i = 1; i < variable; i++) {
			float[] xy = new float[2];
			double angle = i * 360 / variable + 90;
			double length = r;
			if (angle < 180) {
				angle = Math.toRadians(180 - angle);
				xy[0] = (float) (r + length * Math.cos(angle));
				xy[1] = (float) (r - length * Math.sin(angle));
			} else if (angle < 270) {
				angle = Math.toRadians(angle - 180);
				xy[0] = (float) (r + length * Math.cos(angle));
				xy[1] = (float) (r + length * Math.sin(angle));
			} else if (angle < 360) {
				angle = Math.toRadians(360 - angle);
				xy[1] = (float) (r + length * Math.sin(angle));
				xy[0] = (float) (r - length * Math.cos(angle));
			} else {
				angle = Math.toRadians(angle - 360);
				xy[1] = (float) (r - length * Math.sin(angle));
				xy[0] = (float) (r - length * Math.cos(angle));
			}
			path.lineTo(xy[0], xy[1]);
		}
		path.close();
		canvas.drawPath(path, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		Rect src = new Rect(0, 0, b_width, b_width);
		canvas.drawBitmap(bitmap2, src, src, paint);
		return out;
	}

	/**
	 * �����λͼ xh 2017-3-12 ����5:53:48
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap star_bitmap(Bitmap bitmap) {
		return star_bitmap(bitmap, 0, 0,
				bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight()
						: bitmap.getWidth());
	}

	/**
	 * �����λͼ xh 2017-3-7 ����2:13:55
	 * 
	 * @param bitmap
	 * @param start_x
	 * @param start_y
	 * @param width
	 * @return
	 */
	public static Bitmap star_bitmap(Bitmap bitmap, int start_x, int start_y,
			int width) {
		Bitmap bitmap2 = load_figure(bitmap, start_x, start_y, width, width);
		int b_width = bitmap2.getWidth();
		Bitmap out = Bitmap.createBitmap(b_width, b_width, bitmap.getConfig());
		Canvas canvas = new Canvas(out);
		Paint paint = new Paint();
		Path path = new Path();
		float r = width * .5f;
		path.moveTo(width / 2, 0);
		for (int i = 1; i < 10; i++) {
			float[] xy = new float[2];
			double angle = i * 36 + 90;
			double length = 0;
			if (i % 2 == 0)
				length = r;
			else
				length = r * 0.618f;
			if (angle < 180) {
				angle = Math.toRadians(180 - angle);
				xy[0] = (float) (r + length * Math.cos(angle));
				xy[1] = (float) (r - length * Math.sin(angle));
			} else if (angle < 270) {
				angle = Math.toRadians(angle - 180);
				xy[0] = (float) (r + length * Math.cos(angle));
				xy[1] = (float) (r + length * Math.sin(angle));
			} else if (angle < 360) {
				angle = Math.toRadians(360 - angle);
				xy[1] = (float) (r + length * Math.sin(angle));
				xy[0] = (float) (r - length * Math.cos(angle));
			} else {
				angle = Math.toRadians(angle - 360);
				xy[1] = (float) (r - length * Math.sin(angle));
				xy[0] = (float) (r - length * Math.cos(angle));
			}
			path.lineTo(xy[0], xy[1]);
		}
		path.close();
		canvas.drawPath(path, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		Rect src = new Rect(0, 0, b_width, b_width);
		canvas.drawBitmap(bitmap2, src, src, paint);
		return out;
	}

	/**
	 * ��תBitmap
	 * 
	 * @param b
	 * @param rotateDegree
	 * @return
	 */
	public static Bitmap rotate_bitmap(Bitmap b, float rotateDegree) {
		Matrix matrix = new Matrix();
		matrix.postRotate(rotateDegree);
		Bitmap rotaBitmap = Bitmap.createBitmap(b, 0, 0, b.getWidth(),
				b.getHeight(), matrix, false);
		int width = rotaBitmap.getWidth();
		int height = rotaBitmap.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height, b.getConfig());
		Canvas canvas = new Canvas(bitmap);
		Paint paint = new Paint();
		canvas.drawBitmap(rotaBitmap, 0, 0, paint);
		return bitmap;
	}

	/**
	 * LOMO��Ч
	 * 
	 * @param bitmap
	 *            ԭͼƬ
	 * @return LOMO��ЧͼƬ
	 */
	public static Bitmap lomoFilter(Bitmap bitmap) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		int dst[] = new int[width * height];
		bitmap.getPixels(dst, 0, width, 0, 0, width, height);

		int ratio = width > height ? height * 32768 / width : width * 32768
				/ height;
		int cx = width >> 1;
		int cy = height >> 1;
		int max = cx * cx + cy * cy;
		int min = (int) (max * (1 - 0.8f));
		int diff = max - min;

		int ri, gi, bi;
		int dx, dy, distSq, v;

		int R, G, B;

		int value;
		int pos, pixColor;
		int newR, newG, newB;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pos = y * width + x;
				pixColor = dst[pos];
				R = Color.red(pixColor);
				G = Color.green(pixColor);
				B = Color.blue(pixColor);

				value = R < 128 ? R : 256 - R;
				newR = (value * value * value) / 64 / 256;
				newR = (R < 128 ? newR : 255 - newR);

				value = G < 128 ? G : 256 - G;
				newG = (value * value) / 128;
				newG = (G < 128 ? newG : 255 - newG);

				newB = B / 2 + 0x25;

				// ==========��Ե�ڰ�==============//
				dx = cx - x;
				dy = cy - y;
				if (width > height)
					dx = (dx * ratio) >> 15;
				else
					dy = (dy * ratio) >> 15;

				distSq = dx * dx + dy * dy;
				if (distSq > min) {
					v = ((max - distSq) << 8) / diff;
					v *= v;

					ri = (int) (newR * v) >> 16;
					gi = (int) (newG * v) >> 16;
					bi = (int) (newB * v) >> 16;

					newR = ri > 255 ? 255 : (ri < 0 ? 0 : ri);
					newG = gi > 255 ? 255 : (gi < 0 ? 0 : gi);
					newB = bi > 255 ? 255 : (bi < 0 ? 0 : bi);
				}
				// ==========��Ե�ڰ�end==============//

				dst[pos] = Color.rgb(newR, newG, newB);
			}
		}

		Bitmap acrossFlushBitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		acrossFlushBitmap.setPixels(dst, 0, width, 0, 0, width, height);
		return acrossFlushBitmap;
	}

	/**
	 * ��ʱ����Ч
	 * 
	 * @param bmp
	 *            ԭͼƬ
	 * @return ��ʱ����ЧͼƬ
	 */
	public static Bitmap oldTimeFilter(Bitmap bmp) {
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		int pixColor = 0;
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int newR = 0;
		int newG = 0;
		int newB = 0;
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 0; i < height; i++) {
			for (int k = 0; k < width; k++) {
				pixColor = pixels[width * i + k];
				pixR = Color.red(pixColor);
				pixG = Color.green(pixColor);
				pixB = Color.blue(pixColor);
				newR = (int) (0.393 * pixR + 0.769 * pixG + 0.189 * pixB);
				newG = (int) (0.349 * pixR + 0.686 * pixG + 0.168 * pixB);
				newB = (int) (0.272 * pixR + 0.534 * pixG + 0.131 * pixB);
				int newColor = Color.argb(255, newR > 255 ? 255 : newR,
						newG > 255 ? 255 : newG, newB > 255 ? 255 : newB);
				pixels[width * i + k] = newColor;
			}
		}

		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	/**
	 * ů����Ч
	 * 
	 * @param bmp
	 *            ԭͼƬ
	 * @param centerX
	 *            ��Դ������
	 * @param centerY
	 *            ��Դ������
	 * @return ů����ЧͼƬ
	 */
	public static Bitmap warmthFilter(Bitmap bmp, int centerX, int centerY) {
		final int width = bmp.getWidth();
		final int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);

		int pixR = 0;
		int pixG = 0;
		int pixB = 0;

		int pixColor = 0;

		int newR = 0;
		int newG = 0;
		int newB = 0;
		int radius = Math.min(centerX, centerY);

		final float strength = 150F; // ����ǿ�� 100~150
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		int pos = 0;
		for (int i = 1, length = height - 1; i < length; i++) {
			for (int k = 1, len = width - 1; k < len; k++) {
				pos = i * width + k;
				pixColor = pixels[pos];

				pixR = Color.red(pixColor);
				pixG = Color.green(pixColor);
				pixB = Color.blue(pixColor);

				newR = pixR;
				newG = pixG;
				newB = pixB;

				// ���㵱ǰ�㵽�������ĵľ��룬ƽ������ϵ��������֮��ľ���
				int distance = (int) (Math.pow((centerY - i), 2) + Math.pow(
						centerX - k, 2));
				if (distance < radius * radius) {
					// ���վ����С�������ӵĹ���ֵ
					int result = (int) (strength * (1.0 - Math.sqrt(distance)
							/ radius));
					newR = pixR + result;
					newG = pixG + result;
					newB = pixB + result;
				}

				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));

				pixels[pos] = Color.argb(255, newR, newG, newB);
			}
		}

		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	/**
	 * ���ݱ��Ͷȡ�ɫ�ࡢ���ȵ���ͼƬ
	 * 
	 * @param bm
	 *            ԭͼƬ
	 * @param saturation
	 *            ���Ͷ�
	 * @param hue
	 *            ɫ��
	 * @param lum
	 *            ����
	 * @return ������ͼƬ
	 */
	public static Bitmap handleImage(Bitmap bm, int saturation, int hue, int lum) {
		Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(),
				Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bmp);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		ColorMatrix mLightnessMatrix = new ColorMatrix();
		ColorMatrix mSaturationMatrix = new ColorMatrix();
		ColorMatrix mHueMatrix = new ColorMatrix();
		ColorMatrix mAllMatrix = new ColorMatrix();
		float mSaturationValue = saturation * 1.0F / 127;
		float mHueValue = hue * 1.0F / 127;
		float mLumValue = (lum - 127) * 1.0F / 127 * 180;
		mHueMatrix.reset();
		mHueMatrix.setScale(mHueValue, mHueValue, mHueValue, 1);

		mSaturationMatrix.reset();
		mSaturationMatrix.setSaturation(mSaturationValue);
		mLightnessMatrix.reset();

		mLightnessMatrix.setRotate(0, mLumValue);
		mLightnessMatrix.setRotate(1, mLumValue);
		mLightnessMatrix.setRotate(2, mLumValue);

		mAllMatrix.reset();
		mAllMatrix.postConcat(mHueMatrix);
		mAllMatrix.postConcat(mSaturationMatrix);
		mAllMatrix.postConcat(mLightnessMatrix);

		paint.setColorFilter(new ColorMatrixColorFilter(mAllMatrix));
		canvas.drawBitmap(bm, 0, 0, paint);
		return bmp;
	}

	/**
	 * ���ͼƬ��߿�
	 * 
	 * @param context
	 *            ������
	 * @param bm
	 *            ԭͼƬ
	 * @param frameName
	 *            �߿�����
	 * @return ���б߿��ͼƬ
	 */
	public static Bitmap combinateFrame(Context context, Bitmap bm,
			String frameName) {
		// ԭͼƬ�Ŀ��
		int imageWidth = bm.getWidth();
		int imageHeight = bm.getHeight();

		// �߿�
		Bitmap leftUp = decodeBitmap(context, frameName, 0);
		Bitmap leftDown = decodeBitmap(context, frameName, 2);
		Bitmap rightDown = decodeBitmap(context, frameName, 4);
		Bitmap rightUp = decodeBitmap(context, frameName, 6);
		Bitmap top = decodeBitmap(context, frameName, 7);
		Bitmap down = decodeBitmap(context, frameName, 3);
		Bitmap left = decodeBitmap(context, frameName, 1);
		Bitmap right = decodeBitmap(context, frameName, 5);

		Bitmap newBitmap = null;
		Canvas canvas = null;

		// �жϴ�СͼƬ�Ŀ��
		int judgeWidth = 0;
		int judgeHeight = 0;
		if ("frame7".equals(frameName)) {
			judgeWidth = leftUp.getWidth() + rightUp.getWidth()
					+ top.getWidth() * 5;
			judgeHeight = leftUp.getHeight() + leftDown.getHeight()
					+ left.getHeight() * 5;
		} else if ("frame10".equals(frameName)) {
			judgeWidth = leftUp.getWidth() + rightUp.getWidth()
					+ top.getWidth() * 5;
			judgeHeight = leftUp.getHeight() + leftDown.getHeight()
					+ left.getHeight() * 10;
		} else {
			judgeWidth = leftUp.getWidth() + rightUp.getWidth()
					+ top.getWidth();
			judgeHeight = leftUp.getHeight() + leftDown.getHeight()
					+ left.getHeight();
		}
		// �ڱ߿�
		if (imageWidth > judgeWidth && imageHeight > judgeHeight) {
			// ���¶���һ��bitmap
			newBitmap = Bitmap.createBitmap(imageWidth, imageHeight,
					Config.ARGB_8888);
			canvas = new Canvas(newBitmap);
			Paint paint = new Paint();
			// ��ԭͼ
			canvas.drawBitmap(bm, 0, 0, paint);
			// �Ͽ�����
			int topWidth = imageWidth - leftUp.getWidth() - rightUp.getWidth();
			// �Ͽ���������
			int topCount = (int) Math.ceil(topWidth * 1.0f / top.getWidth());
			for (int i = 0; i < topCount; i++) {
				canvas.drawBitmap(top, leftUp.getWidth() + top.getWidth() * i,
						0, paint);
			}
			// �¿�����
			int downWidth = imageWidth - leftDown.getWidth()
					- rightDown.getWidth();
			// �¿���������
			int downCount = (int) Math.ceil(downWidth * 1.0f / down.getWidth());
			for (int i = 0; i < downCount; i++) {
				canvas.drawBitmap(down, leftDown.getWidth() + down.getWidth()
						* i, imageHeight - down.getHeight(), paint);
			}
			// �����߶�
			int leftHeight = imageHeight - leftUp.getHeight()
					- leftDown.getHeight();
			// �����������
			int leftCount = (int) Math.ceil(leftHeight * 1.0f
					/ left.getHeight());
			for (int i = 0; i < leftCount; i++) {
				canvas.drawBitmap(left, 0,
						leftUp.getHeight() + left.getHeight() * i, paint);
			}
			// �ҿ���߶�
			int rightHeight = imageHeight - rightUp.getHeight()
					- rightDown.getHeight();
			// �ҿ���������
			int rightCount = (int) Math.ceil(rightHeight * 1.0f
					/ right.getHeight());
			for (int i = 0; i < rightCount; i++) {
				canvas.drawBitmap(right, imageWidth - right.getWidth(),
						rightUp.getHeight() + right.getHeight() * i, paint);
			}
			// �����Ͻ�
			canvas.drawBitmap(leftUp, 0, 0, paint);
			// �����½�
			canvas.drawBitmap(leftDown, 0, imageHeight - leftDown.getHeight(),
					paint);
			// �����½�
			canvas.drawBitmap(rightDown, imageWidth - rightDown.getWidth(),
					imageHeight - rightDown.getHeight(), paint);
			// �����Ͻ�
			canvas.drawBitmap(rightUp, imageWidth - rightUp.getWidth(), 0,
					paint);

		} else {
			if ("frame7".equals(frameName)) {
				imageWidth = leftUp.getWidth() + top.getWidth() * 5
						+ rightUp.getWidth();
				imageHeight = leftUp.getHeight() + left.getHeight() * 5
						+ leftDown.getHeight();
			} else if ("frame10".equals(frameName)) {
				imageWidth = leftUp.getWidth() + top.getWidth() * 5
						+ rightUp.getWidth();
				imageHeight = leftUp.getHeight() + left.getHeight() * 10
						+ leftDown.getHeight();
			} else {
				imageWidth = leftUp.getWidth() + top.getWidth()
						+ rightUp.getWidth();
				imageHeight = leftUp.getHeight() + left.getHeight()
						+ leftDown.getHeight();
			}
			newBitmap = Bitmap.createBitmap(imageWidth, imageHeight,
					Config.ARGB_8888);
			canvas = new Canvas(newBitmap);
			Paint paint = new Paint();
			int newImageWidth = imageWidth - left.getWidth() - right.getWidth()
					+ 5;
			int newImageHeight = imageHeight - top.getHeight()
					- down.getHeight() + 5;
			bm = Bitmap.createScaledBitmap(bm, newImageWidth, newImageHeight,
					true);
			canvas.drawBitmap(bm, left.getWidth(), top.getHeight(), paint);
			if ("frame7".equals(frameName)) {

				for (int i = 0; i < 5; i++) {
					canvas.drawBitmap(top, leftUp.getWidth() + top.getWidth()
							* i, 0, paint);
				}

				for (int i = 0; i < 5; i++) {
					canvas.drawBitmap(left, 0,
							leftUp.getHeight() + left.getHeight() * i, paint);
				}

				for (int i = 0; i < 5; i++) {
					canvas.drawBitmap(right, imageWidth - right.getWidth(),
							rightUp.getHeight() + right.getHeight() * i, paint);
				}

				for (int i = 0; i < 5; i++) {
					canvas.drawBitmap(down,
							leftDown.getWidth() + down.getWidth() * i,
							imageHeight - down.getHeight(), paint);
				}
				canvas.drawBitmap(leftUp, 0, 0, paint);
				canvas.drawBitmap(rightUp, leftUp.getWidth() + top.getWidth()
						* 5, 0, paint);
				canvas.drawBitmap(leftDown, 0,
						leftUp.getHeight() + left.getHeight() * 5, paint);
				canvas.drawBitmap(rightDown, imageWidth - rightDown.getWidth(),
						rightUp.getHeight() + right.getHeight() * 5, paint);

			} else if ("frame10".equals(frameName)) {
				for (int i = 0; i < 5; i++) {
					canvas.drawBitmap(top, leftUp.getWidth() + top.getWidth()
							* i, 0, paint);
				}

				for (int i = 0; i < 10; i++) {
					canvas.drawBitmap(left, 0,
							leftUp.getHeight() + left.getHeight() * i, paint);
				}

				for (int i = 0; i < 10; i++) {
					canvas.drawBitmap(right, imageWidth - right.getWidth(),
							rightUp.getHeight() + right.getHeight() * i, paint);
				}

				for (int i = 0; i < 5; i++) {
					canvas.drawBitmap(down,
							leftDown.getWidth() + down.getWidth() * i,
							imageHeight - down.getHeight(), paint);
				}
				canvas.drawBitmap(leftUp, 0, 0, paint);
				canvas.drawBitmap(rightUp, leftUp.getWidth() + top.getWidth()
						* 5, 0, paint);
				canvas.drawBitmap(leftDown, 0,
						leftUp.getHeight() + left.getHeight() * 10, paint);
				canvas.drawBitmap(rightDown, imageWidth - rightDown.getWidth(),
						rightUp.getHeight() + right.getHeight() * 10, paint);
			} else {
				canvas.drawBitmap(leftUp, 0, 0, paint);
				canvas.drawBitmap(top, leftUp.getWidth(), 0, paint);
				canvas.drawBitmap(rightUp, leftUp.getWidth() + top.getWidth(),
						0, paint);
				canvas.drawBitmap(left, 0, leftUp.getHeight(), paint);
				canvas.drawBitmap(leftDown, 0,
						leftUp.getHeight() + left.getHeight(), paint);
				canvas.drawBitmap(right, imageWidth - right.getWidth(),
						rightUp.getHeight(), paint);
				canvas.drawBitmap(rightDown, imageWidth - rightDown.getWidth(),
						rightUp.getHeight() + right.getHeight(), paint);
				canvas.drawBitmap(down, leftDown.getWidth(),
						imageHeight - down.getHeight(), paint);
			}
		}
		// ����
		leftUp.recycle();
		leftUp = null;
		leftDown.recycle();
		leftDown = null;
		rightDown.recycle();
		rightDown = null;
		rightUp.recycle();
		rightUp = null;
		top.recycle();
		top = null;
		down.recycle();
		down = null;
		left.recycle();
		left = null;
		right.recycle();
		right = null;
		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
		return newBitmap;
	}

	/**
	 * ��ȡ�߿�ͼƬ
	 * 
	 * @param context
	 *            ������
	 * @param frameName
	 *            �߿�����
	 * @param position
	 *            �߿������
	 * @return �߿�ͼƬ
	 */
	private static Bitmap decodeBitmap(Context context, String frameName,
			int position) {
		try {
			switch (position) {
			case 0:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/leftup.png"));
			case 1:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/left.png"));
			case 2:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/leftdown.png"));
			case 3:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/down.png"));
			case 4:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/rightdown.png"));
			case 5:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/right.png"));
			case 6:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/rightup.png"));
			case 7:
				return BitmapFactory.decodeStream(context.getAssets().open(
						"frames/" + frameName + "/up.png"));
			default:
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ����ڱ߿�
	 * 
	 * @param bm
	 *            ԭͼƬ
	 * @param frame
	 *            �ڱ߿�ͼƬ
	 * @return ���б߿��ͼƬ
	 */
	public static Bitmap addBigFrame(Bitmap bm, Bitmap frame) {
		Bitmap newBitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(),
				Config.ARGB_8888);
		Canvas canvas = new Canvas(newBitmap);
		Paint paint = new Paint();
		canvas.drawBitmap(bm, 0, 0, paint);
		frame = Bitmap.createScaledBitmap(frame, bm.getWidth(), bm.getHeight(),
				true);
		canvas.drawBitmap(frame, 0, 0, paint);
		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
		return newBitmap;

	}
}
