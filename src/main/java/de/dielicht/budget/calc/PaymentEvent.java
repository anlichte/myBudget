package de.dielicht.budget.calc;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentEvent
{
    private String categoryName = "none";
    private LocalDate valueDay = LocalDate.now();
    private BigDecimal amount = BigDecimal.ZERO;

    public PaymentEvent(final String categoryName, final LocalDate valueDay, final BigDecimal amount)
    {
        super();
        this.categoryName = categoryName;
        this.valueDay = valueDay;
        this.amount = amount;
    }

    public String getCategoryName()
    {
        return this.categoryName;
    }

    public LocalDate getValueDay()
    {
        return this.valueDay;
    }

    public BigDecimal getAmount()
    {
        return this.amount;
    }

}
