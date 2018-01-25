package com.xh.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;

import com.xh.svg.vector.VectorPathParser;
import com.xh.util.Util;
import com.xh.util.XhLog;
import com.xh.util.XhPhoneInformation;

/**
 * @version 创建时间：2018-1-11 下午6:27:32 项目：repair 包名：com.xh.svg 文件名：PathSVG.java
 *          作者：lhl 说明:
 */

public class PathSVG extends ASVG {
	int color = Color.WHITE;
	private final static String TAG = "PathSVG";
	private Path path;

	public PathSVG(XhPhoneInformation information) {
		super(information);
		// TODO Auto-generated constructor stub
	}

	public void svg2path(String string) {
		path = SVGParser.doPath(string);
		setW();
	}

	public void vector2path(String string) {
		path = VectorPathParser.createPathFromPathData(string);
		setW();
	}

	private void setW() {
		RectF rectF = new RectF();
		path.computeBounds(rectF, false);
		setViewBoxWidth((int) rectF.right);
		setViewBoxHeigth((int) rectF.bottom);
		XhLog.e(TAG, "width=" + getViewBoxWidth() + " heigth="
				+ getViewBoxHeigth());
	}

	@Override
	public Path createPath(float factor) {
		// TODO Auto-generated method stub
		return Util.factorPath(path, factor);
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int color() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	protected void childDraw(Canvas canvas, float factor) {
		// TODO Auto-generated method stub
		XhLog.e(TAG, "childDraw");
		Path path1 = Util.factorPath(path, factor);
		paint.setColor(color);
		canvas.drawPath(path1, paint);
	}

}
