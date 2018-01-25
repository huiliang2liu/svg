package com.xh.svg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.xh.base.XhBaseActivity;
import com.xh.ifaces.ISVG;
import com.xh.reflect.FieldManager;
import com.xh.svg.vector.VectorParas;

/**
 * ���ܣ�һ��·��������View ����ԴPath���ơ��ס� ���ö���Path ���� ��䶯��
 * <p>
 * ͨ��mPathAnimHelper ��SourcePath�������� һ��SourcePath �ں����Path��ѭ��ȡ��ÿ��Path������һ������,
 * <p>
 * 
 */

public class PathAnimView extends ImageView implements AnimEndListen {
	protected Path mSourcePath;// ��Ҫ��������ԴPath
	protected Path mAnimPath;// ���ڻ��ƶ�����Path
	protected Paint mPaint;
	protected int mColorBg = Color.argb(0x00, 0x00, 0x00, 0x00);// ����ɫ
	protected int mColorFg = Color.WHITE;// ǰ��ɫ ���ɫ
	protected PathAnimHelper mPathAnimHelper;// Path����������
	protected int mPaddingLeft, mPaddingTop;
	protected VectorParas vectorParas;
	protected SVGParser svgParser;
	private ISVG entity;

	public PathAnimView(Context context) {
		this(context, null);
		init(context);
	}

	public PathAnimView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		init(context);
	}

	public PathAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public Path getSourcePath() {
		return mSourcePath;
	}

	public void drawPath(int rawId) {
		if (vectorParas != null) {

		}
	}

	public void drawVectorPath(int rawId) {
		if (vectorParas != null) {
			try {
				entity = vectorParas.paras(getResources(), rawId);
				setSourcePath(entity.createPath(this));
				mColorFg = entity.color();
				start();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void start(int time) {
		mPathAnimHelper.setAnimTime(time);
		startAnim();
	}

	public void start() {
		start(300);
	}

	public void drawSVGPath(int rawId) throws Exception {
		if (svgParser != null) {
			entity = svgParser.paras(getResources(), rawId);
			setSourcePath(entity.createPath(this));
			mColorFg = entity.color();
			start();
		}
	}

	/**
	 * ����������ܻᾭ���õ�����������ԴPath
	 * 
	 * @param sourcePath
	 * @return
	 */
	public PathAnimView setSourcePath(Path sourcePath) {
		mSourcePath = sourcePath;
		mPathAnimHelper.setSourcePath(sourcePath);
		return this;
	}

	public Paint getPaint() {
		return mPaint;
	}

	public PathAnimView setPaint(Paint paint) {
		mPaint = paint;
		return this;
	}

	public int getColorBg() {
		return mColorBg;
	}

	public PathAnimView setColorBg(int colorBg) {
		mColorBg = colorBg;
		return this;
	}

	public int getColorFg() {
		return mColorFg;
	}

	public PathAnimView setColorFg(int colorFg) {
		mColorFg = colorFg;
		return this;
	}

	public PathAnimHelper getPathAnimHelper() {
		return mPathAnimHelper;
	}

	public PathAnimView setPathAnimHelper(PathAnimHelper pathAnimHelper) {
		mPathAnimHelper = pathAnimHelper;
		return this;
	}

	public Path getAnimPath() {
		return mAnimPath;
	}

	/**
	 * INIT FUNC
	 **/
	protected void init(Context context) {
		// Paint
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(3);
		// ����·��ֻҪ��ʼ������
		mAnimPath = new Path();
		// ��ʼ������������
		mPathAnimHelper = getInitAnimHeper();
		mPathAnimHelper.setInfinite(false);
		mPathAnimHelper.setListen(this);
		vectorParas = (VectorParas) FieldManager.get_field(context,
				FieldManager.field(XhBaseActivity.class, "vectorParas"));
		this.svgParser = (SVGParser) FieldManager.get_field(context,
				FieldManager.field(XhBaseActivity.class, "svgParser"));
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mPaddingLeft = getPaddingLeft();
		mPaddingTop = getPaddingTop();
	}

	/**
	 * �����ͨ����д��������������Զ����AnimHelper
	 * 
	 * @return
	 */
	protected PathAnimHelper getInitAnimHeper() {
		return new PathAnimHelper(this, mSourcePath, mAnimPath);
	}

	/**
	 * draw FUNC
	 **/
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mSourcePath == null)
			return;
		// ƽ��
		canvas.translate(mPaddingLeft, mPaddingTop);

		// �Ȼ��Ƶף�
		mPaint.setColor(mColorBg);
		canvas.drawPath(mSourcePath, mPaint);

		// �ٻ���ǰ����mAnimPath���ϱ仯�������ػ�View�Ļ����ͻ��ж���Ч����
		mPaint.setColor(mColorFg);
		canvas.drawPath(mAnimPath, mPaint);
	}

	/**
	 * ���ö��� ѭ��
	 */
	public PathAnimView setAnimInfinite(boolean infinite) {
		mPathAnimHelper.setInfinite(infinite);
		return this;
	}

	/**
	 * ���ö��� ��ʱ��
	 */
	public PathAnimView setAnimTime(long animTime) {
		mPathAnimHelper.setAnimTime(animTime);
		return this;
	}

	/**
	 * ִ��ѭ������
	 */
	public void startAnim() {
		mPathAnimHelper.startAnim();
	}

	/**
	 * 
	 * lhl 2018-1-9 ����12:42:36 ˵��������ѭ������
	 * 
	 * @param mIsInfinite
	 *            void
	 */
	public void setInfinite(boolean infinite) {
		mPathAnimHelper.setInfinite(infinite);
	}

	/**
	 * ֹͣ����
	 */
	public void stopAnim() {
		mPathAnimHelper.stopAnim();
	}

	public void setListen(AnimEndListen listen) {
		mPathAnimHelper.setListen(listen);
	}

	/**
	 * �����ֹͣ����
	 */
	public void clearAnim() {
		stopAnim();
		mAnimPath.reset();
		mAnimPath.lineTo(0, 0);
		invalidate();
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		if (entity != null)
			setImageDrawable(entity.createDrawable(this));
		else if (entity != null)
			setImageDrawable(entity.createDrawable(this));
	}
}
