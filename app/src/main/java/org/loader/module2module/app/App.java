package org.loader.module2module.app;

import android.app.Application;

import org.loader.bbslib.BBSActivity;
import org.loader.router.Router;
import org.loader.router.rule.intent.ActivityRule;
import org.loader.shoplib.ShopActivity;
import org.loader.utilslib.Logger;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupRouter();
        Logger.dump("TAG", "application: " + getClass().getName());
    }

    private void setupRouter() {
        Router.router(ActivityRule.SCHEME_ACTIVITY, "shop.main", ShopActivity.class);
        Router.router(ActivityRule.SCHEME_ACTIVITY, "bbs.main", BBSActivity.class);
    }
}
