package com.bartoszwalter.students.taxes.deal;

import com.bartoszwalter.students.taxes.view.Printer;

public interface Deal {

	String getName();

	void printCosts();
	
	public void setPrinter(Printer printer) ;
	public void setKosztyUzyskania(double kosztyUzyskania);
	void setPodstawa(double podstawa);
	void free(double kwotaZmiejsz);
	double podatek(double kwotaZmiejsz,double zaliczkaNaPod);
}
