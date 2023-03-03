package com.lkw.bank.pojo;

public class Account {
    private Integer actno;
    private Double balance;

    public Account(Integer actno, Double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public void setActno(Integer actno) {
        this.actno = actno;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getActno() {
        return actno;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno=" + actno +
                ", balance=" + balance +
                '}';
    }
}
