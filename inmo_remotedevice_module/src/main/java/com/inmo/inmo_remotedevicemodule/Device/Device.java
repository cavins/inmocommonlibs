package com.inmo.inmo_remotedevicemodule.Device;

import android.view.KeyEvent;

/**
 * @author lijianwen 2022.10.14
 * 远程蓝牙设备的抽象功能
 * 一般定义的键值都大于0
 * 如果有的设备没有该键值的功能，则返回-1就行
 * 如果有的设备某个按键具备长按和短按的功能，需要分开定义
 */
public abstract class Device {
    protected int KEY_DOWN = -1;
    protected int KEY_UP = -1;
    protected int KEY_NEXT = -1;
    protected int KEY_PREVIOUS = -1;
    protected int KEY_ENTER = -1;
    protected int KEY_EXIT = KeyEvent.KEYCODE_BACK;//默认是Android返回键

    public Device() {
        initKeySet();
    }

    /**
     * 初始化键值
     */
    protected abstract void initKeySet();

    /**
     * 定义返回键值
     * @return
     */
    public int getBackKey(){
        return KEY_EXIT;
    };

    /**
     * 定义确定键值
     * @return
     */
    public int getEnterKey(){
        return KEY_ENTER;
    };

    /**
     * 定义下一步键值
     * @return
     */
    public int getNextKey(){
        return KEY_NEXT;
    };

    /**
     * 定义上一步键值
     * @return
     */
    public int getPreKey() {
        return KEY_PREVIOUS;
    };

    /**
     * 定义上键值
     */
    public int getDownKey() {
        return KEY_DOWN;
    };

    /**
     * 定义下键值
     */
    public int getUpKey() {
        return KEY_UP;
    };

}
