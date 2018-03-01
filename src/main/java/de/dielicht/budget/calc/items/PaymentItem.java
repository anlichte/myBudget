package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.common.base.MoreObjects.ToStringHelper;

public class PaymentItem extends BaseItem
{
    private String category = null;
    private BigDecimal amount = null;

    public PaymentItem(final String name, final String category, final LocalDate valueDay, final BigDecimal amount)
    {
        super();
        this.withCategory(category);
        this.withText(name);
        this.withAmount(amount);
        this.withValueDay(valueDay);
    }

    public PaymentItem(final BigDecimal total)
    {
        super();
        this.withTotal(total);
    }

    public BigDecimal getAmount()
    {
        return this.amount;
    }

    public String getCategory()
    {
        return this.category;
    }

    public PaymentItem withCategory(final String category)
    {
        this.category = category;
        return this;
    }

    public BaseItem withAmount(final BigDecimal amount)
    {
        this.amount = amount;
        return this;
    }

    @Override
    protected ToStringHelper toStringHelper()
    {
        return super.toStringHelper()
            .add("category", this.getCategory())
            .add("amount", this.getAmount());
    }
}
