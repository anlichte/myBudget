package de.dielicht.budget.persistence;

import java.math.BigDecimal;
import java.time.Month;
import java.time.MonthDay;
import java.util.List;

public class CategoryData
{
    private String name;

    private Boolean aktiv = Boolean.TRUE;
    private BigDecimal betrag = BigDecimal.ZERO;
    private Turnus turnus = Turnus.monthly;
    private MonthDay initialDate = MonthDay.of(Month.JANUARY, 1);
    private List<MonthDay> valueDays;

    public CategoryData()
    {
        super();
    }

    public CategoryData calculateValueDays()
    {
        this.valueDays = this.turnus.createValueDays(this.initialDate);
        return this;
    }

    public BigDecimal getBetrag()
    {
        return this.betrag;
    }

    public CategoryData setBetrag(BigDecimal betrag)
    {
        this.betrag = betrag;
        return this;
    }

    public Boolean isAktiv()
    {
        return this.aktiv;
    }

    public CategoryData setAktiv(
            Boolean aktiv)
    {
        this.aktiv = aktiv;
        return this;
    }

    public Turnus getTurnus()
    {
        return this.turnus;
    }

    public CategoryData setTurnus(Turnus turnus)
    {
        this.turnus = turnus;
        return this;
    }

    public String getName()
    {
        return this.name;
    }

    public CategoryData setName(String name)
    {
        this.name = name;
        return this;
    }

    public MonthDay getInitialDate()
    {
        return initialDate;
    }

    public CategoryData setInitialDate(MonthDay initialDate)
    {
        this.initialDate = initialDate;
        return this;
    }

    public List<MonthDay> getValueDays()
    {
        return valueDays;
    }

    public CategoryData setValueDays(List<MonthDay> valueDays)
    {
        this.valueDays = valueDays;
        return this;
    }
}