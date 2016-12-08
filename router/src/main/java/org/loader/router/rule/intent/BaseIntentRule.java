package org.loader.router.rule.intent;

import android.content.Context;
import android.content.Intent;

import org.loader.router.rule.BaseRule;

/**
 * {@link Intent}的路由规则实现类的基类
 */
abstract class BaseIntentRule<T> extends BaseRule<T, Intent> {

    @Override
    public Intent invoke(Context context, String scheme, String path) {
        Class<T> cls = getClass(scheme, path);
        return new Intent(context, cls);
    }
}