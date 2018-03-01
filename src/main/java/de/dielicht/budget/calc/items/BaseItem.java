package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

public class BaseItem
{
    private String text;
    private LocalDate valueDay = null;
    private BigDecimal total = null;

    public BaseItem()
    {
        super();
    }

    public String getText()
    {
        return this.text;
    }

    public BigDecimal getTotal()
    {
        return this.total;
    }

    public LocalDate getValueDay()
    {
        return this.valueDay;
    }

    public BaseItem withTotal(final BigDecimal total)
    {
        this.total = total;
        return this;
    }

    public BaseItem withText(final String text)
    {
        this.text = text;
        return this;
    }

    public BaseItem withValueDay(final LocalDate valueDay)
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
            .add("total", this.getTotal());
    }

    @Override
    public String toString()
    {
        return this.toStringHelper().toString();
    }
}
