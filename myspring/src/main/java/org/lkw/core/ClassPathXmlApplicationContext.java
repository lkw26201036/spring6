package org.lkw.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    // 日志记录器
    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 根据bean的名称获取对应的bean对象
     *
     * @param beanName myspring配置文件中bean标签的id
     * @return 对应的单例bean对象
     */
    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }


    /**
     * 解析myspring的配置文件，初始化所有的bean对象
     *
     * @param configLocation myspring的配置文件的路径，注意：使用ClassPathXmlApplicationContext，配置文件应当放到类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        // 解析myspring.xml，然后实例化bean，将bean存放到map集合中
        try {
            // 这是dom解析的核心对象
            SAXReader reader = new SAXReader();
            // 获取一个输入流，指向配置文件--从类路径中加载
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // 读文件
            Document document = reader.read(in);
            // 获取文档中的所有bean标签
            List<Node> nodes = document.selectNodes("//bean");
            // 遍历bean标签
            nodes.forEach(node -> {
                try {
                    // 向下转型 --- 是因为Element接口中提供了更加丰富的方法
                    Element ele = (Element) node;
                    // 获取id属性
                    String id = ele.attributeValue("id");
                    logger.info("beanName => " + id);
                    // 获取class属性
                    String className = ele.attributeValue("class");
                    logger.info("className => " + className);
                    // 通过反射机制创建对象，将其放到Map集合中，提前曝光
                    // 获取class
                    Class<?> aClass = Class.forName(className);
                    // 获取无参数构造方法创建Bean
                    Constructor<?> defaultConstructor = aClass.getDeclaredConstructor();
                    Object bean = defaultConstructor.newInstance();
                    // 将bean曝光，存入到map集合中
                    singletonObjects.put(id, bean);
                    // 将Map打印输出
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 再次重新把所有的bean标签遍历一遍，这一次的主要目的是给对象的属性赋值
            nodes.forEach(node -> {
                try {
                    Element element = (Element) node;
                    // 获取id
                    String id = element.attributeValue("id");
                    // 获取className
                    String className = element.attributeValue("class");
                    // 获取Class
                    Class<?> aClass = Class.forName(className);
                    // 获取标签下所有的属性property标签
                    List<Element> properties = element.elements("property");
                    // 遍历所有属性标签
                    properties.forEach(property -> {
                        try {
                            // 获取属性名
                            String propertyName = property.attributeValue("name");
                            // 根据属性名获取属性对象，接着获取属性类型
                            Field field = aClass.getDeclaredField(propertyName);
                            logger.info("属性名 => " + propertyName);
                            // 获取set方法名
                            String setName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            // 获取set方法
                            Method setMethod = aClass.getDeclaredMethod(setName, field.getType());
                            // 获取property标签的属性值 -- 可能是value也可能是ref
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            // 真值
                            Object actualValue = null;
                            if (value != null) {
                                // 说明这个值是简单类型
                                // 调用set方法
                                // 获取属性类型名
                                String propertyTypeSimpleName = field.getType().getSimpleName();

                                // 根据返回的类型名进行匹配
                                switch(propertyTypeSimpleName){
                                    case "byte":
                                        actualValue = Byte.parseByte(value);
                                        break;
                                    case "short":
                                        actualValue = Short.parseShort(value);
                                        break;
                                    case "int":
                                        actualValue = Integer.parseInt(value);
                                        break;
                                    case "long":
                                        actualValue = Long.parseLong(value);
                                        break;
                                    case "float":
                                        actualValue = Float.parseFloat(value);
                                        break;
                                    case "double":
                                        actualValue = Double.parseDouble(value);
                                        break;
                                    case "boolean":
                                        actualValue = Boolean.parseBoolean(value);
                                        break;
                                    case "char":
                                        actualValue = value.charAt(0);
                                        break;
                                    case "Byte":
                                        actualValue = Byte.valueOf(value);
                                        break;
                                    case "Short":
                                        actualValue = Short.valueOf(value);
                                        break;
                                    case "Integer":
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "Long":
                                        actualValue = Long.valueOf(value);
                                        break;
                                    case "Float":
                                        actualValue = Float.valueOf(value);
                                        break;
                                    case "Double":
                                        actualValue = Double.valueOf(value);
                                        break;
                                    case "Boolean":
                                        actualValue = Boolean.valueOf(value);
                                        break;
                                    case "Character":
                                        actualValue = Character.valueOf(value.charAt(0));
                                        break;
                                    case "String":
                                        actualValue = value;
                                }
                                setMethod.invoke(singletonObjects.get(id),actualValue);
                            }
                            if (ref != null) {
                                // 说明这个值是非简单类型
                                setMethod.invoke(singletonObjects.get(id),singletonObjects.get(ref));
                            }




                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            });

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
