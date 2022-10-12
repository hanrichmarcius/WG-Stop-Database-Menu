import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner scan = new Scanner (System.in);
	Connect connect = Connect.getConnection();
	Vector<Food> food = new Vector<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		int input = 0;
		
		do {
			menu();
			input = scan.nextInt();
			scan.nextLine();
			
			switch (input) {
			case 1:
				create();
				break;

			case 2:
				viewTransaction();
				break;
				
			case 3:
				delete();
				break;
			}
			
		} while (input != 4);
	}
	
	public void menu() {
		System.out.println("=======================");
		System.out.println("| Welcome to WG Stop |");
		System.out.println("=======================");
		System.out.println("|1. Create Transaction|");
		System.out.println("|2. View Transaction  |");
		System.out.println("|3. Delete Transaction|");
		System.out.println("|4. Exit              |");
		System.out.println("=======================");
		System.out.print(">> ");
	}

	public void create() {
		viewList();
		int item = 0;
		System.out.print("Input Item [1 - 10]: ");
		item = scan.nextInt();
		scan.nextLine();
		
		String name = "";
		do {
			System.out.print("Input Customer Name [5-20] (inclusive): ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 25);
		
		String email = "";
		do {
			System.out.print("Input Customer Email [must ends with '@gmail.com']: ");
			email = scan.nextLine();
		} while (email.endsWith("@gmail.com"));
		
		int quantity = 0;
		do {
			System.out.print("Input Quantity [must be more than zero]: ");
			quantity = scan.nextInt();
			scan.nextLine();
		} while (quantity < 0);
		
		int price = 0;
		String sauce ="";
		
		if (item <= 5) {
			String fnb = "Beverage";
			
			switch (item) {
			case 1:
				price = 7500;
				break;

			case 2:
				price = 8500;
				break;
				
			case 3:
				price = 7250;
				break;
				
			case 4:
				price = 10000;
				break;
				
			case 5:
				price = 6500;
				break;
			}
			SodaDrink sd = new SodaDrink();
			sd.setId(sd.generateId());
			sd.setName(name);
			sd.setFnb(fnb);
			
			if(item == 1 || item == 5) {
				sd.setWithIce(1);
				sd.setPrice((price+2000)*quantity);
			} else {
				sd.setWithIce(0);
				sd.setPrice(price*quantity);
			}
			
			PreparedStatement ps = connect.prepareStatement("INSERT INTO sodadrink (itemID, itemName, itemPrice, withIce) VALUES (?,?,?,?)");
			
			try {
				ps.setString(1, sd.getId());
				ps.setString(2, name);
				ps.setInt(3, sd.getPrice());
				ps.setInt(4, sd.getWithIce());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			food.add(sd);
			
			System.out.println("Detail Transaction");
			System.out.println("====================================================");
			System.out.printf("Customer : %s", name);
			System.out.printf("Email : %s", email);
			System.out.printf("Item : %s", sd.getName());
			System.out.printf("With Icec : %s", sd.getWithIce());
			System.out.printf("Quantity : %d", quantity);
			System.out.printf("Price : %d", price);
			System.out.printf("Total Price : %d", sd.getPrice());
			System.out.println("====================================================");
			System.out.println("Press Enter to Continue...");
			scan.nextLine();
			
		} else if (item >= 6) {
			String fnb = "Food";
			
			switch (item) {
			case 1:
				price = 17500;
				sauce = "Original";
				break;

			case 2:
				price = 25500;
				sauce = "Original";
				break;
				
			case 3:
				price = 20000;
				sauce = "Honey";
				break;
				
			case 4:
				price = 18500;
				sauce = "Barbecue";
				break;
				
			case 5:
				price = 25000;
				sauce = "Cheese";
				break;
			}
			
			Wing w = new Wing();
			w.setId(w.generateId());
			w.setName(name);
			w.setFnb(fnb);
			w.setSauceName(sauce);
			w.setPrice(price*quantity);
			
			PreparedStatement ps = connect.prepareStatement("INSERT INTO sodadrink (itemID, itemName, itemPrice, sauceName) VALUES (?,?,?,?)");
			
			try {
				ps.setString(1, w.getId());
				ps.setString(2, name);
				ps.setInt(3, w.getPrice());
				ps.setString(4, sauce);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			food.add(w);
			
			System.out.println("Detail Transaction");
			System.out.println("====================================================");
			System.out.printf("Customer : %s", name);
			System.out.printf("Email : %s", email);
			System.out.printf("Item : %s", w.getName());
			System.out.printf("Sauce : %s", w.getSauceName());
			System.out.printf("Quantity : %d", quantity);
			System.out.printf("Price : %d", price);
			System.out.printf("Total Price : %d", w.getPrice());
			System.out.println("====================================================");
			System.out.println("Press Enter to Continue...");
			scan.nextLine();
		}
		
	}
	
	public void viewList() {
		System.out.printf("|%-2s|%-5s|%-25s|%-10s|%-10s|%-10s|%-10s|\n", "No", "ID", "Item Name", "F/B", "Price", "Sauce", "Fee");
		int index = 1;
		if(food.isEmpty()) {
			System.out.println("no Data!");
		} else {
			for (Food f : food) {
				System.out.printf("|%-2s|%-5s|%-25s|%-10s|%-10s|%-10s|%-10s|\n", index++, f.getId(), f.getName(), f.getFnb(), f.getPrice(), f.getClass(), f.getPrice());
			}
		}
	}
	
	public void viewTransaction() {
		System.out.printf("|%-2s|%-5s|%-25s|%-10s|%-10s|%-10s|%-10s|\n", "No", "ID", "Item Name", "F/B", "Price", "Sauce", "Fee");
		int index = 1;
		if(food.isEmpty()) {
			System.out.println("no Data!");
		} else {
			for (Food f : food) {
				System.out.printf("|%-2s|%-5s|%-25s|%-10s|%-10s|%-10s|%-10s|\n", index++, f.getId(), f.getName(), f.getFnb(), f.getPrice(), f.getClass(), f.getPrice());
			}
		}
	}
	
	
	public void delete() {
		viewTransaction();
		int input = 0;
		
		do {
			System.out.println("Input Number to Delete [1-2]: ");
			input = scan.nextInt();
			scan.nextLine();
		} while (input < 1 || input > food.size());
		
		Food f = food.get(input - 1);
		
		if (f.getId().equals(input)) {
			PreparedStatement ps = connect.prepareStatement("DELETE FROM traansaction WHERE itemID = ?");
			
			try {
				ps.setInt(1, input);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		food.remove(input - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
