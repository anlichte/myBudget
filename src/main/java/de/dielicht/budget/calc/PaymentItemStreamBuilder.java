package de.dielicht.budget.calc;

import java.time.LocalDate;
import java.util.stream.Stream;

import de.dielicht.budget.calc.items.PaymentItem;
import de.dielicht.budget.model.BudgetData;

public class PaymentItemStreamBuilder
{
    public Stream<PaymentItem> createEvents(final BudgetData data, final LocalDate calculationDay)
    {
        return data.getPayments().stream()
            .filter(payments -> payments.isAktiv())
            .flatMap(payments -> payments.generateValueDates(calculationDay)
                .map(date -> new PaymentItem(payments.getName(), payments.getCategory(), date, payments.getBetrag())));
    }
}
