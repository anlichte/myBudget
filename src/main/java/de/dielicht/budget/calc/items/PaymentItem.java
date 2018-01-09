package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentItem extends BaseItem
{
    public PaymentItem(final String text, final LocalDate valueDay, final BigDecimal amount)
    {
        super(text);
        this.setAmount(amount);
        this.setValueDay(valueDay);
    }
}
