package za.ac.nwu.as.translator.impl;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.as.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public List<AccountTransactionDto> getAccountTransaction() {

        List<AccountTransactionDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountTransaction accountTransaction : accountTransactionRepository.findAll()) {
                accountTypeDtos.add(new AccountTransactionDto(accountTransaction));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return accountTypeDtos;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTypeDto) {
        try {
            AccountTransaction accountTransaction = accountTransactionRepository.save(accountTypeDto.getAccountTransaction());
            return new AccountTransactionDto(accountTransaction);
        } catch (Exception e) {
          throw new RuntimeException("Unable to save to the DB",e);
        }
    }
}