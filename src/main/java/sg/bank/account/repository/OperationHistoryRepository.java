package sg.bank.account.repository;


import sg.bank.account.model.Account;
import sg.bank.account.model.Operation;

import java.util.List;

public interface OperationHistoryRepository {
    List<Operation> getHistory(Account account);

    void saveOperation(Account account, Operation operation);
}