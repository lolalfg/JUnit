package devises;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.jupiter.api.assertions.*;
import org.junit.jupiter.*;

import devise.Money;

public class MoneyTest {

//	@Test
//	public void AmountTest() {
//		Money newObject = new Money(11, "eur");
//		
//		assertEquals(10, newObject.amount());
//	}
	private Money monnaie = new Money(20, "EUR");

	@Test
	public void AmountTestPositive() {
		assertTrue(monnaie.amount() >= 0);
	}
	
	@Test
	public void CurrencyTest() {
		assertTrue(monnaie.currency().length() == 3);
		assertTrue(monnaie.currency() == "EUR" || monnaie.currency() == "USD" || monnaie.currency() == "CHF" || monnaie.currency() == "GBP");
	}
	
	@Test
	public void AdditionTest() {
		Money moneyToAddEur = new Money(20, "EUR");

		
		assertEquals(monnaie.add(moneyToAddEur).amount(), 40);
	
	}



}
