package de.dielicht.budget.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BudgetData
{
    private BigDecimal mindestGuthaben = BigDecimal.ZERO;
    private BigDecimal kontoStand = BigDecimal.ZERO;
    private LocalDate berechnungsDatum = LocalDate.now();

    @JsonSerialize(contentAs = CategoryData.class)
    @JsonDeserialize(contentAs = CategoryData.class)
    private final Map<String, CategoryData> categories = new HashMap<>();

    public BudgetData()
    {
    }

    public BudgetData(final BigDecimal kontoStand)
    {
        this.kontoStand = kontoStand;
    }

    public BigDecimal getMindestGuthaben()
    {
        return this.mindestGuthaben;
    }

    public BudgetData setMindestGuthaben(final BigDecimal mindestGuthaben)
    {
        this.mindestGuthaben = mindestGuthaben;
        return this;
    }

    public BigDecimal getKontoStand()
    {
        return this.kontoStand;
    }

    public BudgetData setKontoStand(final BigDecimal kontoStand)
    {
        this.kontoStand = kontoStand;
        return this;
    }

    public LocalDate getBerechnungsDatum()
    {
        return this.berechnungsDatum;
    }

    public BudgetData setBerechnungsDatum(final LocalDate berechnungsDatum)
    {
        this.berechnungsDatum = berechnungsDatum;
        return this;
    }

    public BudgetData addCategory(final CategoryData categoryData)
    {
        this.categories.put(categoryData.getName(), categoryData);
        return this;
    }

    public CategoryData getCategory(final String name)
    {
        return this.categories.get(name);
    }

    @JsonIgnore
    public Collection<CategoryData> getCategories()
    {
        return Collections.unmodifiableCollection(this.categories.values());
    }
}
