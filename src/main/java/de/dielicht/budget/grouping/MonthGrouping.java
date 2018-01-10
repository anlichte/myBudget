package de.dielicht.budget.grouping;

import java.time.Month;
import java.util.function.Function;

import de.dielicht.budget.calc.items.BaseItem;

public class MonthGrouping implements IGroupingStrategy<Month>
{
    @Override
    public Function<BaseItem, Month> getGroupingStrategy()
    {
        return item -> item.getValueDay().getMonth();
    }
}
