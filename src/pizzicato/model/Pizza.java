package pizzicato.model;

import java.util.ArrayList;

public class Pizza {
	int pizzaId;
	String pNimi;
	double pHinta;
	boolean pSaatavuus;
	ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
	
	public Pizza() {
		super();
	}

	public Pizza(String pNimi, double pHinta, boolean pSaatavuus) {
		this.pNimi = pNimi;
		this.pHinta = pHinta;
		this.pSaatavuus = pSaatavuus;
	}
	
	public Pizza(int pizzaId, String pNimi, double pHinta, boolean pSaatavuus) {
		this.pizzaId = pizzaId;
		this.pNimi = pNimi;
		this.pHinta = pHinta;
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

	public boolean ispSaatavuus() {
		return pSaatavuus;
	}

	public void setpSaatavuus(boolean pSaatavuus) {
		this.pSaatavuus = pSaatavuus;
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
				+ pHinta + ", pSaatavuus=" + pSaatavuus + ", taytteet="
				+ taytteet + "]";
	}
	
	
}
