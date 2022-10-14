package com.inmo.inmo_remotedevicemodule.test;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.inmo.inmo_remotedevicemodule.R;
import com.inmo.inmo_remotedevicemodule.decorate.RemoteConctrlActivity;

/**
 * @author lijianwen
 * 测试代码逻辑的GUI
 */
public class TestRemoteCtrlActivity extends RemoteConctrlActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testremotectrl);

        setNotifyMode(MotionEvent.ACTION_DOWN);
    }

    public void testInputKey(View view) {
        switch (view.getId()) {
            case R.id.backBt:
                onKeyDown(4, new KeyEvent(MotionEvent.ACTION_DOWN, 4));
                break;
            case R.id.centerBt:
                onKeyDown(292, new KeyEvent(MotionEvent.ACTION_DOWN, 292));
                break;
            case R.id.nextBt:
                onKeyDown(290, new KeyEvent(MotionEvent.ACTION_DOWN, 290));
                break;
            case R.id.previousBt:
                onKeyDown(291, new KeyEvent(MotionEvent.ACTION_DOWN, 291));
                break;
        }
    }

    @Override
    protected void onControllerBackEvent() {
        super.onControllerBackEvent();
        Toast.makeText(TestRemoteCtrlActivity.this, "onControllerBackEvent", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onControllerEnterEvent() {
        super.onControllerEnterEvent();
        Toast.makeText(TestRemoteCtrlActivity.this, "onControllerEnterEvent", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onControllerNextEvent() {
        super.onControllerNextEvent();
        Toast.makeText(TestRemoteCtrlActivity.this, "onControllerNextEvent", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onControllerPreEvent() {
        super.onControllerPreEvent();
        Toast.makeText(TestRemoteCtrlActivity.this, "onControllerPreEvent", Toast.LENGTH_SHORT).show();

    }
}
