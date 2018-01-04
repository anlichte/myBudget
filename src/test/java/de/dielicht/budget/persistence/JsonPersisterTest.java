package de.dielicht.budget.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.CategoryData;
import de.dielicht.budget.model.Turnus;

public class JsonPersisterTest
{
    @Test
    public void testWrite() throws IOException
    {
        final JsonPersister jp = new JsonPersister();

        final CategoryData catData = new CategoryData()
                        .setName("Rundfunk/Fernsehen(GEZ)")
                        .setBetrag(new BigDecimal("-52.25"))
                        .setInitialDate(LocalDate.of(2017, 5, 31))
                        .setTurnus(Turnus.quarterly);

        final BudgetData toWrite = new BudgetData(new BigDecimal("1000.45"))
                        .setMindestGuthaben(new BigDecimal("1000.00"))
                        .setBerechnungsDatum(LocalDate.of(2018, 12, 31))
                        .addCategory(catData);

        jp.write(toWrite);

        final BudgetData readed = jp.read();
        assertThat(readed.getKontoStand()).isEqualTo("1000.45");
        assertThat(readed.getBerechnungsDatum().toString()).isEqualTo("2018-12-31");
        assertThat(readed.getCategory("Rundfunk/Fernsehen(GEZ)").getTurnus()).isEqualTo(Turnus.quarterly);
    }
}
