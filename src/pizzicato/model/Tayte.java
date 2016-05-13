package pizzicato.model;

public class Tayte {
	int tayteId;
	String tNimi;
	double tHinta;
	
	public Tayte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tayte(String tNimi, double tHinta) {
		super();
		this.tNimi = tNimi;
		this.tHinta = tHinta;
	}

	public Tayte(int tayteId, String tNimi, double tHinta) {
		super();
		this.tayteId = tayteId;
		this.tNimi = tNimi;
		this.tHinta = tHinta;
	}

	public Tayte(int tayteId, String tNimi) {
		super();
		this.tayteId = tayteId;
		this.tNimi = tNimi;
	}

	public int getTayteId() {
		return tayteId;
	}

	public void setTayteId(int tayteId) {
		this.tayteId = tayteId;
	}

	public String gettNimi() {
		return tNimi;
	}
	
	
	public void settNimi(String tNimi) {
		this.tNimi = tNimi;
	}

	public double gettHinta() {
		return tHinta;
	}

	public void settHinta(double tHinta) {
		this.tHinta = tHinta;
	}

	@Override
	public String toString() {
		return tNimi;
	}
	

}