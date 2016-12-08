package org.loader.utilslib;

import android.widget.Toast;

/**
 * Toast辅助类
 *
 * @author liyunlong
 * @date 2016/12/8 10:10
 */
public class ToastHelper {

    private static Toast sToast;

    public static void showToast(CharSequence text) {
        if (sToast == null) {
            sToast = Toast.makeText(Application.get(), text, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(text);
        }
        sToast.show();
    }
}
