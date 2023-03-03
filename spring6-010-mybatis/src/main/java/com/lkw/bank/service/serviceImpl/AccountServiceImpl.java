package com.lkw.bank.service.serviceImpl;

import com.lkw.bank.mapper.AccountMapper;
import com.lkw.bank.pojo.Account;
import com.lkw.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int save(Account act) {

        return accountMapper.insert(act);
    }

    @Override
    public int deleteByActno(Integer actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int update(Account act) {
        return accountMapper.update(act);
    }

    @Override
    public Account selectByActno(Integer actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getall() {
        return accountMapper.selectAll();
    }


}
