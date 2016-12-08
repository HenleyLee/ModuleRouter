package org.loader.router.exception;

/**
 * 自定义Receiver异常
 */
public class ReceiverNotRouteException extends NotRouteException {

    public ReceiverNotRouteException(String scheme, String path) {
        super("Receiver", scheme, path);
    }
}
