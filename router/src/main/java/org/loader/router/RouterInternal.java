package org.loader.router;

import android.content.Context;

import org.loader.router.exception.NotRouteException;
import org.loader.router.rule.Rule;
import org.loader.router.rule.intent.ActivityRule;
import org.loader.router.rule.intent.ReceiverRule;
import org.loader.router.rule.intent.ServiceRule;

import java.util.HashMap;

/**
 * Router真实调用类(单例模式)
 */
class RouterInternal {

    /**
     * 路由规则Map(scheme->路由规则)
     */
    private HashMap<String, Rule> mRouterRuleMap = new HashMap<>();

    /**
     * Router真实调用类实例
     */
    private volatile static RouterInternal sInstance;

    /**
     * 私有构造方法
     */
    private RouterInternal() {
        initDefaultRouter();
    }

    /**
     * 添加默认的Activity，Service，Receiver路由规则
     */
    private void initDefaultRouter() {
        addRule(ActivityRule.SCHEME_ACTIVITY, new ActivityRule());
        addRule(ServiceRule.SCHEME_SERVICE, new ServiceRule());
        addRule(ReceiverRule.SCHEME_RECEIVER, new ReceiverRule());
    }

    /**
     * 返回Router真实调用类实例
     */
    static RouterInternal getInstance() {
        if (sInstance == null) {
            synchronized (RouterInternal.class) {
                if (sInstance == null) {
                    sInstance = new RouterInternal();
                }
            }
        }
        return sInstance;
    }

    /**
     * 添加自定义路由规则
     *
     * @param scheme 路由scheme
     * @param rule   路由规则
     * @return {@code RouterInternal} Router真实调用类
     */
    final RouterInternal addRule(String scheme, Rule rule) {
        mRouterRuleMap.put(scheme, rule);
        return this;
    }

    /**
     * 添加路由
     *
     * @param scheme 路由scheme
     * @param path   自定义路径
     * @param cls    路由class
     * @return {@code RouterInternal} Router真实调用类
     */
    final <T> RouterInternal router(String scheme, String path, Class<T> cls) {
        Rule<T, ?> rule = getRule(scheme);
        if (rule == null) {
            throw new NotRouteException("unknown", scheme, path);
        }
        rule.router(scheme, path, cls);
        return this;
    }

    /**
     * 路由调用
     *
     * @param context 上下文
     * @param scheme  路由scheme
     * @param path    自定义路径
     * @return {@code V} 返回对应的路由规则实现类
     */
    final <V> V invoke(Context context, String scheme, String path) {
        Rule<?, V> rule = getRule(scheme);
        if (rule == null) {
            throw new NotRouteException("unknown", scheme, path);
        }
        return rule.invoke(context, scheme, path);
    }

    /**
     * 返回路由实现类
     *
     * @param scheme 路由scheme
     * @param <T>
     * @param <V>
     * @return
     */
    private <T, V> Rule<T, V> getRule(String scheme) {
        Rule<T, V> rule = null;
        if (mRouterRuleMap.containsKey(scheme)) {
            rule = mRouterRuleMap.get(scheme);
        }
        return rule;
    }
}
