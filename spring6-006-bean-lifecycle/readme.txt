bean生命周期的五步：
    第一步：实例化bean
    第二步：bean属性赋值
    第三步：初始化bean
    第四步：使用bean
    第五步：销毁bean


bean生命周期七步：
    第一步：实例化bean
    第二步：bean属性赋值
    执行“bean后处理器”的before方法
    第三步：初始化bean
    执行“bean后处理器”的after方法
    第四步：使用bean
    第五步：销毁bean

bean生命周期十步：
    点位1：在“bean后处理器”的before方法之前
    点位2：在“bean后处理器”的after方法之后
    点位3：在使用bean之后，在销毁bean之前