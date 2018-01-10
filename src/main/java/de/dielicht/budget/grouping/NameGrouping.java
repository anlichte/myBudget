package de.dielicht.budget.grouping;

import java.util.function.Function;

import de.dielicht.budget.calc.items.BaseItem;

public class NameGrouping implements IGroupingStrategy<String>
{
    @Override
    public Function<BaseItem, String> getGroupingStrategy()
    {
        return item -> item.getText();
    }
}
