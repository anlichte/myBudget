package de.dielicht.budget.model;

import java.math.BigDecimal;
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

    @JsonSerialize(contentAs = Payment.class)
    @JsonDeserialize(contentAs = Payment.class)
    private final Map<String, Payment> categories = new HashMap<>();

    public BudgetData()
    {
    }

    public BudgetData(final BigDecimal mindestGuthaben)
    {
        this.mindestGuthaben = mindestGuthaben;
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

    public BudgetData addCategory(final Payment categoryData)
    {
        this.categories.put(categoryData.getName(), categoryData);
        return this;
    }

    public Payment getCategory(final String name)
    {
        return this.categories.get(name);
    }

    @JsonIgnore
    public Collection<Payment> getPayments()
    {
        return Collections.unmodifiableCollection(this.categories.values());
    }
}
