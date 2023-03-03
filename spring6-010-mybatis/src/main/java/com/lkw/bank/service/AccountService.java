package com.lkw.bank.service;

import com.lkw.bank.pojo.Account;

import java.util.List;

public interface AccountService {
    int save(Account act);
    int deleteByActno(Integer actno);
    int update(Account act);
    Account selectByActno(Integer actno);
    List<Account> getall();
}
