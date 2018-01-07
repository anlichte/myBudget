package de.dielicht.budget.core.grouping;

import java.util.function.Function;

import de.dielicht.budget.calc.items.PaymentItem;

public class NameGrouping implements IGroupingStrategy<String>
{
    @Override
    public Function<PaymentItem, String> getGroupingStrategy()
    {
        return (paymentEvent) -> paymentEvent.getText();
    }

    @Override
    public Function<PaymentItem, String> getHeaderText()
    {
        return (paymentEvent) -> paymentEvent.getText();
    }
}
