package com.canbot.devmodedemo.mvc.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.canbot.devmodedemo.R;
import com.canbot.devmodedemo.mvc.model.HttpModel;

/**
 * Created by tao.liu on 2018/7/2.
 * mvc架构
 */
public class MVCActivity extends AppCompatActivity implements Callback{

	private android.widget.Button button;

	private android.widget.TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mvc);
		initView();
	}

	private void initView() {
		this.textView = (TextView) findViewById(R.id.textView);
		this.button = (Button) findViewById(R.id.button);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new HttpModel(MVCActivity.this).request();
			}
		});
	}

	@Override
	public void onResult(String text) {
		textView.setText(text);
	}
}
