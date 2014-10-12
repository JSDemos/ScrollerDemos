package com.juude.scrollerdemos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class ScrollerDemoView extends View{

	private static final String TAG = "ScrollerDemoView";
	private float mLastTouchPos;
	private int mScaledTouchSlop;
	private int mTranslationX;
	public ScrollerDemoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
		mTranslationX = 0;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		final int action = event.getAction();
		switch(action) {
		case MotionEvent.ACTION_DOWN:
			mLastTouchPos =  event.getRawX();
			Log.d(TAG, "ACTION_DOWN"  + mLastTouchPos);
			break;
		case MotionEvent.ACTION_MOVE:
			float scrollPos =  event.getRawX();
			Log.d(TAG, "ACTION_MOVE"  + scrollPos + "  mScaledTouchSlop" + mScaledTouchSlop);
			if(Math.abs(mLastTouchPos- scrollPos) > mScaledTouchSlop / 10) {
				mTranslationX += (int)(scrollPos - mLastTouchPos);
				setTranslationX(mTranslationX);
				Log.d(TAG, "ACTION_MOVE"  + (mLastTouchPos - scrollPos));
				mLastTouchPos = scrollPos;
			}
			break;
		}
		return true;
	}
	
	

}
