package com.inmo.inmo_remotedevicemodule.Device;

import android.view.KeyEvent;

/**
 * @author lijianwen 2022.10.19
 * Air2代戒指
 */
public class Air2Ring extends Device{
    @Override
    protected void initKeySet() {
        KEY_DOWN = KeyEvent.KEYCODE_DPAD_DOWN;
        KEY_UP = KeyEvent.KEYCODE_DPAD_UP;
        KEY_NEXT = KeyEvent.KEYCODE_DPAD_RIGHT;
        KEY_PREVIOUS = KeyEvent.KEYCODE_DPAD_LEFT;
        KEY_ENTER = KeyEvent.KEYCODE_DPAD_CENTER;
    }
}
