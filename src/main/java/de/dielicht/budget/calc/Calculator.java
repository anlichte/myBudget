package de.dielicht.budget.calc;

import java.time.LocalDate;
import java.util.stream.Stream;

import de.dielicht.budget.model.BudgetData;

public class Calculator
{
    public Stream<PaymentEvent> createPaymentEvents(final BudgetData data, final LocalDate calculationDay)
    {
        data.getCategories().stream()
                        .filter(category -> category.isAktiv());

        return null;
    }

}
