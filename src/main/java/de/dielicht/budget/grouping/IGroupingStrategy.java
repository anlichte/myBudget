package de.dielicht.budget.grouping;

import java.util.function.Function;

import de.dielicht.budget.calc.items.BaseItem;

public interface IGroupingStrategy<T>
{
    Function<BaseItem, T> getGroupingStrategy();
}
