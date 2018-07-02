package com.canbot.devmodedemo.mvp.base;

import com.canbot.devmodedemo.mvp.view.Callback;

interface TestContract {

    interface Model extends BaseModel {
        void getData1(Callback callback1);
        void getData2(Callback callback2);
        void getData3(Callback callback3);
    }

    interface View extends BaseView {
        void updateUI1();
        void updateUI2();
        void updateUI3();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void request1();
        abstract void request2();
        void request3() {
            model.getData3(new Callback() {
                @Override
                public void onResult(String text) {
                    view.updateUI3();
                }
            });
        }
    }
}