package org.loader.router.exception;

/**
 * 自定义Service异常
 */
public class ServiceNotRouteException extends NotRouteException {

    public ServiceNotRouteException(String scheme, String path) {
        super("Service", scheme, path);
    }
}
