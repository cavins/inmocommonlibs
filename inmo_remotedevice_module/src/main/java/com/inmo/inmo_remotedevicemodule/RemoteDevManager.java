package com.inmo.inmo_remotedevicemodule;

import android.view.KeyEvent;
import android.view.MotionEvent;

import com.inmo.inmo_remotedevicemodule.Device.Air1Ring;
import com.inmo.inmo_remotedevicemodule.Device.Device;
import com.inmo.inmo_remotedevicemodule.Device.DeviceSupportActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijianwen 2022.10.14
 * 远程蓝牙设备控制兼容控制器
 */
public class RemoteDevManager {
    private List<Device> supportDevices;//支持的蓝牙遥控器列表
    private OnDevKeyUIEventListener listener;
    private List<Integer> backKeys;//返回键合集
    private List<Integer> enterKeys;//确定键合集
    private List<Integer> nextKeys;//下一步键合集
    private List<Integer> preKeys;//上一步键合集
    private Map<String, List> keysMap;

    private static RemoteDevManager instance;

    public static RemoteDevManager getInstance(OnDevKeyUIEventListener listener) {
        if (instance == null) {
            synchronized (RemoteDevManager.class) {
                if (instance == null) {
                    instance = new RemoteDevManager(listener);
                }
            }
        }
        return instance;
    }

    private int notifyMode = MotionEvent.ACTION_DOWN;//默认按键按下时触发

    private RemoteDevManager(OnDevKeyUIEventListener listener) {
        this.listener = listener;
        supportDevices = new ArrayList<>();
        supportDevices.add(new Air1Ring());
        loadAllKeys();
    }

    public int getNotifyMode() {
        return notifyMode;
    }

    public void setNotifyMode(int notifyMode) {
        this.notifyMode = notifyMode;
    }

    private void loadAllKeys() {
        keysMap = new HashMap<>(4);
        backKeys = new ArrayList<>();
        enterKeys = new ArrayList<>();
        nextKeys = new ArrayList<>();
        preKeys = new ArrayList<>();

        for (Device dev : supportDevices) {
            backKeys.add(dev.getBackKey());
            enterKeys.add(dev.getEnterKey());
            nextKeys.add(dev.getNextKey());
            preKeys.add(dev.getPreKey());
        }

        keysMap.put(DeviceSupportActions.ACTION_BACK, backKeys);
        keysMap.put(DeviceSupportActions.ACTION_ENTER, enterKeys);
        keysMap.put(DeviceSupportActions.ACTION_NEXT, nextKeys);
        keysMap.put(DeviceSupportActions.ACTION_PREVIOUS, preKeys);

    }

    public void inputKeyEvent(int keyCode, KeyEvent event) {
        findAllActionFromKeycode(keyCode);
    }

    private void findAllActionFromKeycode(int keyCode) {
        for (String action : keysMap.keySet()) {
            findMatchAction(action, keyCode);
        }
    }

    private void findMatchAction(String action, int keyCode) {
        final List<Integer> actionsSrc = keysMap.get(action);
        if (actionsSrc != null) {
            for (Integer actionKey : actionsSrc) {
                if (keyCode == actionKey) {
                    notifyUi(action);
                }
            }
        }
    }

    private void notifyUi(String action) {
        if (this.listener == null) {
            return;
        }
        switch (action) {
            case DeviceSupportActions.ACTION_BACK:
                listener.onBackEvent();
                break;
            case DeviceSupportActions.ACTION_ENTER:
                listener.onEnterEvent();
                break;
            case DeviceSupportActions.ACTION_NEXT:
                listener.onNextEvent();
                break;
            case DeviceSupportActions.ACTION_PREVIOUS:
                listener.onPreEvent();
                break;
        }
    }

    public interface OnDevKeyUIEventListener {
        void onBackEvent();

        void onEnterEvent();

        void onNextEvent();

        void onPreEvent();
    }
}
