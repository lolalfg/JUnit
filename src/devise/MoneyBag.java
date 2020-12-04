package devise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoneyBag {
	
	public HashMap<String, Money> monnaies;

    public MoneyBag() {
        this.monnaies = new HashMap<String, Money>();
    }

    public HashMap<String, Money> moneys() {
        return this.monnaies;
    }

    public MoneyBag add(Money monnaie){
        if (this.monnaies.containsKey(monnaie.currency())) {
            this.monnaies.get(monnaie.currency()).add(monnaie);
        } else {
            this.monnaies.put(monnaie.currency(), new Money(monnaie.amount(), monnaie.currency()));
        }
        return this;
    }

    public MoneyBag add(MoneyBag moneyBag){
        for (Map.Entry<String, Money> entry : moneyBag.monnaies.entrySet()) {
            this.add(entry.getValue());
        }
        return this;
    }

    public MoneyBag subb(Money monnaie) throws Exception {
        if (this.monnaies.containsKey(monnaie.currency())){
            this.monnaies.get(monnaie.currency()).add(-monnaie.amount(), monnaie.currency());
        } else {
            throw new Exception();
        }

        return this;
    }

    public MoneyBag subb(MoneyBag moneyBag) throws Exception {
        for (Map.Entry<String, Money> entry : moneyBag.monnaies.entrySet()) {
            this.subb(entry.getValue());
        }
        return this;
    }

    public Double normalise() {
        Double total = 0.00;
        for (Map.Entry<String, Money> entry : this.monnaies.entrySet()) {
            switch (entry.getKey()) {
                case "EUR":
                    total += entry.getValue().amount();
                    break;
                case "USD":
                    total += (entry.getValue().amount() * 0.82);
                    break;
                case "CHF":
                    total += (entry.getValue().amount() * 0.92);
                    break;
                case "GBP":
                    total += (entry.getValue().amount() * 1.10);
                    break;
            
                default:
                    break;
            }
        }
        return total;
    }

    public Boolean normaliseEqual(MoneyBag moneyBag) {
        return (this.normalise().equals(moneyBag.normalise()));
    }

}
