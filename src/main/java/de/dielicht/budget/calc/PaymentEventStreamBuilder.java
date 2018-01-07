package de.dielicht.budget.calc;

import java.time.LocalDate;
import java.util.stream.Stream;

import de.dielicht.budget.calc.items.PaymentItem;
import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.CategoryData;

public class PaymentEventStreamBuilder
{
    private Stream<PaymentItem> streamFrom(final CategoryData categoryData, final LocalDate calculationDay)
    {
        return categoryData.generateValueDates(calculationDay)
                        .map(date -> new PaymentItem(categoryData.getName(), date, categoryData.getBetrag()));
    }

    public Stream<PaymentItem> createEvents(final BudgetData data, final LocalDate calculationDay)
    {
        return data.getCategories().stream()
                        .filter(category -> category.isAktiv())
                        .flatMap(category -> this.streamFrom(category, calculationDay));
    }
}
