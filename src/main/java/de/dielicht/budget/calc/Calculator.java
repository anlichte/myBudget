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

        // this stream has no terminal operation so it's not executed
        // and contains all payment items in order but not grouped
        this.eventStream = new PaymentItemStreamBuilder()
            .createEvents(data, calculationDate)
            .sorted((item1, item2) -> item1.getValueDay().compareTo(item2.getValueDay()));
    }

    public ItemGroup<PaymentItem> calculate()
    {
        final List<PaymentItem> paymentItems = this.eventStream.collect(Collectors.toList());

        // this stream has side effects: we set the total field on all payments
        final PaymentItem lastItem = paymentItems.stream()
            .reduce(new PaymentItem(this.balance),
                (item1, item2) -> (PaymentItem) item2.withTotal(item1.getTotal().add(item2.getAmount())));

        final BaseItem header = new BaseItem().withText("Saldo").withTotal(this.balance)
            .withValueDay(this.calculationDate);
        final BaseItem footer = new BaseItem().withText("Saldo").withTotal(lastItem.getTotal())
            .withValueDay(this.calculationDate.with(TemporalAdjusters.lastDayOfYear()));

        return new ItemGroup<PaymentItem>(header, paymentItems, footer);
    }
}
