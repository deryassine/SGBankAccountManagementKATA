package sg.bank.account.model;

import java.util.List;

public record AccountOperation(Account account, List<Operation> operations){}
