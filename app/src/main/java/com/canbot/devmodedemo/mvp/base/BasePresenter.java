package com.canbot.devmodedemo.mvp.base;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

	protected V view;

	protected M model;

	public BasePresenter() {
		model = createModel();
	}

	void attachView(V view) {
		this.view = view;
	}

	void detachView() {
		this.view = null;
	}

	abstract M createModel();
}