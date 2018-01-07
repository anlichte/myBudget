package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentItem extends BaseItem
{
    private LocalDate valueDay = LocalDate.now();

    public PaymentItem(final String text, final LocalDate valueDay, final BigDecimal amount)
    {
        super(text);
        this.setAmount(amount);
        this.setValueDay(valueDay);
    }

    public LocalDate getValueDay()
    {
        return this.valueDay;
    }

    public PaymentItem setValueDay(final LocalDate valueDay)
    {
        this.valueDay = valueDay;
        return this;
    }
}
