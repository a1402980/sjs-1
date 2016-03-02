package pizzicato.model;

public class Tayte {
	int tayte_id;
	String t_nimi;
	
	public Tayte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tayte(int tayte_id, String t_nimi) {
		super();
		this.tayte_id = tayte_id;
		this.t_nimi = t_nimi;
	}

	public int getTayte_id() {
		return tayte_id;
	}

	public void setTayte_id(int tayte_id) {
		this.tayte_id = tayte_id;
	}

	public String getT_nimi() {
		return t_nimi;
	}

	public void setT_nimi(String t_nimi) {
		this.t_nimi = t_nimi;
	}

	@Override
	public String toString() {
		return "Tayte [tayte_id=" + tayte_id + ", t_nimi=" + t_nimi + "]";
	}
	
	
}
