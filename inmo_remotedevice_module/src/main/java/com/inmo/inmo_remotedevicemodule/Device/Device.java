package com.inmo.inmo_remotedevicemodule.Device;

/**
 * @author lijianwen 2022.10.14
 * 远程蓝牙设备的抽象功能
 */
public abstract class Device {

    /**
     * 定义返回键值
     * @return
     */
    public abstract int getBackKey();

    /**
     * 定义确定键值
     * @return
     */
    public abstract int getEnterKey();

    /**
     * 定义下一步键值
     * @return
     */
    public abstract int getNextKey();

    /**
     * 定义上一步键值
     * @return
     */
    public abstract int getPreKey();

}
