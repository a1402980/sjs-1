package pizzicato.model;

public class PizzaTilaus {
	
	private int pizzatil_id;
	private int tilausId;
	private Pizza pizza;
	private String oregano;
	private String valkosipuli;
	private int pizzaId;
	
	public PizzaTilaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PizzaTilaus(int pizzatil_id, int tilausId, Pizza pizza,
			String oregano, String valkosipuli) {
		super();
		this.pizzatil_id = pizzatil_id;
		this.tilausId = tilausId;
		this.pizza = pizza;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
	}
	
	public PizzaTilaus(int pizzatil_id, Pizza pizza, String oregano,
			String valkosipuli) {
		super();
		this.pizzatil_id = pizzatil_id;
		this.pizza = pizza;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
	}
	
	public PizzaTilaus(int pizzatil_id, int tilausId, Pizza pizza) {
		super();
		this.pizzatil_id = pizzatil_id;
		this.tilausId = tilausId;
		this.pizza = pizza;
	}

	public PizzaTilaus(int pizzatil_id, Pizza pizza) {
		super();
		this.pizzatil_id = pizzatil_id;
		this.pizza = pizza;
	}

	public PizzaTilaus(int pizzatil_id, int tilausId, int pizzaId) {
		super();
		this.pizzatil_id = pizzatil_id;
		this.tilausId = tilausId;
		this.pizzaId = pizzaId;
	}

	public PizzaTilaus(int pizzatil_id, int tilausId, String oregano,
			String valkosipuli, int pizzaId) {
		super();
		this.pizzatil_id = pizzatil_id;
		this.tilausId = tilausId;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
		this.pizzaId = pizzaId;
	}

	public int getPizzatil_id() {
		return pizzatil_id;
	}

	public void setPizzatil_id(int pizzatil_id) {
		this.pizzatil_id = pizzatil_id;
	}

	public int getTilausId() {
		return tilausId;
	}

	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getOregano() {
		return oregano;
	}

	public void setOregano(String oregano) {
		this.oregano = oregano;
	}

	public String getValkosipuli() {
		return valkosipuli;
	}

	public void setValkosipuli(String valkosipuli) {
		this.valkosipuli = valkosipuli;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	@Override
	public String toString() {
		return "PizzaTilaus [pizzatil_id=" + pizzatil_id + ", tilausId="
				+ tilausId + ", pizza=" + pizza + ", oregano=" + oregano
				+ ", valkosipuli=" + valkosipuli + "]";
	}
	
		
}
