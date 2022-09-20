package sg.bank.account.repository;

import sg.bank.account.model.Account;

public interface AccountRepository {

    Account getAccount();

    void saveAccountBalance(Account account);
}