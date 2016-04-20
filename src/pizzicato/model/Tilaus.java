package pizzicato.model;

import java.util.ArrayList;
import java.util.Date;


public class Tilaus {
	private int tilausId;
	private int asiakasId;
	private String status;
	private Date tilausAjankohta = new Date();
	private ArrayList<PizzaTilaus> pizzatilaukset = new ArrayList<PizzaTilaus>();
	
	public Tilaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tilaus(int tilausId, int asiakasId, String status,
			Date tilausAjankohta, ArrayList<PizzaTilaus> pizzatilaukset) {
		super();
		this.tilausId = tilausId;
		this.asiakasId = asiakasId;
		this.status = status;
		this.tilausAjankohta = tilausAjankohta;
		this.pizzatilaukset = pizzatilaukset;
	}

	public int getTilausId() {
		return tilausId;
	}

	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}

	public int getAsiakasId() {
		return asiakasId;
	}

	public void setAsiakasId(int asiakasId) {
		this.asiakasId = asiakasId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTilausAjankohta() {
		return tilausAjankohta;
	}

	public void setTilausAjankohta(Date tilausAjankohta) {
		this.tilausAjankohta = tilausAjankohta;
	}

	public ArrayList<PizzaTilaus> getPizzatilaukset() {
		return pizzatilaukset;
	}

	public void setPizzatilaukset(ArrayList<PizzaTilaus> pizzatilaukset) {
		this.pizzatilaukset = pizzatilaukset;
	}

	@Override
	public String toString() {
		return "Tilaus [tilausId=" + tilausId + ", asiakasId=" + asiakasId
				+ ", status=" + status + ", tilausAjankohta=" + tilausAjankohta
				+ ", pizzatilaukset=" + pizzatilaukset + "]";
	}
	
	
}
