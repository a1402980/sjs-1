package pizzicato.model;

import java.util.ArrayList;

public class Pizza {
	int pizzaId;
	String pNimi;
	double pHinta;
	String pSaatavuus;
	ArrayList<Tayte> taytteet = new ArrayList<Tayte>();	
	
	public Pizza() {
		super();
	}

	public Pizza(String pNimi, double pHinta, String pSaatavuus) {
		this.pNimi = pNimi;
		this.pHinta = pHinta;
		this.pSaatavuus = pSaatavuus;
	}
	
	public Pizza(int pizzaId, String pNimi, double pHinta, String pSaatavuus) {
		this.pizzaId = pizzaId;
		this.pNimi = pNimi;
		this.pHinta = pHinta;
		this.pSaatavuus = pSaatavuus;		
	}
		
	public Pizza(int pizzaId, String pNimi, double pHinta, String pSaatavuus,
			ArrayList<Tayte> taytteet) {
		super();
		this.pizzaId = pizzaId;
		this.pNimi = pNimi;
		this.pHinta = pHinta;
		this.pSaatavuus = pSaatavuus;
		this.taytteet = taytteet;
	}

	public Pizza(String pNimi, double pHinta, String pSaatavuus,
			ArrayList<Tayte> taytteet) {
		super();
		this.pNimi = pNimi;
		this.pHinta = pHinta;
		this.pSaatavuus = pSaatavuus;
		this.taytteet = taytteet;
	}

	public String getpSaatavuus() {
		return pSaatavuus;
	}

	public void setpSaatavuus(String pSaatavuus) {
		this.pSaatavuus = pSaatavuus;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getpNimi() {
		return pNimi;
	}

	public void setpNimi(String pNimi) {
		this.pNimi = pNimi;
	}

	public double getpHinta() {
		return pHinta;
	}

	public void setpHinta(double pHinta) {
		this.pHinta = pHinta;
	}

	public void addTayte(Tayte tayte) {
		this.taytteet.add(tayte);
	}
	
	public Tayte getTayte(int idx) {
		return this.taytteet.get(idx);		
	}
	
	public int getTayteLkm(int pizzaId) {
		int TayteLkm = this.taytteet.size();
		return TayteLkm;
	}
	
	public ArrayList<Tayte> getTaytteet() {
		return taytteet;
	}

	public void setTaytteet(ArrayList<Tayte> taytteet) {
		this.taytteet = taytteet;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", pNimi=" + pNimi + ", pHinta="
				+ pHinta + ", pSaatavuus=" + pSaatavuus + ", taytteet=" + taytteet +
				"]";
	}
	
	
}
