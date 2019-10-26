package com.quyunshuo.common_base.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * 判断当前模式是Debug模式还是release
 */
public class IsDebugUtil {

    public static boolean isDebug(Context context) {
        boolean isDebug = context.getApplicationInfo() != null &&
                (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        return isDebug;
    }
}
