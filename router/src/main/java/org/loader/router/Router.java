package org.loader.router;

import android.content.Context;

import org.loader.router.rule.Rule;

/**
 * Router辅助类
 * <pre>
 * step 1.调用{@link Router#addRule(String, Rule)}方法添加自定义路由规则(默认集成了Activity、BroadcastReceiver、Service路由规则)
 * step 2.调用{@link Router#router(String, String, Class)}方法添加路由
 * step 3.调用{@link Router#invoke(Context, String, String)}方法根据scheme和path调用路由
 * </pre>
 */
public class Router {

    /**
     * 添加自定义路由规则
     *
     * @param scheme 路由scheme
     * @param rule   路由规则
     * @return {@code RouterInternal} Router真实调用类
     */
    public static RouterInternal addRule(String scheme, Rule rule) {
        return RouterInternal.getInstance().addRule(scheme, rule);
    }

    /**
     * 添加路由
     *
     * @param scheme 路由scheme
     * @param path   自定义路径
     * @param cls    路由class
     * @return {@code RouterInternal} Router真实调用类
     */
    public static <T> RouterInternal router(String scheme, String path, Class<T> cls) {
        return RouterInternal.getInstance().router(scheme, path, cls);
    }

    /**
     * 路由调用
     *
     * @param context 上下文
     * @param scheme  路由scheme
     * @param path    自定义路径
     * @return {@code V} 返回对应的路由规则实现类
     */
    public static <V> V invoke(Context context, String scheme, String path) {
        return RouterInternal.getInstance().invoke(context, scheme, path);
    }
}
