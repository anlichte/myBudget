package de.dielicht.budget.grouping;

import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.dielicht.budget.calc.items.BaseItem;
import de.dielicht.budget.calc.items.ItemGroup;

public class MonthGrouping
{
    public ItemGroup group(final ItemGroup input)
    {
        final Map<Month, List<? extends BaseItem>> byMonth = input.getItems().stream()
            .collect(Collectors.groupingBy(item -> item.getValueDay().getMonth()));

        byMonth.keySet().stream()
            .map(month ->
            {
                final LinkedList<? extends BaseItem> items = byMonth.get(month);
                items.addFirst(new BaseItem(month.name()));

                return items;
            });

        return input;
    }
}
