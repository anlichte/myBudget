package de.dielicht.budget.calc;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import de.dielicht.budget.calc.items.ItemGroup;
import de.dielicht.budget.calc.items.PaymentItem;
import de.dielicht.budget.grouping.MonthGrouping;
import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.Payment;
import de.dielicht.budget.model.Turnus;

public class CalculatorTest
{
    @Test
    public void testSimpleCalculation()
    {
        final Payment ruf = new Payment()
            .setName("Rundfunk/Fernsehen(GEZ)")
            .setCategory("Haus")
            .setBetrag(new BigDecimal("-50.00"))
            .setInitialDate(LocalDate.of(2017, 5, 31))
            .setTurnus(Turnus.quarterly);

        final Payment ver = new Payment()
            .setName("Versicherung Haus")
            .setCategory("Haus")
            .setBetrag(new BigDecimal("-250.00"))
            .setInitialDate(LocalDate.of(2017, 2, 25))
            .setTurnus(Turnus.halfYearly);

        final BudgetData budgetData = new BudgetData(new BigDecimal("1000.00"))
            .addPayment(ruf)
            .addPayment(ver);

        final ItemGroup<PaymentItem> result = new Calculator(budgetData, LocalDate.of(2018, 1, 9),
            new BigDecimal("1000.00"))
                .calculate();
        final ItemGroup<ItemGroup<PaymentItem>> view = new MonthGrouping().group(result);
        System.out.println(view);

        assertThat(result.getFooter().getTotal()).isEqualTo(new BigDecimal("300.00"));
    }
}
