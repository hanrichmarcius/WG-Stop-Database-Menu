
public class SodaDrink extends Food{
	
	private int withIce;
	
	



	public SodaDrink(String id, String name, String fnb, int price, int withIce) {
		super(id, name, fnb, price);
		this.withIce = withIce;
	}



	public int getWithIce() {
		return withIce;
	}



	public void setWithIce(int withIce) {
		this.withIce = withIce;
	}



	public SodaDrink() {
		// TODO Auto-generated constructor stub
	}





	@Override
	public String generateId() {
		int index = 1;
		// TODO Auto-generated method stub
		String id = "SD" + "0" + "0" + index;
		index++;
		return id;
	}

}
