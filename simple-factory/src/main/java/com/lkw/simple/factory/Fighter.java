package com.lkw.simple.factory;

/**
 * 具体产品角色
 */
public class Fighter extends Weapon{

    @Override
    public void attack() {
        System.out.println("战斗机抛下了小男孩");
    }
}
