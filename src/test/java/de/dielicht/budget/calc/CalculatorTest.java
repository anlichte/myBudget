package de.dielicht.budget.calc;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.CategoryData;
import de.dielicht.budget.model.Turnus;

public class CalculatorTest
{
    @Test
    public void testSimpleCalculation()
    {
        final CategoryData catData = new CategoryData()
            .setName("Rundfunk/Fernsehen(GEZ)")
            .setBetrag(new BigDecimal("-52.25"))
            .setInitialDate(LocalDate.of(2017, 5, 31))
            .setTurnus(Turnus.quarterly);

        final BudgetData budgetData = new BudgetData(new BigDecimal("1000.00"))
            .addCategory(catData);

        new Calculator(budgetData, LocalDate.of(2018, 1, 9), new BigDecimal("1000.00")).start(null);
    }
}
