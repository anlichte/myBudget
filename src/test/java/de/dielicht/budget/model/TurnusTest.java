package de.dielicht.budget.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class TurnusTest
{
    @Test
    public void testCreation()
    {
        List<LocalDate> list = Turnus.monthly.createValueDays(LocalDate.of(2010, 5, 31));
        assertThat(list.size()).isEqualTo(12);
        assertThat(list.toString()).isEqualTo(
                        "[2018-01-31, 2018-02-28, 2018-03-31, 2018-04-30, 2018-05-31, 2018-06-30, 2018-07-31, 2018-08-31, 2018-09-30, 2018-10-31, 2018-11-30, 2018-12-31]");

        list = Turnus.quarterly.createValueDays(LocalDate.of(2010, 5, 31));
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.toString()).isEqualTo(
                        "[2018-02-28, 2018-05-31, 2018-08-31, 2018-11-30]");

        list = Turnus.quarterly.createValueDays(LocalDate.of(2018, 5, 31));
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.toString()).isEqualTo(
                        "[2018-05-31, 2018-08-31, 2018-11-30]");

        list = Turnus.quarterly.createValueDays(LocalDate.of(2018, 12, 31));
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo(
                        "[2018-12-31]");

        list = Turnus.halfYearly.createValueDays(LocalDate.of(2010, 5, 31));
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.toString()).isEqualTo(
                        "[2018-05-31, 2018-11-30]");

        list = Turnus.annual.createValueDays(LocalDate.of(2010, 5, 31));
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo(
                        "[2018-05-31]");
    }
}
