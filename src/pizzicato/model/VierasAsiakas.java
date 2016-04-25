package pizzicato.model;

public class VierasAsiakas {
		private int vierasId;	
		private String etuNimi; 
		private String sukuNimi;
		private String puh;	
		private String osoite;	 
		private int postiNro;	
		private String postiTmp;
		private String sPosti;
			
		public VierasAsiakas() {
			super();
			// TODO Auto-generated constructor stub
		}

		public VierasAsiakas(int vierasId, String etuNimi, String sukuNimi, String puh,
				String osoite, int postiNro, String postiTmp, String sPosti) {
			super();
			this.vierasId = vierasId;
			this.etuNimi = etuNimi;
			this.sukuNimi = sukuNimi;
			this.puh = puh;
			this.osoite = osoite;
			this.postiNro = postiNro;
			this.postiTmp = postiTmp;
			this.sPosti = sPosti;
		}
		
		public int getvierasId() {
			return vierasId;
		}

		public void setvierasId(int vierasId) {
			this.vierasId = vierasId;
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

		

		@Override
		public String toString() {
			return "vieras [vierasId=" + vierasId + ", etuNimi=" + etuNimi
					+ ", sukuNimi=" + sukuNimi + ", puh=" + puh + ", osoite="
					+ osoite + ", postiNro=" + postiNro + ", postiTmp=" + postiTmp
					+ ", sPosti=" + sPosti + "]";
		}
		
		
		
		
}
		

