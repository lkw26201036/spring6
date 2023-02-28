package com.lkw.client;

import com.lkw.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) {
        // 创建Map保存对象
        Map<String, Object> beanMap = new HashMap<>();
        // 只知道一个包的名字，扫描这个包下的所有类，当这个类上有注解的时候，实例化该对象，然后放到Map集合中
        String packName = "com.lkw.bean";
        // 开始扫描程序 -- 使用正则表达式  将报名替换成 / 表示的路径
        String packagePath = packName.replaceAll("\\.", "/");
        // System.out.println(packagePath);
        // com是在类的根路径下的一个目录
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        // 获取绝对路径
        String path = url.getPath();
        System.out.println(path);
        // 获取绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {
            try {
                // System.out.println(f.getName());
                // 获取类名
                // System.out.println(f.getName().split("\\.")[0]);
                // 拼接类名
                String className = packName + "." + f.getName().split("\\.")[0];
                // System.out.println(className);
                // 通过反射机制解析注解
                Class<?> aClass = Class.forName(className);
                // 是否存在@Component注解
                if (aClass.isAnnotationPresent(Component.class)) {
                    // 获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    // 通过注解获取注解上的value属性的值,这个值就是类的id
                    String id = annotation.value();
                    // 有这个注解的都要创建对象
                    Object obj = aClass.newInstance();
                    // 将创建好的对象放入Map中
                    beanMap.put(id, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        // 程序执行完毕之后，输出Map
        System.out.println(beanMap);

    }
}
