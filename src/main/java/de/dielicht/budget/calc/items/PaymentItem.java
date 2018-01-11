package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentItem extends BaseItem
{
    private final String category;

    public PaymentItem(final String text, final String category, final LocalDate valueDay, final BigDecimal amount)
    {
        super(text);
        this.category = category;
        this.setAmount(amount);
        this.setValueDay(valueDay);
    }

    public String getCategory()
    {
        return this.category;
    }
}
