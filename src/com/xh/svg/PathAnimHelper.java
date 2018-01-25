package com.xh.svg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.xh.util.XhLog;

/**
 * ���ܣ�һ���Զ���View Path�����Ĺ�����
 * <p>
 * һ��SourcePath �ں���Σ�һ�Σ�Path��ѭ��ȡ��ÿ��Path������һ������,
 * <p>
 * Ĭ�϶���ʱ��1500ms������ѭ�� ����ͨ�����캯���޸�����������
 * <p>
 * ���Ⱪ¶ startAnim() �� stopAnim()��������
 * <p>
 * �����ͨ����дonPathAnimCallback������������animPath�����ٴβ������Ӷ����岻ͬ�Ķ���Ч��
 */

public class PathAnimHelper {
	private static final String TAG = "zxt/PathAnimHelper";
	protected static final long mDefaultAnimTime = 1500;// Ĭ�϶�����ʱ��

	protected View mView;// ִ�ж�����View
	protected Path mSourcePath;// ԴPath
	protected Path mAnimPath;// ���ڻ��ƶ�����Path
	protected long mAnimTime;// ����һ����ʱ��
	protected boolean mIsInfinite;// �Ƿ�����ѭ��

	protected ValueAnimator mAnimator;// ��������
	private AnimEndListen listen;

	public void setListen(AnimEndListen listen) {
		this.listen = listen;
	}

	/**
	 * INIT FUNC
	 **/
	public PathAnimHelper(View view, Path sourcePath, Path animPath) {
		this(view, sourcePath, animPath, mDefaultAnimTime, true);
	}

	public PathAnimHelper(View view, Path sourcePath, Path animPath,
			long animTime, boolean isInfinite) {
//		if (view == null || sourcePath == null || animPath == null) {
//			Log.e(TAG,
//					"PathAnimHelper init error: view ��sourcePath��animPath can not be null");
//			return;
//		}
		mView = view;
		mSourcePath = sourcePath;
		mAnimPath = animPath;
		mAnimTime = animTime;
		mIsInfinite = isInfinite;
	}

	/**
	 * GET SET FUNC
	 **/
	public View getView() {
		return mView;
	}

	public PathAnimHelper setView(View view) {
		mView = view;
		return this;
	}

	public Path getSourcePath() {
		return mSourcePath;
	}

	public PathAnimHelper setSourcePath(Path sourcePath) {
		mSourcePath = sourcePath;
		return this;
	}

	public Path getAnimPath() {
		return mAnimPath;
	}

	public PathAnimHelper setAnimPath(Path animPath) {
		mAnimPath = animPath;
		return this;
	}

	public long getAnimTime() {
		return mAnimTime;
	}

	public PathAnimHelper setAnimTime(long animTime) {
		mAnimTime = animTime;
		return this;
	}

	public boolean isInfinite() {
		return mIsInfinite;
	}

	public PathAnimHelper setInfinite(boolean infinite) {
		mIsInfinite = infinite;
		return this;
	}

	public ValueAnimator getAnimator() {
		return mAnimator;
	}

	public PathAnimHelper setAnimator(ValueAnimator animator) {
		mAnimator = animator;
		return this;
	}

	/**
	 * ִ�ж���
	 */
	public void startAnim() {
		startAnim(mView, mSourcePath, mAnimPath, mAnimTime, mIsInfinite);
	}

	/**
	 * һ��SourcePath �ں����Path��ѭ��ȡ��ÿ��Path������һ������ �Զ��嶯������ʱ�� ���Ƿ�ѭ��
	 * 
	 * @param view
	 *            ��Ҫ���������Զ���View
	 * @param sourcePath
	 *            ԴPath
	 * @param animPath
	 *            �Զ���View�����Path������
	 * @param totalDuaration
	 *            ����һ����ʱ��
	 * @param isInfinite
	 *            �Ƿ�����ѭ��
	 */
	protected void startAnim(View view, Path sourcePath, Path animPath,
			long totalDuaration, boolean isInfinite) {
		if (view == null || sourcePath == null || animPath == null) {
			return;
		}
		PathMeasure pathMeasure = new PathMeasure();
		// pathMeasure.setPath(sourcePath, false);
		// ������һ����Ҫ��ʾ������path
		animPath.reset();
		animPath.lineTo(0, 0);
		pathMeasure.setPath(sourcePath, false);
		// ���������Ϊ�� ����һ��ÿһ�ε�duration
		int count = 0;
		while (pathMeasure.getLength() != 0) {
			pathMeasure.nextContour();
			count++;
		}
		// ����������μ���duration��������� ��Ҫ���³�ʼ��pathMeasure
		pathMeasure.setPath(sourcePath, false);
		loopAnim(view, sourcePath, animPath, totalDuaration, pathMeasure,
				totalDuaration / count, isInfinite);
	}

	/**
	 * ѭ��ȡ��ÿһ��path ����ִ�ж���
	 * 
	 * @param animPath
	 *            �Զ���View�����Path������
	 * @param pathMeasure
	 *            ���ڲ�����PathMeasure
	 */
	protected void loopAnim(final View view, final Path sourcePath,
			final Path animPath, final long totalDuaration1,
			final PathMeasure pathMeasure, final long duration,
			final boolean isInfinite) {
		// �����������еĻ�����stop�ɡ���һ����Ҫʹ���¶����أ��������û�������ô�á���
		stopAnim();
		XhLog.e(TAG, "isInfinite=" + isInfinite);
		mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
		mAnimator.setInterpolator(new LinearInterpolator());
		mAnimator.setDuration(duration);
		mAnimator.setRepeatCount(ValueAnimator.INFINITE);
		mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// Log.i("TAG", "onAnimationUpdate");
				// ����һ��callback ����������д������
				onPathAnimCallback(view, sourcePath, animPath, pathMeasure,
						animation);
				// ֪ͨViewˢ���Լ�
				view.invalidate();
			}
		});

		mAnimator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationRepeat(Animator animation) {
				// Log.w("TAG", "onAnimationRepeat: ");
				// ÿ��path�����Ҫ��һ�� ĳЩ�������� animPath���������
				pathMeasure.getSegment(0, pathMeasure.getLength(), animPath,
						true);

				// ������һ��Path֮���ٻ�����һ��
				pathMeasure.nextContour();
				// ����Ϊ0 ˵��һ��ѭ������
				if (pathMeasure.getLength() == 0) {
					if (isInfinite) {// �����Ҫѭ������
						animPath.reset();
						animPath.lineTo(0, 0);
						pathMeasure.setPath(sourcePath, false);
					} else {// ����Ҫ��ֹͣ����Ϊrepeat������ ��Ҫ�ֶ�ֹͣ��
						animation.end();
						listen.end();
					}
				}
			}

		});
		mAnimator.start();
	}

	/**
	 * ֹͣ����
	 */
	public void stopAnim() {
		// Log.e("TAG", "stopAnim: ");
		if (null != mAnimator && mAnimator.isRunning()) {
			mAnimator.end();
			// Log.e("TAG", "true stopAnim: ");
		}
	}

	/**
	 * ��������̳и����飬��animPath�����ٴβ����ĺ���
	 * 
	 * @param view
	 * @param sourcePath
	 * @param animPath
	 * @param pathMeasure
	 */
	public void onPathAnimCallback(View view, Path sourcePath, Path animPath,
			PathMeasure pathMeasure, ValueAnimator animation) {
		float value = (float) animation.getAnimatedValue();
		// ��ȡһ������
		pathMeasure.getSegment(0, pathMeasure.getLength() * value, animPath,
				true);
	}
}
