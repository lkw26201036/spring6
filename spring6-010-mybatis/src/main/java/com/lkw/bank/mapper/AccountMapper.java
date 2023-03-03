package com.lkw.bank.mapper;

import com.lkw.bank.pojo.Account;

import java.util.List;

public interface AccountMapper {


    int insert(Account account);

    int deleteByActno(Integer actno);

    int update(Account account);

    Account selectByActno(Integer actno);

    List<Account> selectAll();
}
