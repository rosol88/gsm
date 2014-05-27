package com.bartoszwalter.students.taxes.deal;

public class StandardDeal implements Deal{

	public String getName(){
		return "UMOWA O PRACĘ";
	}

	@Override
	public void getCosts() {
		printer.println("Koszty uzyskania przychodu w stałej wysokości "
				+ kosztyUzyskania);
		
	}
}
