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
            return this.generateValueDates(initial, 1, 12);
        }
    },
    quarterly
    {
        @Override
        public List<LocalDate> createValueDays(final LocalDate initial)
        {
            return this.generateValueDates(initial, 3, 4);
        }
    },
    halfYearly
    {
        @Override
        public List<LocalDate> createValueDays(final LocalDate initial)
        {
            return this.generateValueDates(initial, 6, 2);
        }
    },
    annual
    {
        @Override
        public List<LocalDate> createValueDays(final LocalDate initial)
        {
            return this.generateValueDates(initial, 12, 1);
        }
    };

    abstract public List<LocalDate> createValueDays(LocalDate initial);

    public List<LocalDate> generateValueDates(final LocalDate initial, final int turnus, final int limit)
    {
        return IntStream.iterate(0, n -> n + turnus)
                        .mapToObj(n -> initial.plusMonths(n))
                        .filter(aDate -> Year.now().getValue() == aDate.getYear())
                        .limit(limit)
                        .collect(Collectors.toList());
    }

}
