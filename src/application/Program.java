package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Client client = new Client(name, email, birthDate);
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int quantity = sc.nextInt();
		
		for (int i = 1; i <= quantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProd = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int qtdProd = sc.nextInt();
			
			Product product = new Product(nameProd, price);			
			OrderItem item = new OrderItem(qtdProd, price, product);
			
			order.addItem(item);					
		}
		
		System.out.println();
		System.out.print("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
