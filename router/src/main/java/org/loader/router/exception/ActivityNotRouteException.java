package org.loader.router.exception;

/**
 * 自定义Activity异常
 */
public class ActivityNotRouteException extends NotRouteException {


    public ActivityNotRouteException(String scheme, String path) {
        super("Activity", scheme, path);
    }
}
