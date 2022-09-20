package sg.bank.account.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    @Test
    @DisplayName("should not be able to create an account with null amount")
    void should_not_be_able_to_create_an_account_with_null_amount() {
        assertThrows(IllegalArgumentException.class, () -> new Account(null));
    }

    @Test
    @DisplayName("should not be able to create account with negative amount")
    void should_not_be_able_to_create_account_with_negative_amount() {
        assertThrows(IllegalArgumentException.class, () -> new Account(new BigDecimal("-1")));
    }

    @Test
    @DisplayName("should return 25 balance given amount 10 and deposit 15")
    void should_return_25_balance_given_initial_amount_10_and_deposit_15() {
        // given
        Account account = new Account(new BigDecimal("10"));
        // when
        account.deposit(new BigDecimal("15"));
        // then
        assertEquals(new BigDecimal("25"), account.getBalance());
    }

    @Test
    @DisplayName("should return 25 balance given amount 10 and deposit 15")
    void should_get_80_balance_given_initial_amount_100_and_deposit_20() {
        // given
        Account account = new Account(new BigDecimal("100"));
        // when
        account.withDraw(new BigDecimal("20"));
        // then
        assertEquals(new BigDecimal("80"), account.getBalance());
    }

    @Test
    @DisplayName("should not deposit negative amounts")
    void should_not_be_able_to_deposit_negative_amounts() {
        // given
        Account account = new Account(new BigDecimal("100"));
        // then
        assertThrows(IllegalArgumentException.class, () -> account.deposit(new BigDecimal("-80")));
    }

    @Test
    @DisplayName("should withDraw negative amounts")

    void should_not_be_able_to_withDraw_negative_amounts() {
        // given
        Account account = new Account(new BigDecimal("100"));
        // then
        assertThrows(IllegalArgumentException.class, () -> account.withDraw(new BigDecimal("-80")));
    }
}