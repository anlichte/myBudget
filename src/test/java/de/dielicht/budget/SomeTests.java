package de.dielicht.budget;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Test;

public class SomeTests
{
    @Test
    public void testDateInput()
    {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern("dd.MM.uuuu", Locale.GERMANY);
        // .withResolverStyle(ResolverStyle.STRICT);

        final LocalDate fromCustomPattern = LocalDate.parse("30.02.2016",
            dateTimeFormatter);
        assertThat(fromCustomPattern.getDayOfMonth()).isEqualTo(29);
    }
}
