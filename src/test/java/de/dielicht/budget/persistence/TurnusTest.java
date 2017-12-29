package de.dielicht.budget.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.MonthDay;
import java.util.List;

import org.junit.Test;

public class TurnusTest
{
    @Test
    public void testTurnusPointCreation()
    {
        List<MonthDay> monthly = Turnus.monthly.createTurnusPoints();
        assertThat(monthly.size()).isEqualTo(12);
        assertThat(monthly.get(0).toString()).isEqualTo("--01-01");
    }
}
