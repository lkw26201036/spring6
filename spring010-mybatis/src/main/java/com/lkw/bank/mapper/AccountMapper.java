package com.lkw.bank.mapper;

import com.lkw.bank.pojo.Account;

import java.util.List;

public interface AccountMapper {
    /**
     * 查询所有数据
     * @return
     */
    List<Account> selectAll();
}
