package com.inmo.inmo_remotedevicemodule.Device;

import android.view.KeyEvent;

/**
 * @author lijianwen 2022.10.14
 */
public class Air1Ring extends Device{
    public static final int KEY_SHORTCLICK1 = 290;
    public static final int KEY_SHORTCLICK2 = 291;
    public static final int KEY_LONGPRESS1 = 292;
    public static final int KEY_EXIT = KeyEvent.KEYCODE_BACK;

    @Override
    public int getBackKey() {
        return KEY_EXIT;
    }

    @Override
    public int getEnterKey() {
        return KEY_LONGPRESS1;
    }

    @Override
    public int getNextKey() {
        return KEY_SHORTCLICK1;
    }

    @Override
    public int getPreKey() {
        return KEY_SHORTCLICK2;
    }
}
