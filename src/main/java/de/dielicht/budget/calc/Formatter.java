package de.dielicht.budget.calc;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import de.dielicht.budget.calc.items.BaseItem;
import de.dielicht.budget.calc.items.ItemGroup;

public class Formatter
{
    public <T> ItemGroup group(final ItemGroup input, final Function<BaseItem, T> groupingStrategy)
    {
        final Map<T, List<BaseItem>> groupings = input.getItems().stream()
            .collect(Collectors.groupingBy(groupingStrategy));

        return input;
    }
}
