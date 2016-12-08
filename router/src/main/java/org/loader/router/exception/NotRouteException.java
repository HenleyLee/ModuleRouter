package org.loader.router.exception;

/**
 * 自定义异常
 */
public class NotRouteException extends RuntimeException {

    public NotRouteException(String name, String scheme, String path) {
        super(String.format("%1$s can not be resolved with pattern %2$s%3$s, have you declared it in your Router?", name, scheme, path));
    }
}
