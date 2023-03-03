package com.lkw.bank.service.impl;

import com.lkw.bank.mapper.AccountMapper;
import com.lkw.bank.pojo.Account;
import com.lkw.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountImpl implements AccountService {
    // 注入AccountMapper
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }
}
