package pl.poznan.put.cs.sdm;

import java.util.ArrayList;
import java.util.List;

public class RentalService {

	 private static CustomerBlackList blackList =new CustomerBlackList();
	 
	 public static CustomerBlackList getBlackList(){
		 return blackList;
	 }
	public RentalService() {
		int x=1;
		if(x==0)
		throw new RuntimeException("sadsadsa");
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("David Kovalsky");
		Customer customer2 = new Customer("John Smith");

		customers.add(customer1);
		customers.add(customer2);

		Movie movie1 = new Movie("Beethoven", Movie.CHILDRENS);
		Movie movie2 = new Movie("Matrix", Movie.REGULAR);
		Movie movie3 = new Movie("Avatar", Movie.NEW_RELEASE);
		Movie movie4 = new Movie("Kill Bill", Movie.REGULAR);

		Rental rental1 = new Rental(movie1, 4);
		Rental rental2 = new Rental(movie1, 4);
		Rental rental3 = new Rental(movie2, 2);
		Rental rental4 = new Rental(movie3, 1);
		Rental rental5 = new Rental(movie4, 3);

		customer1.addRental(rental1);
		customer1.addRental(rental2);
		customer1.addRental(rental3);

		customer2.addRental(rental4);
		customer2.addRental(rental5);
		

		for (Customer customer : customers) {
			System.out.println("<SUMMARY>");
			System.out.println(customer.statement());
			System.out.println("</SUMMARY>");
		}
	}

	public static void main(String[] args) {
		new RentalService();
	}
}
