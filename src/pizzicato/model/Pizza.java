package pizzicato.model;

public class Pizza {
	int pizza_id;
	String p_nimi;
	double p_hinta;
	boolean p_saatavuus;
	
	public Pizza() {
		super();
	}

	public Pizza(int pizza_id, String p_nimi, double p_hinta,
			boolean p_saatavuus) {
		super();
		this.pizza_id = pizza_id;
		this.p_nimi = p_nimi;
		this.p_hinta = p_hinta;
		this.p_saatavuus = p_saatavuus;
	}

	public int getPizza_id() {
		return pizza_id;
	}

	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}

	public String getP_nimi() {
		return p_nimi;
	}

	public void setP_nimi(String p_nimi) {
		this.p_nimi = p_nimi;
	}

	public double getP_hinta() {
		return p_hinta;
	}

	public void setP_hinta(double p_hinta) {
		this.p_hinta = p_hinta;
	}

	public boolean isP_saatavuus() {
		return p_saatavuus;
	}

	public void setP_saatavuus(boolean p_saatavuus) {
		this.p_saatavuus = p_saatavuus;
	}

	@Override
	public String toString() {
		return "Pizza [pizza_id=" + pizza_id + ", p_nimi=" + p_nimi
				+ ", p_hinta=" + p_hinta + ", p_saatavuus=" + p_saatavuus + "]";
	}
	
	
	

}
