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
	private Money money = new Money(20, "EUR");

	@Test
	public void AmountTestPositive() {
		assertTrue(money.amount() >= 0);
	}
	
	@Test
	public void CurrencyTest() {
		assertTrue(money.currency().length() == 3);
		assertTrue(money.currency() == "EUR" || money.currency() == "USD" || money.currency() == "CHF" || money.currency() == "GBP");
	}
	
	@Test
	public void AdditionTest() {
		Money moneyToAddEur = new Money(20, "EUR");

		
		assertEquals(money.add(moneyToAddEur).amount(), 40);
	
	}



}
