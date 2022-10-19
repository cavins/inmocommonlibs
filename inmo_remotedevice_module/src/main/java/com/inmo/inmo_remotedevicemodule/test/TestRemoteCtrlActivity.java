package com.inmo.inmo_remotedevicemodule.test;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.inmo.inmo_remotedevicemodule.R;
import com.inmo.inmo_remotedevicemodule.databinding.ActivityTestremotectrlBinding;
import com.inmo.inmo_remotedevicemodule.decorate.RemoteConctrlActivity;

/**
 * @author lijianwen
 * 测试代码逻辑的GUI
 */
public class TestRemoteCtrlActivity extends RemoteConctrlActivity {
    ActivityTestremotectrlBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_testremotectrl);
        setContentView(R.layout.activity_testremotectrl);

        //设置按键按下时响应还是抬起时响应
        setNotifyMode(MotionEvent.ACTION_DOWN);
    }

    public void testInputKey(View view) {
        if (view.getId() == binding.backBt.getId()) {
            onKeyDown(4, new KeyEvent(MotionEvent.ACTION_DOWN, 4));
        } else if (view.getId() == binding.centerBt.getId()) {
            onKeyDown(292, new KeyEvent(MotionEvent.ACTION_DOWN, 292));
        } else if (view.getId() == binding.nextBt.getId()) {
            onKeyDown(290, new KeyEvent(MotionEvent.ACTION_DOWN, 290));
        } else if (view.getId() == binding.previousBt.getId()) {
            onKeyDown(291, new KeyEvent(MotionEvent.ACTION_DOWN, 291));
        } else if (view.getId() == binding.downBt.getId()) {
            onKeyDown(KeyEvent.KEYCODE_DPAD_DOWN, new KeyEvent(MotionEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_DOWN));
        } else if (view.getId() == binding.upBt.getId()) {
            onKeyDown(KeyEvent.KEYCODE_DPAD_UP, new KeyEvent(MotionEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_UP));
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

    @Override
    protected void onControllerDpadDownEvent() {
        super.onControllerDpadDownEvent();
        Toast.makeText(TestRemoteCtrlActivity.this, "onDpadDownKeyEvent", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onControllerDpadUpEvent() {
        super.onControllerDpadUpEvent();
        Toast.makeText(TestRemoteCtrlActivity.this, "onDpadUpKeyEvent", Toast.LENGTH_SHORT).show();
    }

}
