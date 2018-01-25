package com.xh.svg.vector;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

import com.xh.svg.ASVG;
import com.xh.util.Util;
import com.xh.util.XhPhoneInformation;

/**
 * @version ����ʱ�䣺2018-1-9 ����5:08:11 ��Ŀ��repair ������com.xh.svg.vector
 *          �ļ�����VectorEntity1.java ���ߣ�lhl ˵��:
 */

public class VectorEntity extends ASVG {
	List<PathData> pathDatas = new ArrayList<PathData>();
	List<TextData> textDatas = new ArrayList<TextData>();
	private static final RectF RECTF = new RectF();

	public VectorEntity(XhPhoneInformation information) {
		super(information);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Path createPath(float factor) {
		// TODO Auto-generated method stub
		Path path = new Path();
		for (int i = 0; i < pathDatas.size(); i++) {
			path.addPath(Util.factorPath(pathDatas.get(i).getPath(), factor));
		}
		return path;
	}

	@Override
	public int color() {
		// TODO Auto-generated method stub
		if (pathDatas != null && pathDatas.size() > 0) {
			PathData data = pathDatas.get(0);
			if (data.getStrokeColor() != null)
				return data.getStrokeColor();
			return data.getFillColor();
		}
		if (textDatas != null && textDatas.size() > 0) {
			TextData data = textDatas.get(0);
			return data.getTextColor();
		}
		throw new RuntimeException("not find color");
	}

	public void add(PathData pathData) {
		pathDatas.add(pathData);
		int viewportHeight = getViewBoxHeigth(), viewportWidth = getViewBoxWidth();
		if (viewportHeight <= 0 || viewportWidth <= 0) {
			int left = 0;
			int right = 0;
			int top = 0;
			int bottom = 0;
			pathData.getPath().computeBounds(RECTF, true);
			left = Math.min(left, (int) RECTF.left);
			right = Math.max(right, (int) RECTF.right);
			top = Math.min(top, (int) RECTF.top);
			bottom = Math.max(bottom, (int) RECTF.bottom);
			viewportHeight = Math.max(bottom - top, viewportHeight);
			viewportWidth = Math.max(right - left, viewportWidth);
			setViewBoxHeigth(viewportHeight);
			setViewBoxWidth(viewportWidth);
		}
	}

	public void add(TextData textData) {
		textDatas.add(textData);
	}

	public PathData id2pathData(String id) {
		PathData pathData = new PathData();
		pathData.setId(id);
		int dex = pathDatas.indexOf(pathData);
		if (dex > 0) {
			pathDatas.remove(dex);
			return pathDatas.get(dex);
		}
		return null;
	}

	@Override
	protected void childDraw(Canvas canvas, float factor) {
		// TODO Auto-generated method stub
		if (pathDatas.size() > 0)
			for (int i = 0; i < pathDatas.size(); i++) {
				PathData data = pathDatas.get(i);
				data.setPaint(paint);
				data.draw(canvas, factor);
			}
		if (textDatas.size() > 0)
			for (int i = 0; i < textDatas.size(); i++) {
				TextData data = textDatas.get(i);
				data.setPaint(paint);
				data.draw(canvas, factor);
			}
	}

}
