# audio
该模块是录音工具库
## 使用
在Application或Activity的onCreate()方法中，传入context
    IdealRecorder.getInstance().init(this);


    idealRecorder = IdealRecorder.getInstance();

    idealRecorder.setRecordFilePath(getSaveFilePath());
    //如果需要保存录音文件  设置好保存路径就会自动保存  也可以通过onRecordData 回调自己保存  不设置 不会保存录音

    IdealRecorder.RecordConfig recordConfig = new IdealRecorder.RecordConfig(MediaRecorder.AudioSource.MIC, 8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_8BIT);
    //配置
    
    idealRecorder.setRecordConfig(recordConfig).setMaxRecordTime(20000).setVolumeInterval(200);
    //设置录音配置 最长录音时长 以及音量回调的时间间隔

    idealRecorder.setStatusListener(statusListener);
    //设置录音时各种状态的监听

    idealRecorder.start();
    //开始录音
    idealRecorder.stop();
    //结束录音