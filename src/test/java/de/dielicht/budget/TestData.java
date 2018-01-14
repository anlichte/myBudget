package de.dielicht.budget;

import java.math.BigDecimal;
import java.time.LocalDate;

import de.dielicht.budget.model.BudgetData;
import de.dielicht.budget.model.Payment;
import de.dielicht.budget.model.Turnus;

public class TestData
{
    public static BudgetData create()
    {
        final Payment gehalt = new Payment()
            .setName("Gehalt")
            .setCategory("Einnahmen")
            .setBetrag(new BigDecimal("500.00"))
            .setInitialDate(LocalDate.of(2017, 1, 20))
            .setTurnus(Turnus.monthly);

        final Payment essen = new Payment()
            .setName("Essen")
            .setCategory("Haushalt")
            .setBetrag(new BigDecimal("-350.00"))
            .setInitialDate(LocalDate.of(1968, 11, 12))
            .setTurnus(Turnus.monthly);

        final Payment ruf = new Payment()
            .setName("Rundfunk/Fernsehen(GEZ)")
            .setCategory("Haus")
            .setBetrag(new BigDecimal("-50.00"))
            .setInitialDate(LocalDate.of(2017, 5, 31))
            .setTurnus(Turnus.quarterly);

        final Payment ver = new Payment()
            .setName("Allianz Hausrat")
            .setCategory("Versicherung")
            .setBetrag(new BigDecimal("-250.00"))
            .setInitialDate(LocalDate.of(2017, 2, 25))
            .setTurnus(Turnus.halfYearly);

        final Payment dav = new Payment()
            .setName("Deutscher Alpenverein")
            .setCategory("Mitgliedscaften")
            .setBetrag(new BigDecimal("-50.00"))
            .setInitialDate(LocalDate.of(1991, 2, 25))
            .setTurnus(Turnus.annual);

        return new BudgetData(new BigDecimal("1000.00"))
            .addPayment(ruf)
            .addPayment(ver)
            .addPayment(gehalt)
            .addPayment(essen)
            .addPayment(dav);
    }
}
