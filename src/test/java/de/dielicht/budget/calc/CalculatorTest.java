package de.dielicht.budget.calc;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import de.dielicht.budget.calc.items.ItemGroup;
import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.Payment;
import de.dielicht.budget.model.Turnus;

public class CalculatorTest
{
    @Test
    public void testSimpleCalculation()
    {
        final Payment catData = new Payment()
            .setName("Rundfunk/Fernsehen(GEZ)")
            .setBetrag(new BigDecimal("-52.25"))
            .setInitialDate(LocalDate.of(2017, 5, 31))
            .setTurnus(Turnus.quarterly);

        final BudgetData budgetData = new BudgetData(new BigDecimal("1000.00"))
            .addCategory(catData);

        final ItemGroup result = new Calculator(budgetData, LocalDate.of(2018, 1, 9), new BigDecimal("1000.00"))
            .calculate();
        assertThat(result.getFooter().getTotal()).isEqualTo(new BigDecimal("791.00"));
    }
}
