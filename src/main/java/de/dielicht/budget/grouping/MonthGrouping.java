package de.dielicht.budget.grouping;

import java.time.Month;
import java.util.function.Function;

import de.dielicht.budget.calc.items.PaymentItem;

public class MonthGrouping implements IGroupingStrategy<Month>
{
    @Override
    public Function<PaymentItem, Month> getStrategy()
    {
        return item -> item.getValueDay().getMonth();
    }

    @Override
    public String getText(final Month from)
    {
        return from.name();
    }
}
