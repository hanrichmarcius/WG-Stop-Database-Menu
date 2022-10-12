

public class Wing extends Food {
	
	private String sauceName;
	
	

	public Wing(String id, String name, String fnb, int price, String sauceName) {
		super(id, name, fnb, price);
		this.sauceName = sauceName;
	}


	public String getSauceName() {
		return sauceName;
	}


	public void setSauceName(String sauceName) {
		this.sauceName = sauceName;
	}


	public Wing() {
		// TODO Auto-generated constructor stub
	}


	


	@Override
	public String generateId() {
		int index = 1;
		// TODO Auto-generated method stub
		String id = "WW" + "0" + "0" + index;
		index++;
		return id;
	}

}
