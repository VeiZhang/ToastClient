package com.excellence.toast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.IntDef;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2016/12/2
 *     desc   : 始终只显示一个toast
 * </pre>
 */

public final class InfoNoticeToast extends Toast
{
	/**
	 * Construct an empty Toast object.  You must call {@link #setView} before you
	 * can call {@link #show}.
	 *
	 * @param context The context to use.  Usually your {@link Application}
	 * or {@link Activity} object.
	 */

	@SuppressWarnings("unused")
	private static final String TAG = InfoNoticeToast.class.getSimpleName();

	private static InfoNoticeToast mInstance = null;

	private Context mContext = null;
	private TextView mContentTextView = null;

	public static InfoNoticeToast getInstance(Context context)
	{
		if (mInstance == null)
		{
			mInstance = new InfoNoticeToast(context.getApplicationContext());
		}
		return mInstance;
	}

	private InfoNoticeToast(Context context)
	{
		super(context);
		mContext = context;
		LinearLayout toastLayout = new LinearLayout(context);
		toastLayout.setOrientation(LinearLayout.HORIZONTAL);
		toastLayout.setGravity(Gravity.CENTER_VERTICAL);
		mContentTextView = new TextView(context);
		int textSize = mContext.getResources().getDimensionPixelOffset(R.dimen.text_size_super_little);
		int horizontalPadding = mContext.getResources().getDimensionPixelOffset(R.dimen.padding_small);
		int verticalPadding = mContext.getResources().getDimensionPixelOffset(R.dimen.padding_micro);
		mContentTextView.setTextSize(textSize);
		mContentTextView.setTextColor(mContext.getResources().getColor(android.R.color.white));
		mContentTextView.setBackgroundResource(R.drawable.toast_bg);
		mContentTextView.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
		mContentTextView.setGravity(Gravity.CENTER);
		toastLayout.addView(mContentTextView);
		setView(toastLayout);
		setToastDuration(Toast.LENGTH_SHORT);
		setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, mContext.getResources().getDimensionPixelOffset(R.dimen.margin_small));
	}

	public InfoNoticeToast setToastDuration(@Duration int duration)
	{
		setDuration(duration);
		return this;
	}

	public InfoNoticeToast setText(String text)
	{
		mContentTextView.setText(text);
		return this;
	}

	public InfoNoticeToast setTextSize(int size)
	{
		mContentTextView.setTextSize(size);
		return this;
	}

	public InfoNoticeToast setTextResId(int resId)
	{
		mContentTextView.setText(resId);
		return this;
	}

	public InfoNoticeToast setTextBackgroundResId(int resId)
	{
		mContentTextView.setBackgroundResource(resId);
		return this;
	}

	public void showAtLocation(int gravity, int xOffset, int yOffset)
	{
		setGravity(gravity, xOffset, yOffset);
		show();
	}

	public void showMsg(int resId)
	{
		setTextResId(resId);
		show();
	}

	public void showMsg(String str)
	{
		setText(str);
		show();
	}

	public void dismiss()
	{
		super.cancel();
	}

	@IntDef({ LENGTH_LONG, LENGTH_SHORT })
	public @interface Duration
	{

	}

}
