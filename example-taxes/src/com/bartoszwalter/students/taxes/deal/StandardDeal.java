package com.bartoszwalter.students.taxes.deal;

import com.bartoszwalter.students.taxes.view.Printer;

public class StandardDeal implements Deal {

	public String getName() {
		return "UMOWA O PRACĘ";
	}


	protected double kosztyUzyskania;
	protected double podstawa;
	public double getPodstawa() {
		return podstawa;
	}

	public void setPodstawa(double podstawa) {
		this.podstawa = podstawa;
	}


	protected Printer printer;

	public double getKosztyUzyskania() {
		return kosztyUzyskania;
	}

	public void setKosztyUzyskania(double kosztyUzyskania) {
		this.kosztyUzyskania = kosztyUzyskania;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void printCosts() {
		printer.println("Koszty uzyskania przychodu w stałej wysokości "
				+ kosztyUzyskania);

	}

	@Override
	public void free(double kwotaZmiejsz) {
		printer.println("Kwota wolna od podatku = " + kwotaZmiejsz);
	}

	@Override
	public double podatek(double kwotaZmiejsz, double zaliczkaNaPod) {
		return zaliczkaNaPod - kwotaZmiejsz;
	}
}
