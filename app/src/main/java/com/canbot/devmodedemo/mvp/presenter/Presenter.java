package com.canbot.devmodedemo.mvp.presenter;

import com.canbot.devmodedemo.mvp.view.Callback;
import com.canbot.devmodedemo.mvp.view.MVPView;
import com.canbot.devmodedemo.mvp.model.HttpModel;

public class Presenter {
    private MVPView view;
    private HttpModel model;

    public Presenter(MVPView view) {
        this.view = view;
        model = new HttpModel(new Callback() {
            @Override
            public void onResult(String text) {
                Presenter.this.view.updateTv(text);
            }
        });
    }

    public void request() {
        model.request();
    }

    public void detachView() {
        view = null;
    }
}