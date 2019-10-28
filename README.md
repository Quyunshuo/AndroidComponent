# AndroidComponent
Android 组件化架构demo

## 项目结构

app壳工程

业务组件：main_module	me_module	other_module

功能组件：common_base

版本控制文件：config.gradle

### 依赖关系：

app壳依赖各业务组件和功能组件

业务组件各自依赖功能组件 业务组件之间不互相依赖 只被app壳所依赖

![image](https://github.com/zhengwenming/WMPlayer/blob/master/WMPlayer/Resource/WMPlayer.gif)  

