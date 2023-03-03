package com.lkw.bank.pojo;

public class Account {
    private Integer actNo;
    private Double balance;

    public Integer getActNo() {
        return actNo;
    }

    public void setActNo(Integer actNo) {
        this.actNo = actNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actNo=" + actNo +
                ", balance=" + balance +
                '}';
    }
}
