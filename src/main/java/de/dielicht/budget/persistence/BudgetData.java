package de.dielicht.budget.persistence;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BudgetData
{
    private BigDecimal mindestGuthaben = BigDecimal.ZERO;
    private BigDecimal kontoStand = BigDecimal.ZERO;
    private LocalDate berechnungsDatum = LocalDate.now();

    @JsonSerialize(contentAs=CategoryData.class)
    @JsonDeserialize(contentAs=CategoryData.class)
    private Map<String, CategoryData> categories = new HashMap<>();

    public BudgetData() {
	}

	public BudgetData(BigDecimal kontoStand)
    {
        this.kontoStand = kontoStand;
    }

    public BigDecimal getMindestGuthaben()
    {
        return this.mindestGuthaben;
    }

    public BudgetData setMindestGuthaben(BigDecimal mindestGuthaben)
    {
        this.mindestGuthaben = mindestGuthaben;
        return this;
    }

    public BigDecimal getKontoStand()
    {
        return this.kontoStand;
    }

    public BudgetData setKontoStand(BigDecimal kontoStand)
    {
        this.kontoStand = kontoStand;
        return this;
    }

    public LocalDate getBerechnungsDatum()
    {
        return this.berechnungsDatum;
    }

    public BudgetData setBerechnungsDatum(LocalDate berechnungsDatum)
    {
        this.berechnungsDatum = berechnungsDatum;
        return this;
    }

    public BudgetData addCategory(CategoryData categoryData)
    {
        this.categories.put(categoryData.getName(), categoryData);
        return this;
    }

    public CategoryData getCategory(String name)
    {
        return this.categories.get(name);
    }

    public static class CategoryData
    {
        private String name;

        private Boolean aktiv = Boolean.TRUE;
        private BigDecimal betrag = BigDecimal.ZERO;
        private Turnus turnus = Turnus.monthly;
        private Integer buchungstagOffset; // Tag der Wertstellung als Offset (0 basierent)
        private Integer monatOffset; // Monat der Wertstellung als Offset zum Turnus Anfang (0 basierent)

        public CategoryData()
        {
            super();
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

        public Integer getBuchungstagOffset()
        {
            return this.buchungstagOffset;
        }

        public CategoryData setBuchungstagOffset(Integer buchungstagOffset)
        {
            this.buchungstagOffset = buchungstagOffset;
            return this;
        }

        public Integer getMonatOffset()
        {
            return this.monatOffset;
        }

        public CategoryData setMonatOffset(Integer monatOffset)
        {
            this.monatOffset = monatOffset;
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
    }
}
