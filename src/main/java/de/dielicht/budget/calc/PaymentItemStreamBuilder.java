package de.dielicht.budget.calc;

import java.time.LocalDate;
import java.util.stream.Stream;

import de.dielicht.budget.calc.items.PaymentItem;
import de.dielicht.budget.model.BudgetData;

public class PaymentEventStreamBuilder
{
    public Stream<PaymentItem> createEvents(final BudgetData data, final LocalDate calculationDay)
    {
        return data.getCategories().stream()
            .filter(category -> category.isAktiv())
            .flatMap(category -> category.generateValueDates(calculationDay)
                .map(date -> new PaymentItem(category.getName(), date, category.getBetrag())));
    }
}
