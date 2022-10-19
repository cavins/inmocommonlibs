# inmo_remotedevice_module
该模块是一个远程蓝牙设备控制眼镜UI的适配器，上层应用不需要关心底层设备事件细节，只关注于UI层的业务处理就好了
## 关于模块设计
### Device类  定义了蓝牙设备的行为，具体行为对应的键值由各厂家设备或系统定义
    蓝牙设备行为目前定义了4种：1.返回 2.确定 3.下一步 4.上一步 5.键盘上键 6.键盘下键
    
    关于界面UI事件的说明解释：
    1. 返回，用于界面返回上一层
    2. 确定，确定选项
    3. 下一步，用于界面跳转到下一项或者下一页，视需求而定
    4. 上一步，用于界面跳转到上一项或者上一页，视需求而定
    5. 键盘上键，一般用于界面向上滚动或者上一页，视需求而定
    6. 键盘下键,一般用于界面向下滚动或者下一页，视需求而定
    
### RemoteDevManager类
    所有支持的远程蓝牙设备的管理类，对外接收对应蓝牙设备的指令，内部统一返回给上层业务层统一的行为接口
    支持拓展设备
### Device的扩展
    如需要新兼容一种设备，需要的做步骤为:
    1.继承Device类创建设备描述类，参考AirRing类,根据不同厂商的设备键值设定
    2.将新的设备类添加到RemoteDevManager中:
     private RemoteDevManager(OnDevKeyUIEventListener listener) {
                ...
                supportDevices.add(new Device());//添加兼容的设备
                loadAllKeys();
            }
## 如何使用模块能力？
    1.原业务如果继承actity的，直接转继承RemoteConctrlActivity，参考TestRemoteCtrlActivity实现
    2.如果原业务需要继承其他activity的，直接在原业务模块使用RemoteDevManager，自己处理事件即可，参考TestRemoteCtrlActivity实现