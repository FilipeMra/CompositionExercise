package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Client Data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYY): ");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/MM/yyyy"); 
		String date = sc.nextLine();
		LocalDate localDate = LocalDate.parse(date, fmt);
				
		Client client = new Client(name, email, localDate);
		
		System.out.println();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		LocalDateTime dateNow = LocalDateTime.now();
		
		Order order = new Order(dateNow, status, client);
		
		System.out.println();
		System.out.print("How many items to add to his order?");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i<n; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println(order);
		
		
		
		
		
		sc.close();
		

	}

}
