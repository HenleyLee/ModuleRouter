package org.loader.router.rule;

import android.content.Context;

/**
 * 路由规则接口
 *
 * @param <T> 路由Class泛型
 * @param <V> 路由规则实现类泛型
 */
public interface Rule<T, V> {

    /**
     * 添加路由
     *
     * @param scheme 路由scheme
     * @param path   自定义路径
     * @param cls    路由Class
     */
    void router(String scheme, String path, Class<T> cls);

    /**
     * 路由调用
     *
     * @param context 上下文
     * @param scheme  路由scheme
     * @param path    自定义路径
     * @return {@code V} 返回对应的返回值
     */
    V invoke(Context context, String scheme, String path);
}
