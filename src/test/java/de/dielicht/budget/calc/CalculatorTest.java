package de.dielicht.budget.calc;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import de.dielicht.budget.TestData;
import de.dielicht.budget.calc.items.ItemGroup;
import de.dielicht.budget.calc.items.PaymentItem;
import de.dielicht.budget.grouping.Grouping;
import de.dielicht.budget.grouping.NameGrouping;

public class CalculatorTest
{
    @Test
    public void testCalculation()
    {
        final ItemGroup<PaymentItem> result = new Calculator(TestData.create(), LocalDate.of(2018, 1, 9),
            new BigDecimal("0.00"))
                .calculate();
        final ItemGroup<ItemGroup<PaymentItem>> view = new Grouping().group(result, new NameGrouping());
        System.out.println(view);

        assertThat(result.getFooter().getTotal()).isEqualTo(new BigDecimal("1050.00"));
    }
}
