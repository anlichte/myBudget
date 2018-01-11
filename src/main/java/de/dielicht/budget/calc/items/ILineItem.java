package de.dielicht.budget.calc.items;

import java.math.BigDecimal;

public interface ILineItem
{
    BigDecimal getAmount();

    BigDecimal getTotal();

    BaseItem setTotal(final BigDecimal total);
}
