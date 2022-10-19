package com.inmo.inmo_remotedevicemodule.decorate;

import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.inmo.inmo_remotedevicemodule.RemoteDevManager;

/**
 * @author lijianwen 2022.10.14
 * 封装了远程设备如戒指等设备的activity
 * 使用了抽象类处理，UI上层可以按照需求实现单独键值，
 * 比如某个页面只需要处理返回键值，不需要处理其他键值的话，可以只实现onControllerBackEvent即可，简化代码
 */
public abstract class RemoteConctrlActivity extends AppCompatActivity implements RemoteDevManager.OnDevKeyUIEventListener {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (RemoteDevManager.getInstance(this).getNotifyMode() == MotionEvent.ACTION_DOWN) {
            getDefault().inputKeyEvent(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (getDefault().getNotifyMode() == MotionEvent.ACTION_UP) {
            getDefault().inputKeyEvent(keyCode, event);
        }
        return super.onKeyUp(keyCode, event);
    }

    public void setNotifyMode(int mode) {
        getDefault().setNotifyMode(mode);
    }

    @Override
    public void onBackEvent() {
        onControllerBackEvent();
    }

    @Override
    public void onEnterEvent() {
        onControllerEnterEvent();
    }

    @Override
    public void onNextEvent() {
        onControllerNextEvent();
    }

    @Override
    public void onPreEvent() {
        onControllerPreEvent();
    }

    @Override
    public void onDpadDownKeyEvent() {
        onControllerDpadDownEvent();
    }

    @Override
    public void onDpadUpKeyEvent() {
        onControllerDpadUpEvent();
    }

    protected void onControllerBackEvent() {
    }


    protected void onControllerEnterEvent() {
    }


    protected void onControllerNextEvent() {
    }


    protected void onControllerPreEvent() {
    }

    protected void onControllerDpadDownEvent() {

    }

    protected void onControllerDpadUpEvent() {

    }


    private RemoteDevManager getDefault() {
        return RemoteDevManager.getInstance(this);
    }
}
