package de.dielicht.budget.calc.items;

import java.math.BigDecimal;

public class BaseItem implements ILineItem
{
    private String text;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;

    public BaseItem(final String text)
    {
        super();
        this.text = text;
    }

    @Override
    public String getText()
    {
        return this.text;
    }

    @Override
    public BigDecimal getAmount()
    {
        return this.amount;
    }

    @Override
    public BigDecimal getTotal()
    {
        return this.total;
    }

    public BaseItem setAmount(final BigDecimal amount)
    {
        this.amount = amount;
        return this;
    }

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

}
