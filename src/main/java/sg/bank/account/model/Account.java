package sg.bank.account.model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account(BigDecimal amount) {
        validateAmount(amount, "Amount must be greater than zero");
        this.balance = amount;
    }

    public BigDecimal deposit(BigDecimal amount) {
        validateAmount(amount, "Deposit amount muster be greater than zero");
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public BigDecimal withDraw(BigDecimal amount) {
        validateAmount(amount, "WithDraw amount muster be greater than zero");
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    private void validateAmount(BigDecimal amount, String message) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
