package com.canbot.devmodedemo.mvp.rxjava.presenter;

import com.canbot.devmodedemo.mvp.view.MVPView;
import com.canbot.devmodedemo.mvp.rxjava.model.HttpModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class Presenter {
    private MVPView view;
    private HttpModel model;

    public Presenter(MVPView view) {
        this.view = view;
        model = new HttpModel();
    }

    private Disposable disposable;

    public void request() {
        disposable = model.request()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        view.updateTv(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void detachView() {
        view = null;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}