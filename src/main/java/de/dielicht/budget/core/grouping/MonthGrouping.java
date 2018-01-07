package de.dielicht.budget.core.grouping;

import java.time.Month;
import java.util.function.Function;

import de.dielicht.budget.calc.items.PaymentItem;

public class MonthGrouping implements IGroupingStrategy<Month>
{
    @Override
    public Function<PaymentItem, Month> getGroupingStrategy()
    {
        return (paymentEvent) -> paymentEvent.getValueDay().getMonth();
    }

    @Override
    public Function<PaymentItem, String> getHeaderText()
    {
        return (paymentEvent) -> paymentEvent.getText();
    }
}
