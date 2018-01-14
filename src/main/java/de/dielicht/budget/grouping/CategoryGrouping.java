package de.dielicht.budget.grouping;

import java.util.function.Function;

import de.dielicht.budget.calc.items.PaymentItem;

public class CategoryGrouping implements IGroupingStrategy<String>
{
    @Override
    public Function<PaymentItem, String> getStrategy()
    {
        return paymentItem -> paymentItem.getCategory();
    }

    @Override
    public String getText(final String from)
    {
        return from;
    }
}
