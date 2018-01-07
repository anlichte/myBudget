package de.dielicht.budget.calc;

import java.time.Month;
import java.util.function.Function;

public class Groupings
{
    public static Function<PaymentEvent, Month> groupByMonth = (paymentEvent) -> paymentEvent.getValueDay().getMonth();
    public static Function<PaymentEvent, String> groupByCategoryName = (paymentEvent) -> paymentEvent.getCategoryName();
}
