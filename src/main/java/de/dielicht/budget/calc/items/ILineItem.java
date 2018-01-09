package de.dielicht.budget.calc.items;

import java.math.BigDecimal;

public interface ILineItem
{
    String getText();

    BigDecimal getAmount();

    BigDecimal getTotal();

    ILineItem setTotal(BigDecimal newTotal);
}
