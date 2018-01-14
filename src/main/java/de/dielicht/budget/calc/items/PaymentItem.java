package de.dielicht.budget.calc.items;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.common.base.MoreObjects.ToStringHelper;

public class PaymentItem extends BaseItem
{
    private final String category;

    public PaymentItem(final String name, final String category, final LocalDate valueDay, final BigDecimal amount)
    {
        super(name);
        this.category = category;
        this.setAmount(amount);
        this.setValueDay(valueDay);
    }

    public String getCategory()
    {
        return this.category;
    }

    @Override
    protected ToStringHelper toStringHelper()
    {
        return super.toStringHelper()
            .add("category", this.getCategory());
    }
}
