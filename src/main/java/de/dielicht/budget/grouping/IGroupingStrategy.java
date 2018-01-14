package de.dielicht.budget.grouping;

import java.util.function.Function;

import de.dielicht.budget.calc.items.PaymentItem;

public interface IGroupingStrategy<K>
{
    Function<PaymentItem, K> getStrategy();

    String getText(K from);
}
