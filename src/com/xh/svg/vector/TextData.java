package com.xh.svg.vector;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;

import com.xh.string.StringUtil;

/**
 * @version ����ʱ�䣺2018-1-5 ����4:10:07 ��Ŀ��repair ������com.xh.svg.vector
 *          �ļ�����TextData.java ���ߣ�lhl ˵��:
 */

public class TextData {
	private String text;
	private Integer textColor;
	private Integer textAlpha;
	// ���������أ��Ƕ��ı���һ���Ż����ã����������ֿ����������������ԣ����Բο�һ��PC�˵Ŀ������-��ۺ͸��Ի�-����ClearType�ı�
	private boolean subpixelText = false;
	// �����ı����»���
	private boolean underlineText = false;
	// �����ı���ɾ����
	private boolean strikeThruText = false;
	// �����ı�����
	private boolean fakeBoldText = false;
	private float x = 0f;
	private float y = 0f;
	private float hOffset = 0f;
	private float vOffset = 0f;
	private PathData textPath;
	private Paint paint;
	private Path path;
	private Matrix matrix;

	public TextData() {
		// TODO Auto-generated constructor stub
		path = new Path();
		matrix = new Matrix();
		matrix.setValues(new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 1.0f });
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public float gethOffset() {
		return hOffset;
	}

	public void sethOffset(float hOffset) {
		this.hOffset = hOffset;
	}

	public float getvOffset() {
		return vOffset;
	}

	public void setvOffset(float vOffset) {
		this.vOffset = vOffset;
	}

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

	public String getText() {
		return text;
	}

	public Integer getTextAlpha() {
		return textAlpha;
	}

	public void setTextAlpha(String textAlpha) {
		this.textAlpha = (int) (Float.valueOf(textAlpha) * StringUtil.FF);
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = StringUtil.color(textColor);
	}

	public boolean isSubpixelText() {
		return subpixelText;
	}

	public void setSubpixelText(boolean subpixelText) {
		this.subpixelText = subpixelText;
	}

	public boolean isUnderlineText() {
		return underlineText;
	}

	public void setUnderlineText(boolean underlineText) {
		this.underlineText = underlineText;
	}

	public boolean isStrikeThruText() {
		return strikeThruText;
	}

	public void setStrikeThruText(boolean strikeThruText) {
		this.strikeThruText = strikeThruText;
	}

	public boolean isFakeBoldText() {
		return fakeBoldText;
	}

	public void setFakeBoldText(boolean fakeBoldText) {
		this.fakeBoldText = fakeBoldText;
	}

	public PathData getTextPath() {
		return textPath;
	}

	public void setTextPath(PathData textPath) {
		this.textPath = textPath;
	}

	protected void draw(Canvas canvas, float factor) {
		TextData textData = this;
		Integer textColor = textData.getTextColor();
		paint.setSubpixelText(textData.isSubpixelText());
		paint.setUnderlineText(textData.isUnderlineText());
		paint.setStrikeThruText(textData.isStrikeThruText());
		paint.setFakeBoldText(textData.isFakeBoldText());
		if (textColor != null)
			paint.setColor(textColor);
		Integer textAlpha = textData.getTextAlpha();
		if (textAlpha != null)
			paint.setAlpha(textAlpha);
		PathData pathData = textData.getTextPath();
		String text = textData.getText();
		if (pathData != null) {
			matrix.postScale(factor, factor);
			path.addPath(pathData.getPath(), matrix);
			canvas.drawTextOnPath(text, path, textData.gethOffset(),
					textData.getvOffset(), paint);
			matrix.reset();
		} else {
			canvas.drawText(text, textData.getX(), textData.getY(), paint);
		}
		path.reset();
		paint.reset();
	}
}
