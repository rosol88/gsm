package gsm.model;

public class Bill {

	public Bill(Phone phone, double price) {
		
	}

	private double price;
	private Phone phone;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	
}
