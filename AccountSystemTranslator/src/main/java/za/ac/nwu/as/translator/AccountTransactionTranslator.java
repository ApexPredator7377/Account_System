package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAccountTransaction();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);
}