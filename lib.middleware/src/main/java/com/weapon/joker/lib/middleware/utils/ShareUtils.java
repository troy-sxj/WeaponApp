package com.weapon.joker.lib.middleware.utils;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import java.util.ArrayList;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.weapon.joker.lib.middleware.utils.ShareUtils
 *     e-mail : 1012126908@qq.com
 *     time   : 2017/09/25
 *     desc   : 分享工具
 * </pre>
 */

public class ShareUtils {

    private static ShareUtils sInstance;
    private Tencent mTencent;
    private Activity mActivity;
    private final static String APP_ID = "101426105";

    public static ShareUtils getInstance(Activity activity) {

        if (sInstance == null) {
            synchronized (ShareUtils.class) {
                if (sInstance == null) {
                    sInstance = new ShareUtils(activity);
                }
            }
        }

        return sInstance;
    }

    private ShareUtils(Activity activity) {
        this.mActivity = activity;
        mTencent = Tencent.createInstance(APP_ID, activity.getApplicationContext());
    }

    public void shareToQZone() {
        Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "Hi~ this is weaponApp!");
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "Welcome to the WeaponApp!");
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "https://github.com/G-Joker/WeaponApp");
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, new ArrayList<String>());
//        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "WeaponApp");
//        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);
        mTencent.shareToQzone(mActivity, params, new IUiListener() {
            @Override
            public void onComplete(Object o) {
                JLog.i("shareTo-->" + "onComplete:\t" + o.toString());
            }

            @Override
            public void onError(UiError uiError) {
                JLog.i("shareTo-->" + "UiError:\t" + uiError.errorMessage);
            }

            @Override
            public void onCancel() {
                JLog.i("shareTo--->" + "onCancel");
            }
        });
    }

    public void shareToQQ() {
        Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "Hi~ this is weaponApp!");
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "Welcome to the WeaponApp!");
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "https://github.com/G-Joker/WeaponApp");
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "https://avatars2.githubusercontent.com/u/31761754?v=4&s=200.png");
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "WeaponApp");
//        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);
        mTencent.shareToQQ(mActivity, params, new IUiListener() {
            @Override
            public void onComplete(Object o) {
                JLog.i("shareTo-->" + "onComplete:\t" + o.toString());
            }

            @Override
            public void onError(UiError uiError) {
                JLog.i("shareTo-->" + "UiError:\t" + uiError.errorMessage);
            }

            @Override
            public void onCancel() {
                JLog.i("shareTo--->" + "onCancel");
            }
        });
    }


}
