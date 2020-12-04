package devises;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import devise.Money;
import devise.MoneyBag;


public class MoneyBagTest {

	MoneyBag globalBag;

    @BeforeEach
    public void moneyBagCreation() {
        Money monnaie1, monnaie2, monnaie3, monnaie4;
        this.globalBag = new MoneyBag();

        try {
        	monnaie1 = new Money(10, "EUR");
        	monnaie2 = new Money(10, "USD");
        	monnaie3 = new Money(10, "CHF");
        	monnaie4 = new Money(10, "GBP");

            this.globalBag.add(monnaie1);
            this.globalBag.add(monnaie2);
            this.globalBag.add(monnaie3);
            this.globalBag.add(monnaie4);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    MoneyBag moneyBagCreationSpe() {
        Money monnaie1, monnaie2, monnaie3, monnaie4;
        MoneyBag moneyBag = new MoneyBag();

        try {
        	monnaie1 = new Money(10, "EUR");
        	monnaie2 = new Money(10, "USD");
        	monnaie3 = new Money(10, "CHF");
        	monnaie4 = new Money(10, "GBP");

            moneyBag.add(monnaie1);
            moneyBag.add(monnaie2);
            moneyBag.add(monnaie3);
            moneyBag.add(monnaie4);

        } catch (Exception e) {
            fail(e.getMessage());
        }
        return moneyBag;
    }

    @Test
    public void moneyBagCreationTaille() {
        MoneyBag moneybag = new MoneyBag();
        assertEquals(0, moneybag.monnaies.size());
    }

    @Test
    public void ajoutMoney() {
        Money monnaie;
        try {
        	monnaie = new Money(50, "EUR");
            this.globalBag.add(monnaie);

        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(20, this.globalBag.monnaies.get("EUR").amount());
    }

    @Test
    public void ajoutMoneyBag() {
        MoneyBag ajout = moneyBagCreationSpe();
        try {
            this.globalBag.add(ajout);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        for (Map.Entry<String, Money> entry : this.globalBag.monnaies.entrySet()) {
            assertEquals(20, entry.getValue().amount());
        }
        assertEquals(4, this.globalBag.monnaies.size());
    }

    @Test
    public void ajoutMoneyNonExistante() {
        MoneyBag moneyBag = new MoneyBag();
        try {
            moneyBag.add(new Money(150, "EUR"));
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(150, moneyBag.monnaies.get("EUR").amount());
        assertEquals(1, moneyBag.monnaies.size());
    }

    @Test
    public void ajoutMoneyBagNonExistante() {
        MoneyBag moneyBag = new MoneyBag();
        try {
            moneyBag.add(this.globalBag);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        for (Map.Entry<String, Money> entry : moneyBag.monnaies.entrySet()) {
            assertEquals(50, entry.getValue().amount());
        }
        assertEquals(4, moneyBag.monnaies.size());
    }

    @Test
    public void subMoneyExistante() {
        Money monnaie;
        try {
        	monnaie = new Money(25, "EUR");
            this.globalBag.subb(monnaie);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        for (Map.Entry<String, Money> entry : this.globalBag.monnaies.entrySet()) {
            if (entry.getKey() == "EUR") {
                assertEquals(25, entry.getValue().amount());
            } else {
                assertEquals(50, entry.getValue().amount());
            }

        }
        assertEquals(4, this.globalBag.monnaies.size());

    }

    @Test
    public void subMoneyNonExistante() {
        Money monnaie;
        MoneyBag moneyBag = new MoneyBag();
        try {
        	monnaie = new Money(35, "EUR");

            Exception thrown = assertThrows(
                Exception.class,
                () -> moneyBag.subb(monnaie),
                "Pas bon"
            );

            String messageException = "Devise incorrect";
            String message = thrown.getMessage();
            assertSame(message, messageException);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void subMoneyBag() {
        Money monnaie;
        try {
        	monnaie = new Money(25, "EUR");
            this.globalBag.subb(monnaie);

            assertEquals(25, this.globalBag.monnaies.get("EUR").amount());
            assertEquals(4, this.globalBag.monnaies.size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }



}
