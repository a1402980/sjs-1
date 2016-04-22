package pizzicato.model;

import java.util.ArrayList;
import java.util.Date;


public class Tilaus {
	private int tilausId;
	private int asiakasId;
	private String status;
	private Date tilAjankohta = new Date();
	private ArrayList<PizzaTilaus> pizzatilaukset = new ArrayList<PizzaTilaus>();
	
	public Tilaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tilaus(int tilausId, int asiakasId, String status,
			Date tilAjankohta, ArrayList<PizzaTilaus> pizzatilaukset) {
		super();
		this.tilausId = tilausId;
		this.asiakasId = asiakasId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
		this.pizzatilaukset = pizzatilaukset;
	}
	
	public Tilaus(int tilausId, int asiakasId, String status, Date tilAjankohta) {
		super();
		this.tilausId = tilausId;
		this.asiakasId = asiakasId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
	}
	
	public Tilaus(int tilausId, int asiakasId) {
		super();
		this.tilausId = tilausId;
		this.asiakasId = asiakasId;
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

	public Date getTilAjankohta() {
		return tilAjankohta;
	}

	public void setTilAjankohta(Date tilAjankohta) {
		this.tilAjankohta = tilAjankohta;
	}

	public ArrayList<PizzaTilaus> getPizzatilaukset() {
		return pizzatilaukset;
	}

	public void setPizzatilaukset(ArrayList<PizzaTilaus> pizzatilaukset) {
		this.pizzatilaukset = pizzatilaukset;
	}
	
	public void addPizzaTilaus(PizzaTilaus pizzatil) {
		this.pizzatilaukset.add(pizzatil);
	}
	
	public PizzaTilaus getPizzaTilaus(int idx) {
		return this.pizzatilaukset.get(idx);		
	}
	
	public int getPizzaTilLkm(int tilausId) {
		int PizzaTilLkm = this.pizzatilaukset.size();
		return PizzaTilLkm;
	}

	@Override
	public String toString() {
		return "Tilaus [tilausId=" + tilausId + ", asiakasId=" + asiakasId
				+ ", status=" + status + ", tilAjankohta=" + tilAjankohta
				+ ", pizzatilaukset=" + pizzatilaukset + "]";
	}
	
	
}
