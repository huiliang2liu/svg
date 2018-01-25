package com.xh.svg;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Typeface;

import com.xh.string.StringUtil;
import com.xh.util.XhLog;

/**
 * @version ����ʱ�䣺2018-1-8 ����11:35:49 ��Ŀ��repair ������com.xh.svg �ļ�����SVGText.java
 *          ���ߣ�lhl ˵��:
 */

public class SVGText extends SVGD {
	List<Tspan> tspans;
	private float x = 0;

	public SVGText(SVGEntity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
		tspans = new ArrayList<SVGText.Tspan>();
	}

	@Override
	protected void childDraw(Canvas canvas, float factor) {
		// TODO Auto-generated method stub
		XhLog.e("childDraw", "SVGText");
		for (int i = 0; i < tspans.size(); i++) {
			Tspan tspan = tspans.get(i);
			paint.setColor(tspan.getFill());
			paint.setTextSize(tspan.getFont_size() * factor);
			paint.setTypeface(tspan.getFont_family());
			canvas.drawText(tspan.text, x, tspan.y * factor,
					paint);
			x += paint.measureText(tspan.getText());
			paint.reset();
		}
		x=0;

	}

	public void add(Tspan tspan) {
		tspans.add(tspan);
	}

	public static class Tspan {
		private float x;
		private float y;
		private int fill = 0xffffff;
		private String font_family;
		private float font_size = 1;
		private String text;

		public float getX() {
			return x;
		}

		public void setX(String x) {
			this.x = Float.valueOf(x);
		}

		public float getY() {
			return y;
		}

		public void setY(String y) {
			this.y = Float.valueOf(y);
		}

		public int getFill() {
			return fill;
		}

		public void setFill(String fill) {
			this.fill = StringUtil.color(fill);
		}

		public Typeface getFont_family() {
			if ("Default".equals(font_family))
				return Typeface.DEFAULT; // ������������
			if ("Default_Bold".equals(font_family))
				return Typeface.DEFAULT_BOLD; // ������������
			if ("Monospace".equals(font_family))
				return Typeface.MONOSPACE; // �ȿ���������
			if ("Sans_Serif".equals(font_family))
				return Typeface.SANS_SERIF; // sans serif��������
			if ("Serif".equals(font_family))
				return Typeface.SERIF; // serif��������
			if ("Bold".equals(font_family))
				return Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
			if ("Bold_Italic".equals(font_family))
				return Typeface.create(Typeface.SANS_SERIF,
						Typeface.BOLD_ITALIC);
			if ("Italic".equals(font_family))
				return Typeface.create(Typeface.SANS_SERIF, Typeface.ITALIC);
			if ("Normal".equals(font_family))
				return Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL);
			return null;
		}

		public void setFont_family(String font_family) {
			// MyriadPro-Bold
			String strings[] = font_family.split("-");
			if (strings.length == 1 || strings.length == 2)
				this.font_family = strings[strings.length - 1];
			else {
				font_family = strings[1];
				for (int i = 2; i < strings.length; i++) {
					font_family += "_" + strings[i];
				}
			}
		}

		public float getFont_size() {
			return font_size;
		}

		public void setFont_size(String font_size) {
			this.font_size = Float.valueOf(font_size);
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}

}
