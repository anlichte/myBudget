package de.dielicht.budget.grouping;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.dielicht.budget.calc.items.BaseItem;
import de.dielicht.budget.calc.items.ItemGroup;
import de.dielicht.budget.calc.items.PaymentItem;

public class MonthGrouping
{
    public ItemGroup<ItemGroup<PaymentItem>> group(final ItemGroup<PaymentItem> input)
    {
        final Map<Month, List<PaymentItem>> byMonth = input.getItems().stream()
            .collect(Collectors.groupingBy(item -> item.getValueDay().getMonth()));

        final List<ItemGroup<PaymentItem>> view = byMonth.keySet().stream()
            .sorted()
            .map(month ->
            {
                final BaseItem header = new BaseItem(month.name());

                final BigDecimal sum = byMonth.get(month).stream()
                    .map(PaymentItem::getAmount)
                    .reduce(BigDecimal.ZERO, (amount1, amount2) -> amount1.add(amount2));

                final BaseItem footer = new BaseItem("Summe").setAmount(sum);

                return new ItemGroup<PaymentItem>(header, byMonth.get(month), footer);
            })
            .collect(Collectors.toList());

        return new ItemGroup<ItemGroup<PaymentItem>>(input.getHeader(), view, input.getFooter());
    }
}
