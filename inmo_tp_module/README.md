# inmo_tp_module
该模块是一个双TP拦截控件,帮助简化双TP处理
## 使用
###返回事件 只需在onKeyDown中调用
    Air2GestureDetector.onKeyDownBackPressed(keyCode, new Air2GestureDetector.OnBackPressedListener() {
    @Override
    public void onAirBackPressed() {
            finish();
        }
    });

###InmoAir系统手势 需在onKeyDown中调用,区分左右Tp手势 listener可为null
    Air2GestureDetector.onKeyDownAction(int keyCode, LeftTpSlipActionListener leftTpSlipActionListener, RightTpSlipActionListener rightTpSlipActionListener)

###其中回调
    后滑 onBackSlip
    前滑 onFrontSlip
    下滑 onDownSlip (右TP为onAirBackPressed)
    上滑 onUpSlip

### Air2GestureDetector手势处理 与GestureDetector使用类似,listener可为空
    air2GestureDetector = new Air2GestureDetector(Context context, OnLeftTpGestureListener onLeftTpGestureListener, OnRightTpGestureListener onRightTpGestureListener)
    然后在onTouchEvent中设置
        air2GestureDetector.onTouchEventGestureDetector(event);

###若想自己处理直接调用此方法,已区分左右TP
    Air2GestureDetector.onTouchEvent(event, new Air2GestureDetector.OnTpTouchEventListener());

##手势处理
    在dispatchTouchEvent中设置
        Air2GestureDetector.dispatchTouchEvent(ev);
    设置监听
        Air2GestureDetector.registerTouchListener(new Air2GestureDetector.OnAirTouchListener());
    其中回调
        onLeftEvent(MotionEvent ev)     左TP触摸事件
        onRightEvent(MotionEvent ev)    右TP触摸事件
