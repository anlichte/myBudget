package de.dielicht.budget.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Payment
{
    private String name;
    private String category;
    private Boolean activ = Boolean.TRUE;
    private BigDecimal amount = BigDecimal.ZERO;
    private Turnus turnus = Turnus.monthly;
    private LocalDate initialDate = LocalDate.now();

    public Payment()
    {
        super();
    }

    public Stream<LocalDate> generateValueDates(final LocalDate calculationDay)
    {
        final int currentYear = calculationDay.getYear();

        return IntStream.iterate(0, n -> n + this.turnus.getTurnusMonths())
            .mapToObj(n -> this.initialDate.plusMonths(n))
            .filter(aDate -> aDate.getYear() >= currentYear)
            // Java 8 has no dropWhile & takeUntil so this is a dirty workaround
            // there can be maximal 12 valueDays per year
            .limit(12)
            .filter(aDate -> aDate.getYear() == currentYear)
            .filter(aDate -> !aDate.isBefore(calculationDay));
    }

    public BigDecimal getBetrag()
    {
        return this.amount;
    }

    public Payment setBetrag(final BigDecimal betrag)
    {
        this.amount = betrag;
        return this;
    }

    public Boolean isAktiv()
    {
        return this.activ;
    }

    public Payment setAktiv(final Boolean aktiv)
    {
        this.activ = aktiv;
        return this;
    }

    public Turnus getTurnus()
    {
        return this.turnus;
    }

    public Payment setTurnus(final Turnus turnus)
    {
        this.turnus = turnus;
        return this;
    }

    public String getName()
    {
        return this.name;
    }

    public Payment setName(final String name)
    {
        this.name = name;
        return this;
    }

    public LocalDate getInitialDate()
    {
        return this.initialDate;
    }

    public Payment setInitialDate(final LocalDate initialDate)
    {
        this.initialDate = initialDate;
        return this;
    }

    public String getCategory()
    {
        return this.category;
    }

    public Payment setCategory(final String category)
    {
        this.category = category;
        return this;
    }
}