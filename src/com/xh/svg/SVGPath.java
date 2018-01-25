package com.xh.svg;

import android.graphics.Canvas;
import android.graphics.Path;

/**
 * @version ����ʱ�䣺2018-1-6 ����10:54:07 ��Ŀ��repair ������com.xh.svg �ļ�����SVGPath.java
 *          ���ߣ�lhl ˵��:
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
