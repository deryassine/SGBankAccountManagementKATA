package sg.bank.account.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.util.Objects.isNull;

public record Operation(OperationType operationType, LocalDate date,BigDecimal amount) {

    public Operation {
        if (isNull(operationType) || isNull(date) || isNull(amount)) {
            throw new IllegalArgumentException("operationType, date and amount must all be filled");
        }
    }

}
