package pizzicato.model;

public class Asiakas {
	private int asiakasId;
	private int postiNro;
	private String etuNimi; 
	private String sukuNimi;
	private String osoite;
	private String sPosti; 
	private String postiTmp;
	
	public Asiakas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asiakas(int asiakasId, int postiNro, String etuNimi,
			String sukuNimi, String osoite, String sPosti, String postiTmp) {
		super();
		this.asiakasId = asiakasId;
		this.postiNro = postiNro;
		this.etuNimi = etuNimi;
		this.sukuNimi = sukuNimi;
		this.osoite = osoite;
		this.sPosti = sPosti;
		this.postiTmp = postiTmp;
	}

	public int getAsiakasId() {
		return asiakasId;
	}

	public void setAsiakasId(int asiakasId) {
		this.asiakasId = asiakasId;
	}

	public int getPostiNro() {
		return postiNro;
	}

	public void setPostiNro(int postiNro) {
		this.postiNro = postiNro;
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

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getsPosti() {
		return sPosti;
	}

	public void setsPosti(String sPosti) {
		this.sPosti = sPosti;
	}

	public String getPostiTmp() {
		return postiTmp;
	}

	public void setPostiTmp(String postiTmp) {
		this.postiTmp = postiTmp;
	}

	@Override
	public String toString() {
		return "Asiakas [asiakasId=" + asiakasId + ", postiNro=" + postiNro
				+ ", etuNimi=" + etuNimi + ", sukuNimi=" + sukuNimi
				+ ", osoite=" + osoite + ", sPosti=" + sPosti + ", postiTmp="
				+ postiTmp + "]";
	}
	
	
	

}
