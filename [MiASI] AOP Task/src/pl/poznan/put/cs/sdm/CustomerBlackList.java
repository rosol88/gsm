package pl.poznan.put.cs.sdm;

import java.util.LinkedList;

public class CustomerBlackList {
	
	//we don't like those customers because they steal our money!
	private LinkedList<String> exhiledCustomers = new LinkedList<String>();

	public CustomerBlackList() {
		exhiledCustomers.add("John Smith");
	}
	
	
	public boolean isCustomerBanned(Customer customer) {
		return exhiledCustomers.contains(customer.getName());
	}
	
	
	
}
