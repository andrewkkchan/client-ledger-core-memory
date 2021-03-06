package com.industrieit.ledger.clientledger.core.memory.service.impl;

import com.industrieit.ledger.clientledger.core.memory.entity.Account;
import com.industrieit.ledger.clientledger.core.memory.exception.InvalidBusinessRuleException;
import com.industrieit.ledger.clientledger.core.memory.model.request.impl.CreateAccountRequest;
import com.industrieit.ledger.clientledger.core.memory.repository.AccountRepository;
import com.industrieit.ledger.clientledger.core.memory.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Account createAccount(CreateAccountRequest createAccountRequest) {
        if (accountRepository.existsById(createAccountRequest.getId())) {
            throw new InvalidBusinessRuleException("Account already existed");
        }
        Account account = new Account();
        account.setId(createAccountRequest.getId());
        account.setCurrency(createAccountRequest.getCurrency());
        account.setAccountGroup(createAccountRequest.getAccountGroup());
        account.setAccountName(createAccountRequest.getAccountName());
        account.setBalance(BigDecimal.ZERO);
        Account save = accountRepository.save(account);

        return save;
    }
}
