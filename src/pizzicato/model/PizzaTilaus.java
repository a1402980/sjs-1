package pizzicato.model;

public class PizzaTilaus {
	
	private Pizza pizza;
	private int tilausId;
	private int lkm;
	
	public PizzaTilaus(Pizza pizza, int tilausId, int lkm) {
		super();
		this.pizza = pizza;
		this.tilausId = tilausId;
		this.lkm = lkm;
	}
	public PizzaTilaus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public int getTilausId() {
		return tilausId;
	}
	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}
	public int getLkm() {
		return lkm;
	}
	public void setLkm(int lkm) {
		this.lkm = lkm;
	}
	
	@Override
	public String toString() {
		return "PizzaTilaus [pizza=" + pizza + ", tilausId=" + tilausId
				+ ", lkm=" + lkm + "]";
	}

}
