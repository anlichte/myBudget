package de.dielicht.budget.calc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.dielicht.budget.calc.items.PaymentItem;
import de.dielicht.budget.model.BudgetData;

public class Calculator
{
    private final BudgetData data;
    private final LocalDate calculationDate;
    private final BigDecimal balance;

    private final Stream<PaymentItem> eventStream;

    public Calculator(final BudgetData data, final LocalDate calculationDate, final BigDecimal balance)
    {
        super();
        this.data = data;
        this.calculationDate = calculationDate;
        this.balance = balance;

        // this stream is not terminated and contains all PaymentEvents in any order and
        // not grouped
        this.eventStream = new PaymentEventStreamBuilder().createEvents(data, calculationDate);
    }

    public <T> void start(final Function<PaymentItem, T> groupingStrategy)
    {
        final Map<T, List<PaymentItem>> map = this.eventStream
                        .collect(Collectors.groupingBy(groupingStrategy));
    }
}
