
public abstract class Food {
	
	private String id, name , fnb;
	private int price;
	
	

	
	public Food(String id, String name, String fnb, int price) {
		super();
		this.id = id;
		this.name = name;
		this.fnb = fnb;
		this.price = price;
	}


	public String getFnb() {
		return fnb;
	}


	public void setFnb(String fnb) {
		this.fnb = fnb;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	
	
	public abstract String generateId();
	
	public Food() {
		// TODO Auto-generated constructor stub
	}

}
