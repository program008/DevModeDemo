package com.canbot.devmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.canbot.devmodedemo.mvc.view.MVCActivity;
import com.canbot.devmodedemo.mvp.ui.MVPActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button btnmvc;

	private Button btnmvp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		this.btnmvp = (Button) findViewById(R.id.btn_mvp);
		this.btnmvc = (Button) findViewById(R.id.btn_mvc);

		btnmvc.setOnClickListener(this);
		btnmvp.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_mvc:
				nextActivity(MVCActivity.class);
				break;
			case R.id.btn_mvp:
				nextActivity(MVPActivity.class);
				break;
			default:
				break;
		}
	}

	private void nextActivity(Class clazz){
		Intent intent  = new Intent(this,clazz);
		startActivity(intent);
	}
}
