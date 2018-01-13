package de.dielicht.budget;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.dielicht.budget.calc.CalculatorTest;
import de.dielicht.budget.model.PaymentTest;
import de.dielicht.budget.persistence.JsonPersisterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
                CalculatorTest.class,
                PaymentTest.class,
                JsonPersisterTest.class
})

public class TestSuite
{
}