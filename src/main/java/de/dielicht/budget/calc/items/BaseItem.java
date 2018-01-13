package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

public class BaseItem
{
    private String text;
    private LocalDate valueDay = null;
    private BigDecimal amount = null;
    private BigDecimal total = null;

    public BaseItem(final String text)
    {
        super();
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }

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

    protected ToStringHelper toStringHelper()
    {
        return MoreObjects.toStringHelper(this)
            .omitNullValues()
            .add("text", this.getText())
            .add("date", this.getValueDay())
            .add("amount", this.getAmount())
            .add("total", this.getTotal());
    }

    @Override
    public String toString()
    {
        return this.toStringHelper().toString();
    }
}
