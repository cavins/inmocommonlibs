package com.inmo.inmo_remotedevicemodule.Device;


/**
 * @author lijianwen 2022.10.14
 * Air1代戒指
 */
public class Air1Ring extends Device{
    public static final int KEY_SHORTCLICK1 = 290;
    public static final int KEY_SHORTCLICK2 = 291;
    public static final int KEY_LONGPRESS1 = 292;

    @Override
    protected void initKeySet() {
        KEY_ENTER = KEY_LONGPRESS1;
        KEY_NEXT = KEY_SHORTCLICK1;
        KEY_PREVIOUS = KEY_SHORTCLICK2;
    }
}
