package de.dielicht.budget.model;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Turnus
{
    monthly
    {
        @Override
        public List<LocalDate> createValueDays(final LocalDate initial)
        {
            return this.generateValueDates(initial, 1);
        }
    },
    quarterly
    {
        @Override
        public List<LocalDate> createValueDays(final LocalDate initial)
        {
            return this.generateValueDates(initial, 3);
        }
    },
    halfYearly
    {
        @Override
        public List<LocalDate> createValueDays(final LocalDate initial)
        {
            return this.generateValueDates(initial, 6);
        }
    },
    annual
    {
        @Override
        public List<LocalDate> createValueDays(final LocalDate initial)
        {
            return this.generateValueDates(initial, 12);
        }
    };

    abstract public List<LocalDate> createValueDays(LocalDate initial);

    public List<LocalDate> generateValueDates(final LocalDate initial, final int turnus)
    {
        final int currentYear = Year.now().getValue();

        return IntStream.iterate(0, n -> n + turnus)
                        .mapToObj(n -> initial.plusMonths(n))
                        .filter(aDate -> aDate.getYear() >= currentYear)
                        .limit(12)
                        .filter(aDate -> aDate.getYear() == currentYear)
                        .collect(Collectors.toList());
    }

}
