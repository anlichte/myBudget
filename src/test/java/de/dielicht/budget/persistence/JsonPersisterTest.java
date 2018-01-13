package de.dielicht.budget.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.Payment;
import de.dielicht.budget.model.Turnus;

public class JsonPersisterTest
{
    @Test
    public void testWrite() throws IOException
    {
        final JsonPersister jp = new JsonPersister();

        final Payment catData = new Payment()
            .setName("Rundfunk/Fernsehen(GEZ)")
            .setCategory("Haus")
            .setBetrag(new BigDecimal("-52.25"))
            .setInitialDate(LocalDate.of(2017, 5, 31))
            .setTurnus(Turnus.quarterly);

        final BudgetData toWrite = new BudgetData(new BigDecimal("1000.45"))
            .setMindestGuthaben(new BigDecimal("1000.00"))
            .addPayment(catData);

        jp.write(toWrite);

        final BudgetData readed = jp.read();
        assertThat(readed.getMindestGuthaben()).isEqualTo(new BigDecimal("1000.00"));
        assertThat(readed.getPayment("Rundfunk/Fernsehen(GEZ)").getTurnus()).isEqualTo(Turnus.quarterly);
    }
}
