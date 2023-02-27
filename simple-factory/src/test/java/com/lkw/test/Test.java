package com.lkw.test;

import com.lkw.simple.factory.Weapon;
import com.lkw.simple.factory.WeaponFactory;

/**
 * 客户端程序
 */
public class Test {
    public static void main(String[] args) {
        // 需要tank
        Weapon tank = WeaponFactory.get("tank");
        tank.attack();
        // 需要战斗机
        Weapon fighter = WeaponFactory.get("fighter");
        fighter.attack();
        // 需要匕首
        Weapon dagger = WeaponFactory.get("dagger");
        dagger.attack();
        // 简单工厂模式达到职责分离，客户端不需要关心产品的生产细节
        // 客户端只负责消费，工厂类负责生产，一个负责生产，一个负责消费，生产者和消费者分离了，这就是简单工厂模式的作用

    }
}
