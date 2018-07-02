package com.canbot.devmodedemo.mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.canbot.devmodedemo.R;
import com.canbot.devmodedemo.mvp.view.MVPView;
import com.canbot.devmodedemo.mvp.presenter.Presenter;

/**
 * Created by tao.liu on 2018/7/2.
 * mvp架构
 */
public class MVPActivity extends AppCompatActivity implements MVPView {

	private android.widget.Button button;

	private android.widget.TextView textView;

	private Presenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mvc);
		initView();
	}

	private void initView() {
		this.textView = (TextView) findViewById(R.id.textView);
		this.button = (Button) findViewById(R.id.button);
		presenter = new Presenter(this);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.request();
			}
		});
	}

	@Override
	public void updateTv(String text) {
		textView.setText(text);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}
}
