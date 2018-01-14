package de.dielicht.budget.grouping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.dielicht.budget.calc.items.BaseItem;
import de.dielicht.budget.calc.items.ItemGroup;
import de.dielicht.budget.calc.items.PaymentItem;

public class Grouping
{
    public <K> ItemGroup<ItemGroup<PaymentItem>> group(final ItemGroup<PaymentItem> input,
        final IGroupingStrategy<K> grouping)
    {
        final Map<K, List<PaymentItem>> groupedBy = input.getItems().stream()
            .collect(Collectors.groupingBy(grouping.getStrategy()));

        final List<ItemGroup<PaymentItem>> view = groupedBy.keySet().stream()
            .sorted()
            .map(key ->
            {
                final BaseItem header = new BaseItem(grouping.getText(key));

                final BigDecimal sum = groupedBy.get(key).stream()
                    .map(PaymentItem::getAmount)
                    .reduce(BigDecimal.ZERO, (amount1, amount2) -> amount1.add(amount2));

                final BaseItem footer = new BaseItem("Summe").setAmount(sum);

                return new ItemGroup<PaymentItem>(header, groupedBy.get(key), footer);
            })
            .collect(Collectors.toList());

        return new ItemGroup<ItemGroup<PaymentItem>>(input.getHeader(), view, input.getFooter());
    }

}
