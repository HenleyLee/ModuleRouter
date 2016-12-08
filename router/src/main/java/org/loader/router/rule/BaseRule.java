package org.loader.router.rule;

import java.util.HashMap;

/**
 * 路由规则基类(抽象类)
 */
public abstract class BaseRule<T, V> implements Rule<T, V> {

    /**
     * 路由Map(scheme+path->路由Class)
     */
    private HashMap<String, Class<T>> mRouterMap = new HashMap<>();

    @Override
    public void router(String scheme, String path, Class<T> cls) {
        String pattern = getPattern(scheme, path);
        mRouterMap.put(pattern, cls);
    }

    /**
     * 当找不到路由规则时抛出异常
     *
     * @param scheme 路由scheme
     * @param path   自定义路径
     */
    public abstract void throwException(String scheme, String path);

    /**
     * 返回路由Class对象
     *
     * @param scheme 路由scheme
     * @param path   自定义路径
     * @return 返回路由Class对象
     */
    protected Class<T> getClass(String scheme, String path) {
        String pattern = getPattern(scheme, path);
        Class<T> cls = mRouterMap.get(pattern);
        if (cls == null) {
            throwException(scheme, path);
        }
        return cls;
    }

    /**
     * 返回pattern
     *
     * @param scheme 路由scheme
     * @param path   自定义路径
     * @return 路由Map中存放路由Class的Key
     */
    private String getPattern(String scheme, String path) {
        return scheme + path;
    }
}
