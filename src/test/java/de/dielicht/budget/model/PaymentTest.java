package de.dielicht.budget.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class PaymentTest
{
    @Test
    public void testGenerateValueDates()
    {
        final Payment categoryData = new Payment()
                        .setInitialDate(LocalDate.of(2017, 5, 31))
                        .setTurnus(Turnus.monthly);

        List<LocalDate> list = categoryData
                        .generateValueDates(LocalDate.of(2018, 1, 12))
                        .collect(Collectors.toList());
        assertThat(list.size()).isEqualTo(12);
        assertThat(list.toString()).isEqualTo(
                        "[2018-01-31, 2018-02-28, 2018-03-31, 2018-04-30, 2018-05-31, 2018-06-30, 2018-07-31, 2018-08-31, 2018-09-30, 2018-10-31, 2018-11-30, 2018-12-31]");

        list = categoryData
                        .setTurnus(Turnus.quarterly)
                        .generateValueDates(LocalDate.of(2018, 1, 12))
                        .collect(Collectors.toList());
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.toString()).isEqualTo("[2018-02-28, 2018-05-31, 2018-08-31, 2018-11-30]");

        list = categoryData
                        .setInitialDate(LocalDate.of(2018, 5, 31))
                        .generateValueDates(LocalDate.of(2018, 1, 12))
                        .collect(Collectors.toList());
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.toString()).isEqualTo("[2018-05-31, 2018-08-31, 2018-11-30]");

        list = categoryData
                        .setInitialDate(LocalDate.of(2017, 5, 31))
                        .generateValueDates(LocalDate.of(2018, 6, 1))
                        .collect(Collectors.toList());
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.toString()).isEqualTo("[2018-08-31, 2018-11-30]");

        list = categoryData
                        .setInitialDate(LocalDate.of(2018, 12, 31))
                        .generateValueDates(LocalDate.of(2018, 1, 12))
                        .collect(Collectors.toList());
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo("[2018-12-31]");

        list = categoryData
                        .setInitialDate(LocalDate.of(2017, 5, 31))
                        .setTurnus(Turnus.halfYearly)
                        .generateValueDates(LocalDate.of(2018, 1, 12))
                        .collect(Collectors.toList());
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.toString()).isEqualTo(
                        "[2018-05-31, 2018-11-30]");

        list = categoryData
                        .setTurnus(Turnus.annual)
                        .generateValueDates(LocalDate.of(2018, 1, 12))
                        .collect(Collectors.toList());
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo("[2018-05-31]");
    }
}
