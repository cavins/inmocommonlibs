# CommonLibs

公用开发组件，包含手势库，手势事件过滤，戒指开发库，网络集成库，摄像头调用组件，录音组件，数据锚点组件，应用自升级组件，换肤组件，以及其他的公用开发工具

#关于设计
该组件库具备以下特点：
    1.所有子模块统一依赖，统一版本号，共同依赖根目录下的common.gradle，其中标明各模块的共同依赖库以及每个模块的单独指定库
    ...
        setDependencies = {
            extension ->
                //每个模块的共同依赖
                   ...
                extension.implementation 'androidx.constraintlayout:constraintlayout:2.0.1'
                extension.testImplementation 'junit:junit:4.+'
                extension.androidTestImplementation 'androidx.test.ext:junit:1.1.2'
                extension.androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
                extension.kapt 'com.alibaba:arouter-compiler:1.5.2'
                if (appImplementation != "common") {
                    //common做为中间层，所有的Module都要依赖
                    extension.implementation extension.project(path: ':common')
                }
                //针对每个Module单独进行依赖
                switch (appImplementation) {
                    case "app":
                        extension.implementation extension.project(path: ':common')
                        extension.implementation extension.project(path: ':inmo_tp_module')
                        break
                    case "inmo_tp_module":
                        break
                    case "common"://common组件是一个中间层，所有的组件都需要依赖此组件，公共的依赖便可放到这里
                        extension.api 'com.alibaba:arouter-api:1.5.2'//ARouter依赖
                        //datastore 存储数据，仅用于测试
                        extension.implementation "androidx.datastore:datastore-preferences:1.0.0"
                        //gson，仅用于测试
                        extension.api 'com.google.code.gson:gson:2.8.5'
                        break
                }
        }
        ...
        
   2.单独子模块可单独拆分为module依赖，也可单独编译运行，具体配置如下
        在根目录下的common.gradle中配置
            //是否允许module单独调试
            isModuleDebug = false
            moduleName = ""//单独调试module名
        比如需要单独将[inmo_remotedevice_module]单独运行调试时，可以赋值为：
            //是否允许module单独调试
            isModuleDebug = true
            moduleName = "inmo_remotedevice_module"//单独调试module名
        然后sync now即可
        其次，当子模块作为module依赖时和作为单独app运行时拥有不同的manifest文件，
        当作为module时, 编译main/AndroidManifest.xml, 反之则编译main/manifest/AndroidManifest.xml
        
   3.增加模块统一遵循的标准：
        （1）common包作为基础依赖，是可以作为给其他module依赖的共同组件，需要新增模块时，可依据为评判标准。
        （2）如需新增模块，命名需以inmo_xxx(具体能力)_module命名
         (3)新增功能或者模块必须要编写模块专属的README.md文档或在已有文档上注明
         (4)新增模块必须添加测试页面作为单独运行时的GUI
         (5)新增模块的gradle必须要依赖common.gradle且必须将属性设置为setAppOrLibDefaultConfig以确保可以作为lib也可以单独运行。
              如下配置：
              apply from: "${rootProject.rootDir}/common.gradle"
              project.ext.setAppOrLibDefaultConfig project
              
   4.代码提交标准
        （1）commit代码时的message必须以[模块]+信息说明，比如[inmo_remotedevice_module]增加了一个新设备dev2，那么commit信息可以写为
            “[inmo_remotedevice_module] 新增了对设备dev的支持”，诸如此类
