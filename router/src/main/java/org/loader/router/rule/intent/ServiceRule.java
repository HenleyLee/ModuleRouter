package org.loader.router.rule.intent;

import android.app.Service;

import org.loader.router.exception.ServiceNotRouteException;

/**
 * {@link Service}路由规则实现类
 */
public class ServiceRule extends BaseIntentRule<Service> {

    /**
     * Service路由scheme
     */
    public static final String SCHEME_SERVICE = "service://";

    @Override
    public void throwException(String scheme, String path) {
        throw new ServiceNotRouteException(scheme, path);
    }
}
