package com.excellence.toast.sample;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.excellence.toast.SystemToast;
import com.excellence.toast.sample.databinding.HintToastBinding;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     date   : 2017/10/23
 *     desc   : customer toast
 * </pre>
 */

public class HintToast extends SystemToast
{
	/**
	 * Construct an empty Toast object. You must call {@link #setView} before
	 * you can call {@link #showMsg}.
	 *
	 * @param context
	 *            The context to use. Usually your {@link Application} or
	 *            {@link Activity} object.
	 */
	private static final String TAG = HintToast.class.getSimpleName();

	private static HintToast mInstance = null;

	private HintToastBinding mViewDataBinding = null;

	private HintToast(Context context)
	{
		super(context);
		mViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.hint_toast, null, false);
		setView(mViewDataBinding.getRoot());
		setDuration(Toast.LENGTH_LONG);
		setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 60);
	}

	public static HintToast getInstance(Context context)
	{
		if (mInstance == null)
		{
			mInstance = new HintToast(context.getApplicationContext());
		}
		return mInstance;
	}

	public void showMsg(String hintText)
	{
		mViewDataBinding.hintText.setText(hintText);
		show();
	}

	public void showMsg(int strId)
	{
		mViewDataBinding.hintText.setText(strId);
		show();
	}
}
