package pizzicato.model;

public class Asiakas {
	private int asiakasId;	
	private String etuNimi; 
	private String sukuNimi;
	private String puh;	
	private String osoite;	 
	private int postiNro;	
	private String postiTmp;
	private String sPosti;
	private int kayttaja_id;
	
	public Asiakas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asiakas(int asiakasId, String etuNimi, String sukuNimi, String puh,
			String osoite, int postiNro, String postiTmp, String sPosti) {
		super();
		this.asiakasId = asiakasId;
		this.etuNimi = etuNimi;
		this.sukuNimi = sukuNimi;
		this.puh = puh;
		this.osoite = osoite;
		this.postiNro = postiNro;
		this.postiTmp = postiTmp;
		this.sPosti = sPosti;
	}
	
		
	public Asiakas(int asiakasId, String etuNimi, String sukuNimi, String puh,
			String osoite, int postiNro, String postiTmp, String sPosti,
			int kayttaja_id) {
		super();
		this.asiakasId = asiakasId;
		this.etuNimi = etuNimi;
		this.sukuNimi = sukuNimi;
		this.puh = puh;
		this.osoite = osoite;
		this.postiNro = postiNro;
		this.postiTmp = postiTmp;
		this.sPosti = sPosti;
		this.kayttaja_id = kayttaja_id;
	}

	public int getAsiakasId() {
		return asiakasId;
	}

	public void setAsiakasId(int asiakasId) {
		this.asiakasId = asiakasId;
	}

	public String getEtuNimi() {
		return etuNimi;
	}

	public void setEtuNimi(String etuNimi) {
		this.etuNimi = etuNimi;
	}

	public String getSukuNimi() {
		return sukuNimi;
	}

	public void setSukuNimi(String sukuNimi) {
		this.sukuNimi = sukuNimi;
	}

	public String getPuh() {
		return puh;
	}

	public void setPuh(String puh) {
		this.puh = puh;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public int getPostiNro() {
		return postiNro;
	}

	public void setPostiNro(int postiNro) {
		this.postiNro = postiNro;
	}

	public String getPostiTmp() {
		return postiTmp;
	}

	public void setPostiTmp(String postiTmp) {
		this.postiTmp = postiTmp;
	}

	public String getsPosti() {
		return sPosti;
	}

	public void setsPosti(String sPosti) {
		this.sPosti = sPosti;
	}

	public int getKayttaja_id() {
		return kayttaja_id;
	}

	public void setKayttaja_id(int kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}

	@Override
	public String toString() {
		return "Asiakas [asiakasId=" + asiakasId + ", etuNimi=" + etuNimi
				+ ", sukuNimi=" + sukuNimi + ", puh=" + puh + ", osoite="
				+ osoite + ", postiNro=" + postiNro + ", postiTmp=" + postiTmp
				+ ", sPosti=" + sPosti + "]";
	}
	
	
	
	
}
	