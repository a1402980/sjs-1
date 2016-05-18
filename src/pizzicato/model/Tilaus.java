package pizzicato.model;

import java.util.ArrayList;
import java.util.Date;


public class Tilaus {
	private int tilausId;
	private String status;
	private Date tilAjankohta = new Date();
	private ArrayList<PizzaTilaus> pizzatilaukset = new ArrayList<PizzaTilaus>();
	private String aEtunimi;
	private String aSukunimi;
	private String aPuh;
	private String aOsoite;
	private int aPostiNro;
	private String aPostiTmp;
	private String cola;
	private String fanta;
	private String sprite;
	private double yhtHinta;

	public Tilaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tilaus(int tilausId, String status, Date tilAjankohta,
			ArrayList<PizzaTilaus> pizzatilaukset, String aEtunimi,
			String aSukunimi, String aPuh, String aOsoite, int aPostiNro,
			String aPostiTmp, String cola, String fanta, String sprite, double yhtHinta) {
		super();
		this.tilausId = tilausId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
		this.pizzatilaukset = pizzatilaukset;
		this.aEtunimi = aEtunimi;
		this.aSukunimi = aSukunimi;
		this.aPuh = aPuh;
		this.aOsoite = aOsoite;
		this.aPostiNro = aPostiNro;
		this.aPostiTmp = aPostiTmp;
		this.cola = cola;
		this.fanta = fanta;
		this.sprite = sprite;
		this.yhtHinta = yhtHinta;
	}
	
	public Tilaus(int tilausId, String status, Date tilAjankohta,
			String aEtunimi, String aSukunimi, String aPuh, String aOsoite,
			int aPostiNro, String aPostiTmp, double yhtHinta) {
		super();
		this.tilausId = tilausId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
		this.aEtunimi = aEtunimi;
		this.aSukunimi = aSukunimi;
		this.aPuh = aPuh;
		this.aOsoite = aOsoite;
		this.aPostiNro = aPostiNro;
		this.aPostiTmp = aPostiTmp;
	}
		
	public Tilaus(int tilausId, String status, Date tilAjankohta,
			String aEtunimi, String aSukunimi, String aPuh, String aOsoite,
			int aPostiNro, String aPostiTmp, String cola, String fanta,
			String sprite, double yhtHinta) {
		super();
		this.tilausId = tilausId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
		this.aEtunimi = aEtunimi;
		this.aSukunimi = aSukunimi;
		this.aPuh = aPuh;
		this.aOsoite = aOsoite;
		this.aPostiNro = aPostiNro;
		this.aPostiTmp = aPostiTmp;
		this.cola = cola;
		this.fanta = fanta;
		this.sprite = sprite;
		this.yhtHinta = yhtHinta;
	}
	
	public Tilaus(int tilausId, String status, Date tilAjankohta, String cola,
			String fanta, String sprite, double yhtHinta) {
		super();
		this.tilausId = tilausId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
		this.cola = cola;
		this.fanta = fanta;
		this.sprite = sprite;
		this.yhtHinta = yhtHinta;
	}
	
	public Tilaus(int tilausId, String status, Date tilAjankohta,
			ArrayList<PizzaTilaus> pizzatilaukset) {
		super();
		this.tilausId = tilausId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
		this.pizzatilaukset = pizzatilaukset;
	}
	
	public Tilaus(int tilausId, String status, Date tilAjankohta) {
		super();
		this.tilausId = tilausId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
	}

	public Tilaus(int tilausId, String status, Date tilAjankohta,
			String aSukunimi, String aPuh, String aOsoite, int aPostiNro,
			String aPostiTmp, String cola, String fanta, String sprite,
			double yhtHinta) {
		super();
		this.tilausId = tilausId;
		this.status = status;
		this.tilAjankohta = tilAjankohta;
		this.aSukunimi = aSukunimi;
		this.aPuh = aPuh;
		this.aOsoite = aOsoite;
		this.aPostiNro = aPostiNro;
		this.aPostiTmp = aPostiTmp;
		this.cola = cola;
		this.fanta = fanta;
		this.sprite = sprite;
		this.yhtHinta = yhtHinta;
	}

	public String getCola() {
		return cola;
	}

	public void setCola(String cola) {
		this.cola = cola;
	}

	public String getFanta() {
		return fanta;
	}

	public void setFanta(String fanta) {
		this.fanta = fanta;
	}

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}


	public int getTilausId() {
		return tilausId;
	}

	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
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
	
	public void removePizzaTilaus(int index) {
		this.pizzatilaukset.remove(index);
	}
	
	public PizzaTilaus getPizzaTilaus(int idx) {
		return this.pizzatilaukset.get(idx);		
	}
	
	public int getPizzaTilLkm() {
		int PizzaTilLkm = this.pizzatilaukset.size();
		return PizzaTilLkm;
	}

	public String getaEtunimi() {
		return aEtunimi;
	}

	public void setaEtunimi(String aEtunimi) {
		this.aEtunimi = aEtunimi;
	}

	public String getaSukunimi() {
		return aSukunimi;
	}

	public void setaSukunimi(String aSukunimi) {
		this.aSukunimi = aSukunimi;
	}

	public String getaPuh() {
		return aPuh;
	}

	public void setaPuh(String aPuh) {
		this.aPuh = aPuh;
	}

	public String getaOsoite() {
		return aOsoite;
	}

	public void setaOsoite(String aOsoite) {
		this.aOsoite = aOsoite;
	}

	public int getaPostiNro() {
		return aPostiNro;
	}

	public void setaPostiNro(int aPostiNro) {
		this.aPostiNro = aPostiNro;
	}

	public String getaPostiTmp() {
		return aPostiTmp;
	}

	public void setaPostiTmp(String aPostiTmp) {
		this.aPostiTmp = aPostiTmp;
	}
		//Laskee lennosta tilauksen pizzojen ja juomien yhteishinnan
	public double getYhtHinta() {
		double yhteissumma = 0;
		 PizzaTilaus pizzatilaus;
		 for (int i=0;i<pizzatilaukset.size(); i++){  
			pizzatilaus = pizzatilaukset.get(i);
			 yhteissumma += pizzatilaus.getPizza().getpHinta()*1;	
		}
		 if (this.cola != null && this.cola.equals("true")){
			 yhteissumma += 4;
		 }
		 if (this.fanta != null && this.fanta.equals("true")){
			 yhteissumma += 4;
		 }
		 if (this.sprite != null && this.sprite.equals("true")){
			 yhteissumma += 4;
		 }
		 
		return yhteissumma;
	}

	public void setYhtHinta(double yhtHinta) {
		this.yhtHinta = yhtHinta;
	}

	@Override
	public String toString() {
		return "Tilaus [tilausId=" + tilausId + ", status=" + status
				+ ", tilAjankohta=" + tilAjankohta + ", pizzatilaukset="
				+ pizzatilaukset + ", aEtunimi=" + aEtunimi + ", aSukunimi="
				+ aSukunimi + ", aPuh=" + aPuh + ", aOsoite=" + aOsoite
				+ ", aPostiNro=" + aPostiNro + ", aPostiTmp=" + aPostiTmp
				+ ", cola=" + cola + ", fanta=" + fanta + ", sprite=" + sprite
				+ ", yhtHinta=" + yhtHinta + "]";
	}

	
	
	
	
}
