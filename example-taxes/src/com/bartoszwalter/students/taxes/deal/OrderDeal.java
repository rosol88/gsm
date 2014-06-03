package com.bartoszwalter.students.taxes.deal;

public class OrderDeal extends StandardDeal{

	@Override
	public String getName(){
		return "UMOWA-ZLECENIE";
	}
	

	@Override
	public void printCosts() {
		kosztyUzyskania = (podstawa * 20) / 100;
		printer.println("Koszty uzyskania przychodu (stałe) "
				+ kosztyUzyskania);
		
	}


	@Override
	public void free(double kwotaZmiejsz) {
		return;
	}


	@Override
	public double podatek(double kwotaZmiejsz, double zaliczkaNaPod) {
		return zaliczkaNaPod;
	}
	
	
}
