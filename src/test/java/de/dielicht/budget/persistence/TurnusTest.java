package de.dielicht.budget.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.MonthDay;
import java.util.List;

import org.junit.Test;

public class TurnusTest
{
    @Test
    public void testCreation()
    {
        List<MonthDay> list = Turnus.monthly.createValueDays(MonthDay.of(5, 31));
        assertThat(list.size()).isEqualTo(12);
        assertThat(list.toString()).isEqualTo(
                "[--01-31, --02-28, --03-31, --04-30, --05-31, --06-30, --07-31, --08-31, --09-30, --10-31, --11-30, --12-31]");
    }
}
