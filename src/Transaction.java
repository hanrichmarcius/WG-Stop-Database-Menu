
public class Transaction {
	
	private String transactionID, itemID, customerName, customerEmail;
	private int quantity;
	
	public Transaction(String transactionID, String itemID, String customerName, String customerEmail, int quantity) {
		super();
		this.transactionID = transactionID;
		this.itemID = itemID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.quantity = quantity;
	}

	public String getTransactionID() {
		return transactionID;
	}



	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}



	public String getItemID() {
		return itemID;
	}



	public void setItemID(String itemID) {
		this.itemID = itemID;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Transaction() {
		// TODO Auto-generated constructor stub
	}

}
