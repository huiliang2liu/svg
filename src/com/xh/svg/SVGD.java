package com.xh.svg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;

import com.xh.string.StringUtil;
import com.xh.util.Util;

/**
 * @version 创建时间：2018-1-6 上午10:36:51 项目：repair 包名：com.xh.svg 文件名：SVGD.java
 *          作者：lhl 说明:
 */

public abstract class SVGD {
	private Matrix transform;
	private Properties props;
	protected Paint paint;
	protected RectF rect = new RectF();
	RectF limits = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
			Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
	private boolean whiteMode = false;
	private Integer searchColor = null;
	private Integer replaceColor = null;
	private SVGEntity entity;
	private Matrix matrix;
	private float[] values;

	public void setColorSwap(Integer searchColor, Integer replaceColor) {
		this.searchColor = searchColor;
		this.replaceColor = replaceColor;
	}

	public void setWhiteMode(boolean whiteMode) {
		this.whiteMode = whiteMode;
	}

	public SVGD(SVGEntity entity) {
		// TODO Auto-generated constructor stub
		paint = entity.getPaint();
		this.entity = entity;
		matrix = new Matrix();
		values = new float[9];
	}

	public void setTransform(String string) {
		this.transform = SVGParser.parseTransform(string);
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	protected void pushTransform(Canvas canvas, float factor) {
		if (transform == null)
			return;
		transform.getValues(values);
		values[2] *= factor;
		values[5] *= factor;
		matrix.setValues(values);
		canvas.save();
		canvas.concat(matrix);
	}

	public void draw(Canvas canvas, float factor) {
		pushTransform(canvas, factor);
		childDraw(canvas, factor);
		popTransform(canvas);
	}

	protected abstract void childDraw(Canvas canvas, float factor);

	protected void popTransform(Canvas canvas) {
		if (transform != null) {
			canvas.restore();
		}
	}

	protected boolean doFill(float factor) {
		if ("none".equals(props.getDisplay())) {
			return false;
		}
		if (whiteMode) {
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(0xFFFFFFFF);
			return true;
		}
		String fill = props.getFill();
		paint.setShader(null);
		if (fill != null) {
			if (fill.startsWith("url(#")) {
				String id = fill.substring("url(#".length(), fill.length() - 1);
				Shader shader = entity.getShader(id, factor);
				if (shader != null) {
					paint.setShader(shader);
					paint.setStyle(Paint.Style.FILL);
					return true;
				} else {
					// Util.debug("Didn't find shader!");
					return false;
				}
			} else {
				Integer color = StringUtil.color(fill);
				paint.setColor(StringUtil.color(fill));
				doColor(props, color, true);
				paint.setStyle(Paint.Style.FILL);
				return true;
			}
		} else if (props.getStroke() == null) {
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(0xFF000000);
			return true;
		}
		return false;
	}

	public int color() {
		String fill = props.getFill();
		if (fill != null && !fill.startsWith("url(#"))
			return StringUtil.color(fill);
		return Color.argb(0xff, 0x00, 0x00, 0x00);
	}

	protected boolean doStroke() {
		if (whiteMode) {
			// Never stroke in white mode
			return false;
		}
		if ("none".equals(props.getDisplay())) {
			return false;
		}
		Integer color = props.getHex(props.getStroke());
		if (color != null) {
			doColor(props, color, false);
			// Check for other stroke attributes
			Float width = props.getStrokeWidth();
			// Set defaults

			if (width != null) {
				paint.setStrokeWidth(width);
			}
			String linecap = props.getStrokeLinecap();
			if ("round".equals(linecap)) {
				paint.setStrokeCap(Paint.Cap.ROUND);
			} else if ("square".equals(linecap)) {
				paint.setStrokeCap(Paint.Cap.SQUARE);
			} else if ("butt".equals(linecap)) {
				paint.setStrokeCap(Paint.Cap.BUTT);
			}
			String linejoin = props.getStrokeLinejoin();
			if ("miter".equals(linejoin)) {
				paint.setStrokeJoin(Paint.Join.MITER);
			} else if ("round".equals(linejoin)) {
				paint.setStrokeJoin(Paint.Join.ROUND);
			} else if ("bevel".equals(linejoin)) {
				paint.setStrokeJoin(Paint.Join.BEVEL);
			}
			paint.setStyle(Paint.Style.STROKE);
			return true;
		}
		return false;
	}

	private void doColor(Properties atts, Integer color, boolean fillMode) {
		int c = (0xFFFFFF & color) | 0xFF000000;
		if (searchColor != null && searchColor.intValue() == c) {
			c = replaceColor;
		}
		paint.setColor(c);
		Float opacity = atts.getOpacity();
		if (opacity == null) {
			opacity = fillMode ? atts.getFillOpacity() : atts
					.getStrokeOpacity();
		}
		if (opacity == null) {
			paint.setAlpha(255);
		} else {
			paint.setAlpha((int) (opacity * StringUtil.FF));
		}
	}

	protected void doLimits(float x, float y, float width, float height) {
		doLimits(x, y);
		doLimits(x + width, y + height);
	}

	protected void doLimits(Path path) {
		path.computeBounds(rect, false);
		doLimits(rect.left, rect.top);
		doLimits(rect.right, rect.bottom);
	}

	protected void doLimits(float x, float y) {
		if (x < limits.left) {
			limits.left = x;
		}
		if (x > limits.right) {
			limits.right = x;
		}
		if (y < limits.top) {
			limits.top = y;
		}
		if (y > limits.bottom) {
			limits.bottom = y;
		}
	}

	protected Path toPath() {
		if (!(this instanceof SVGPath))
			throw new RuntimeException("do not to path");
		SVGPath svgPath = (SVGPath) this;
		return svgPath.path;
	}

	protected Path factorPath(Path path, float factor) {
		return Util.factorPath(path, factor);
	}
}
