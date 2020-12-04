package devise;

import java.util.ArrayList;

public class MoneyBag {
	
	private ArrayList<Money> moneyBagList;
	
	public MoneyBag(ArrayList<Money> moneyBagList) {
		this.moneyBagList = moneyBagList;
	}
	
	public MoneyBag Normalise(String currency) {
		for(Money monnaie : this.moneyBagList) {
			monnaie.setfCurrency(currency);
		}
		
		return this;
	}
	
	public MoneyBag Add(Money monnaie) {
		if(monnaie.getfCurrency().equals(this.moneyBagList.get(0).getfCurrency()))
			this.moneyBagList.add(monnaie);
		
		return this;
	}


	public ArrayList<Money> getMoneyBagList() {
		return moneyBagList;
	}

	public void setMoneyBagList(ArrayList<Money> moneyBagList) {
		this.moneyBagList = moneyBagList;
	}

}
