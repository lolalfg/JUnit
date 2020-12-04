package devises;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import devise.Money;
import devise.MoneyBag;


public class MoneyBagTest {
	
	private MoneyBag moneyBag;
	
	public MoneyBagTest() {
		Money monnaie1 = new Money(20, "EUR");
		Money monnaie2 = new Money(40, "EUR");
		Money monnaie3 = new Money(60, "EUR");
		
		
		ArrayList<Money> moneyBagList = new ArrayList<Money>();
		moneyBagList.add(monnaie1);
		moneyBagList.add(monnaie2);
		moneyBagList.add(monnaie3);
		
		this.moneyBag = new MoneyBag(moneyBagList);
	}
	
	@Test
	public void NormaliseTest() {
		this.moneyBag.Normalise("GBP").getMoneyBagList().forEach(m -> assertEquals(m.currency(), "GBP"));
	}
	
	@Test
	public void AjoutTest() {
		Money ajoutMoney = new Money(50, "GBP");
		int size = this.moneyBag.getMoneyBagList().size();
		
		this.moneyBag.Add(ajoutMoney);
		
		assertEquals(size++, this.moneyBag.getMoneyBagList().size());
	}
}