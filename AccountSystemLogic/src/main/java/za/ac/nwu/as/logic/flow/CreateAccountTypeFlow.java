package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTypeDto;

import java.util.List;

public interface CreateAccountTypeFlow {

    AccountTypeDto create(AccountTypeDto accountType);
}