package com.xh.svg;

import com.xh.util.XhLog;

import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;

/**
 * @version ����ʱ�䣺2018-1-6 ����10:11:09 ��Ŀ��repair ������com.xh.svg �ļ�����SVGRect.java
 *          ���ߣ�lhl ˵��:
 */

public class SVGRect extends SVGPath {
	public SVGRect(SVGEntity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	private float x = 0;
	private float y = 0;
	private float width = 0;
	private float height = 0;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	protected void childDraw(Canvas canvas, float factor) {
		// TODO Auto-generated method stub
		if (path == null) {
			path = new Path();
			path.addRect(x, y, x + width, y + height, Direction.CW);
			path.close();
		}
		super.childDraw(canvas, factor);
	}

}
