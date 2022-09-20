package sg.bank.account.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import sg.bank.account.model.Account;
import sg.bank.account.model.AccountOperation;
import sg.bank.account.model.Operation;
import static sg.bank.account.model.OperationType.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.util.Arrays.asList;


class AccountTransactionsDisplayerTest {
    @Test
    @DisplayName("Should format transactions")
    void format() {
        AccountTransactionsDisplayer accountTransactionsDisplayer = new AccountTransactionsDisplayer();
        ArrayList<Operation> operations = new ArrayList<>(
                asList(
                        new Operation(WITHDRAW, LocalDate.of(2022, 9, 17), new BigDecimal("35.70")),
                        new Operation(DEPOSIT, LocalDate.of(2022, 9, 18), new BigDecimal("70.80")),
                        new Operation(WITHDRAW, LocalDate.of(2022, 9, 19), new BigDecimal("18.10")),
                        new Operation(WITHDRAW, LocalDate.of(2022, 9, 20), new BigDecimal("52.55"))
                ));
        String format = accountTransactionsDisplayer.format(new AccountOperation(new Account(new BigDecimal("17.17")), operations));
        Assertions.assertEquals(format,
                "2022-09-17 - WITHDRAW - 35.70" + System.lineSeparator() +
                        "2022-09-18 - DEPOSIT - 70.80" + System.lineSeparator() +
                        "2022-09-19 - WITHDRAW - 18.10" + System.lineSeparator() +
                        "2022-09-20 - WITHDRAW - 52.55" + System.lineSeparator() +
                        "Balance 17.17");
    }
}