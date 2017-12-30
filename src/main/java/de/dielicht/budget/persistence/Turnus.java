package de.dielicht.budget.persistence;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Turnus
{
    monthly
    {
        @Override
        public List<MonthDay> createValueDays(MonthDay initial)
        {
            LocalDate initDate = initial.atYear(Year.now().getValue());
            return IntStream.rangeClosed(0, 11)
                    .mapToObj(offset -> initDate.plusMonths(offset))
                    .map(date -> MonthDay.of(date.getMonth(), date.getDayOfMonth()))
                    .sorted()
                    .collect(Collectors.toList());
        }
    },
    quarterly
    {
        @Override
        public List<MonthDay> createValueDays(MonthDay initial)
        {
            LocalDate initDate = initial.atYear(Year.now().getValue());
            return IntStream.of(0, 3, 6, 9)
                    .mapToObj(offset -> initDate.plusMonths(offset))
                    .map(date -> MonthDay.of(date.getMonth(), date.getDayOfMonth()))
                    .sorted()
                    .collect(Collectors.toList());
        }
    },
    halfYearly
    {
        @Override
        public List<MonthDay> createValueDays(MonthDay initial)
        {
            LocalDate initDate = initial.atYear(Year.now().getValue());
            return IntStream.of(0, 6)
                    .mapToObj(offset -> initDate.plusMonths(offset))
                    .map(date -> MonthDay.of(date.getMonth(), date.getDayOfMonth()))
                    .sorted()
                    .collect(Collectors.toList());
        }
    },
    annual
    {
        @Override
        public List<MonthDay> createValueDays(MonthDay initial)
        {
            return Arrays.asList(initial);
        }
    };

    abstract public List<MonthDay> createValueDays(MonthDay initial);
}
