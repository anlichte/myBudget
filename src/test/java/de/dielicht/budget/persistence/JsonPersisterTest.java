package de.dielicht.budget.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import de.dielicht.budget.TestData;
import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.Turnus;

public class JsonPersisterTest
{
    @Test
    public void testWrite() throws IOException
    {
        final JsonPersister jp = new JsonPersister();

        jp.write(TestData.create());

        final BudgetData readed = jp.read();
        assertThat(readed.getMindestGuthaben()).isEqualTo(new BigDecimal("1000.00"));
        assertThat(readed.getPayment("Rundfunk/Fernsehen(GEZ)").getTurnus()).isEqualTo(Turnus.quarterly);
    }
}
