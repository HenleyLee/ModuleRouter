package org.loader.router.rule.intent;

import android.content.BroadcastReceiver;

import org.loader.router.exception.ReceiverNotRouteException;

/**
 * {@link BroadcastReceiver}路由规则实现类
 */
public class ReceiverRule extends BaseIntentRule<BroadcastReceiver> {

    /**
     * Receiver路由scheme
     */
    public static final String SCHEME_RECEIVER = "receiver://";

    @Override
    public void throwException(String scheme, String path) {
        throw new ReceiverNotRouteException(scheme, path);
    }
}
