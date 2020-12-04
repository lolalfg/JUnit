package devise;

public class Money {
	
//	public Long calculer(Long a, Long b) {
//	      return a+b;
//	   }
//	   public Character lireSymbole() {
//	      return '-';
//	   }
	
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency){
		this.fAmount = amount;
		this.fCurrency = currency;
	}
	
	public int amount(){
		return this.fAmount;
	}
	
	public String currency(){
		return this.fCurrency;
	}
	
	public Money add(Money m) {
		if(m.fCurrency.equals(this.fCurrency)) {
			this.fAmount += m.fAmount;
		}
		
		return this;
	}
	
	public Money add(int namount, String ncurrency) {
		if(ncurrency.equals(this.fCurrency)) {
			this.fAmount += namount;
		}
		
		return this;
	}
	
	public String getfCurrency() {
		return fCurrency;
	}

	public void setfCurrency(String fCurrency) {
		this.fCurrency = fCurrency;
	}

	

}
