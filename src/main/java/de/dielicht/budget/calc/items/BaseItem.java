package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BaseItem implements ILineItem
{
    private String text;
    private LocalDate valueDay = LocalDate.now();
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;

    public BaseItem(final String text)
    {
        super();
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }

    @Override
    public BigDecimal getAmount()
    {
        return this.amount;
    }

    public BigDecimal getTotal()
    {
        return this.total;
    }

    public BaseItem setAmount(final BigDecimal amount)
    {
        this.amount = amount;
        return this;
    }

    @Override
    public BaseItem setTotal(final BigDecimal total)
    {
        this.total = total;
        return this;
    }

    public BaseItem setText(final String text)
    {
        this.text = text;
        return this;
    }

    public LocalDate getValueDay()
    {
        return this.valueDay;
    }

    public BaseItem setValueDay(final LocalDate valueDay)
    {
        this.valueDay = valueDay;
        return this;
    }
}
