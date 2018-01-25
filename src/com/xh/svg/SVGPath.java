package com.xh.svg;

import android.graphics.Canvas;
import android.graphics.Path;

/**
 * @version 创建时间：2018-1-6 上午10:54:07 项目：repair 包名：com.xh.svg 文件名：SVGPath.java
 *          作者：lhl 说明:
 */

public class SVGPath extends SVGD {
	public SVGPath(SVGEntity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	protected Path path;

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	@Override
	protected void childDraw(Canvas canvas, float factor) {
		Path path1 = factorPath(path, factor);
		if (doFill(factor)) {
			doLimits(path1);
			canvas.drawPath(path1, paint);
		}
		if (doStroke()) {
			canvas.drawPath(path1, paint);
		}
	}

}
