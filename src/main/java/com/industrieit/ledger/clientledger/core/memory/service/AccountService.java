package com.industrieit.ledger.clientledger.core.memory.service;

import com.industrieit.ledger.clientledger.core.memory.model.request.impl.CreateAccountRequest;
import com.industrieit.ledger.clientledger.core.memory.entity.Account;

/**
 * Serializable isolated transactional service to mutate {@link Account}
 */
public interface AccountService {
    /**
     * Create an {@link Account} in serialized isolated transaction
     * @param createAccountRequest all the info needed for creating {@link Account}
     * @return {@link Account} successfully created
     */
    Account createAccount(CreateAccountRequest createAccountRequest);

}
