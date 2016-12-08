package org.loader.router.rule.intent;

import android.app.Activity;

import org.loader.router.exception.ActivityNotRouteException;

/**
 * {@link Activity}路由规则实现类
 */
public class ActivityRule extends BaseIntentRule<Activity> {

    /**
     * Activity路由scheme
     */
    public static final String SCHEME_ACTIVITY = "activity://";

    @Override
    public void throwException(String scheme, String path) {
        throw new ActivityNotRouteException(scheme, path);
    }
}
