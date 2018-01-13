package de.dielicht.budget.calc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.dielicht.budget.calc.items.BaseItem;
import de.dielicht.budget.calc.items.ItemGroup;
import de.dielicht.budget.calc.items.PaymentItem;
import de.dielicht.budget.model.BudgetData;

public class Calculator
{
    private final LocalDate calculationDate;
    private final BigDecimal balance;

    private final Stream<PaymentItem> eventStream;

    public Calculator(final BudgetData data, final LocalDate calculationDate, final BigDecimal balance)
    {
        super();
        this.calculationDate = calculationDate;
        this.balance = balance;

        // this stream is not terminated and contains all payment items in order but not
        // grouped
        this.eventStream = new PaymentItemStreamBuilder().createEvents(data, calculationDate)
            .sorted((item1, item2) -> item1.getValueDay().compareTo(item2.getValueDay()));
    }

    public ItemGroup<PaymentItem> calculate()
    {
        final BaseItem header = new BaseItem("Saldo").setTotal(this.balance).setValueDay(this.calculationDate);
        final List<PaymentItem> paymentItems = this.eventStream.collect(Collectors.toList());

        final BaseItem lastItem = paymentItems.stream()
            // to fulfill the type requirements at reduce
            .map(in -> (BaseItem) in)
            // now we can use the 2 args reduce func and not that with 3 args
            .reduce(header, (item1, item2) -> item2.setTotal(item1.getTotal().add(item2.getAmount())));

        final BaseItem footer = new BaseItem("Saldo").setTotal(lastItem.getTotal())
            .setValueDay(this.calculationDate.with(TemporalAdjusters.lastDayOfYear()));

        return new ItemGroup<PaymentItem>(header, paymentItems, footer);
    }
}
