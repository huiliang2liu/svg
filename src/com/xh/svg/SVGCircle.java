package com.xh.svg;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;

/**
 * @version ����ʱ�䣺2018-1-6 ����10:35:52 ��Ŀ��repair ������com.xh.svg �ļ�����SVGCircle.java
 *          ���ߣ�lhl ˵��:
 */

public class SVGCircle extends SVGPath {
	public SVGCircle(SVGEntity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	private float centerX = 0;
	private float centerY = 0;
	private float radius = 0;

	public float getCenterX() {
		return centerX;
	}

	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}

	public float getCenterY() {
		return centerY;
	}

	public void setCenterY(float centerY) {
		this.centerY = centerY;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	protected void childDraw(Canvas canvas, float factor) {
		// TODO Auto-generated method stub
		if(path==null){
			path=new Path();
			path.addCircle(centerX, centerY, radius, Direction.CW);
			path.close();
		}
		super.childDraw(canvas, factor);
//		float centerX = this.centerX * factor;
//		float centerY = this.centerY * factor;
//		float radius = this.radius * factor;
//		if (doFill(factor)) {
//			doLimits(centerX - radius, centerY - radius);
//			doLimits(centerX + radius, centerY + radius);
//			canvas.drawCircle(centerX, centerY, radius, paint);
//		}
//		if (doStroke()) {
//			canvas.drawCircle(centerX, centerY, radius, paint);
//		}
	}

}
