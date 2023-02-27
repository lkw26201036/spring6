package com.lkw.simple.factory;

/**
 * 工厂类角色
 */
public class WeaponFactory {

    /**
     * 静态方法,要获取什么产品，就传什么参数
     * 简单工厂模式中有一个静态方法，所以被称为静态工厂方法模式
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType){
        if("tank".equals(weaponType)){
            return new Tank();
        }else if("fighter".equals(weaponType)){
            return new Fighter();
        }else if("dagger".equals(weaponType)){
            return new Dagger();
        }else {
            throw new RuntimeException("没有你要生产的武器");
        }
    }
}
