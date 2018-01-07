package de.dielicht.budget.core.grouping;

import java.util.function.Function;

import de.dielicht.budget.calc.items.PaymentItem;

public interface IGroupingStrategy<T>
{
    Function<PaymentItem, T> getGroupingStrategy();

    Function<PaymentItem, String> getHeaderText();

    default String getFooterText()
    {
        return "Summe";
    }
}
