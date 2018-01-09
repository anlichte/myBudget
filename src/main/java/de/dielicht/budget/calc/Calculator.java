package de.dielicht.budget.calc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.dielicht.budget.calc.items.BaseItem;
import de.dielicht.budget.calc.items.ILineItem;
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

        // this stream is not terminated and contains all PaymentEvents in any order and
        // not grouped
        this.eventStream = new PaymentItemStreamBuilder().createEvents(data, calculationDate);
    }

    public <T> void start(final Function<PaymentItem, T> groupingStrategy)
    {
        final ILineItem header = new BaseItem("Saldo").setTotal(this.balance).setValueDay(this.calculationDate);
        final List<ILineItem> paymentItems = this.eventStream.collect(Collectors.toList());

        final ILineItem lastItem = paymentItems.stream()
            .reduce(header, (item1, item2) -> item2.setTotal(item1.getTotal().add(item2.getAmount())));

        final ILineItem footer = new BaseItem("Saldo").setTotal(lastItem.getTotal())
            .setValueDay(this.calculationDate.with(TemporalAdjusters.lastDayOfYear()));
    }
}
