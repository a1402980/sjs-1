package pizzicato.model;

public class PizzaTilaus {
	private int pizzaId;
	private int tilausId;
	private int lkm;
	
	public PizzaTilaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PizzaTilaus(int pizzaId, int tilausId, int lkm) {
		super();
		this.pizzaId = pizzaId;
		this.tilausId = tilausId;
		this.lkm = lkm;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
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
		return "PizzaTilaus [pizzaId=" + pizzaId + ", tilausId=" + tilausId
				+ ", lkm=" + lkm + "]";
	}
	
	

}
