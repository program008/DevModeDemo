package com.canbot.devmodedemo.mvc.model;

import android.os.Handler;
import android.os.Message;

import com.canbot.devmodedemo.mvc.view.Callback;

/**
 * Created by tao.liu on 2018/7/2.
 * description this is description
 */
public class HttpModel {

	private Callback callback;

	public HttpModel(Callback callback) {
		this.callback = callback;
	}

	private Handler handler = new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			callback.onResult((String) msg.obj);
			return false;
		}
	});

	public void request() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					Message msg = handler.obtainMessage();
					msg.obj = "从网络获取到的数据";
					handler.sendMessage(msg);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
