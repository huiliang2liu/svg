package com.xh.svg;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;

/**
 * @version 创建时间：2018-1-6 上午10:44:00 项目：repair 包名：com.xh.svg 文件名：SVGEllipse.java
 *          作者：lhl 说明:
 */

public class SVGEllipse extends SVGPath {
	public SVGEllipse(SVGEntity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	private float centerX = 0;
	private float centerY = 0;
	private float radiusX = 0;
	private float radiusY = 0;

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

	public float getRadiusX() {
		return radiusX;
	}

	public void setRadiusX(float radiusX) {
		this.radiusX = radiusX;
	}

	public float getRadiusY() {
		return radiusY;
	}

	public void setRadiusY(float radiusY) {
		this.radiusY = radiusY;
	}

	@Override
	protected void childDraw(Canvas canvas, float factor) {
		// TODO Auto-generated method stub
		if (path == null) {
			path = new Path();
			rect.set(centerX - radiusX, centerY - radiusY, centerX + radiusX,
					centerY + radiusY);
			path.addOval(rect, Direction.CW);
			path.close();
		}
		super.childDraw(canvas, factor);
		// float centerX = this.centerX*factor;
		// float centerY = this.centerY*factor;
		// float radiusX = this.radiusX*factor;
		// float radiusY = this.radiusY*factor;
		// if (doFill(factor)) {
		// doLimits(centerX - radiusX, centerY - radiusY);
		// doLimits(centerX + radiusX, centerY + radiusY);
		// canvas.drawOval(rect, paint);
		// }
		// if (doStroke()) {
		// canvas.drawOval(rect, paint);
		// }
	}

}
