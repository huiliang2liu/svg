package com.xh.svg;

import com.xh.svg.SVGParser.StyleSet;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2018-1-5 下午5:50:51 项目：repair 包名：com.xh.svg 文件名：Properties.java
 *          作者：lhl 说明:
 */

public class Properties {
	private StyleSet styles = null;
	private String display;
	private String fill;
	private String stroke;
	private float strokeWidth;
	private String strokeLinecap;
	private String strokeLinejoin;
	private Float opacity;
	private Float fillOpacity;
	private Float strokeOpacity=1.0f;

	public Float getStrokeOpacity() {
		return strokeOpacity;
	}

	public void setStrokeOpacity(String strokeOpacity) {
		this.strokeOpacity = Float.valueOf(strokeOpacity);
	}

	public Float getOpacity() {
		return opacity;
	}

	public Float getFillOpacity() {
		return fillOpacity;
	}

	public void setFillOpacity(String fillOpacity) {
		this.fillOpacity = Float.valueOf(fillOpacity);
	}

	public void setOpacity(String opacity) {
		this.opacity = Float.valueOf(opacity);
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getStroke() {
		return stroke;
	}

	public void setStroke(String stroke) {
		this.stroke = stroke;
	}

	public float getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(String strokeWidth) {
		this.strokeWidth = Float.valueOf(strokeWidth);
	}

	public String getStrokeLinecap() {
		return strokeLinecap;
	}

	public void setStrokeLinecap(String strokeLinecap) {
		this.strokeLinecap = strokeLinecap;
	}

	public String getStrokeLinejoin() {
		return strokeLinejoin;
	}

	public void setStrokeLinejoin(String strokeLinejoin) {
		this.strokeLinejoin = strokeLinejoin;
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public StyleSet getStyles() {
		return styles;
	}

	public void setStyles(StyleSet styles) {
		this.styles = styles;
	}

	public Properties() {
	}

	public Integer getHex(String value) {
		XhLog.e("getHex", value);
		if (value == null || !value.startsWith("#")) {
			return null;
		} else {
			try {
				return Integer.parseInt(value.substring(1), 16);
			} catch (NumberFormatException nfe) {
				// todo - parse word-based color here
				nfe.printStackTrace();
				return null;
			}
		}
	}

}
