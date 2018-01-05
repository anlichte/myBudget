package de.dielicht.budget.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CategoryData
{
    private String name;

    private Boolean aktiv = Boolean.TRUE;
    private BigDecimal betrag = BigDecimal.ZERO;
    private Turnus turnus = Turnus.monthly;
    private LocalDate initialDate = LocalDate.now();

    public CategoryData()
    {
        super();
    }

    public BigDecimal getBetrag()
    {
        return this.betrag;
    }

    public CategoryData setBetrag(final BigDecimal betrag)
    {
        this.betrag = betrag;
        return this;
    }

    public Boolean isAktiv()
    {
        return this.aktiv;
    }

    public CategoryData setAktiv(
                    final Boolean aktiv)
    {
        this.aktiv = aktiv;
        return this;
    }

    public Turnus getTurnus()
    {
        return this.turnus;
    }

    public CategoryData setTurnus(final Turnus turnus)
    {
        this.turnus = turnus;
        return this;
    }

    public String getName()
    {
        return this.name;
    }

    public CategoryData setName(final String name)
    {
        this.name = name;
        return this;
    }

    public LocalDate getInitialDate()
    {
        return this.initialDate;
    }

    public CategoryData setInitialDate(final LocalDate initialDate)
    {
        this.initialDate = initialDate;
        return this;
    }
}