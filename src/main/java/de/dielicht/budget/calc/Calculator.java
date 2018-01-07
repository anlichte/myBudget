package de.dielicht.budget.calc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.dielicht.budget.model.BudgetData;

public class Calculator
{
    private final BudgetData data;
    private final LocalDate calculationDate;
    private final BigDecimal balance;

    private final Stream<PaymentEvent> eventStream;

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

    public void start()
    {
        final Map<Month, List<PaymentEvent>> map = this.eventStream
                        .collect(Collectors.groupingBy(Groupings.groupByMonth));
    }
}
