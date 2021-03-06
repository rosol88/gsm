package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

import com.bartoszwalter.students.taxes.deal.Deal;
import com.bartoszwalter.students.taxes.deal.DealFactory;
import com.bartoszwalter.students.taxes.deal.UnsupportedDealException;
import com.bartoszwalter.students.taxes.view.Printer;
import com.bartoszwalter.students.taxes.view.Reader;
import com.bartoszwalter.students.taxes.view.ViewFactory;

public class TaxCalculator {

	// składki na ubezpieczenia społeczne
	public static double s_emerytalna = 0; // 9,76% podstawyy
	public static double s_rentowa = 0; // 1,5% podstawy
	public static double u_chorobowe = 0; // 2,45% podstawy
	// składki na ubezpieczenia zdrowotne
	public static double kosztyUzyskania = 111.25;
	public static double s_zdrow1 = 0; // od podstawy wymiaru 9%
	public static double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %
	public static double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
	public static double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek
												// 46,33 PLN
	public static double zaliczkaUS = 0;
	public static double zaliczkaUS0 = 0;
	private static Printer printer;
	private ViewFactory vw;
	private Reader reader;

	public ViewFactory getViewFactory() {
		if (vw == null) {
			vw = new ViewFactory();
		}
		return vw;
	}

	public static void main(String[] args) {
		new TaxCalculator().run();
	}

	public void run() {
		init();
		Double podstawa = readAmount();
		if (podstawa == null)
			return;
		char umowa = readType();

		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");

		try {
			double oPodstawa = obliczonaPodstawa(podstawa);
			
			Deal deal =DealFactory.getDeal(umowa);
			deal.setKosztyUzyskania(kosztyUzyskania);
			deal.setPrinter(printer);
			deal.setPodstawa(oPodstawa);
			print(deal,podstawa,oPodstawa,df00,df);
			
		} catch (UnsupportedDealException e) {
			printer.println("Nieznany typ umowy!");
		}
	}

	private void print(Deal deal, Double podstawa, double oPodstawa,
			DecimalFormat df00,DecimalFormat df) {
		printBase(deal,podstawa,oPodstawa,df00);
		deal.printCosts();
		printTax(deal,df,df00,podstawa);
		
	}

	private void printTax(Deal deal,DecimalFormat df,DecimalFormat df00,double podstawa) {
		double podstawaOpodat = deal.podatek(kwotaZmiejsz, zaliczkaNaPod);
		double podstawaOpodat0 = Double.parseDouble(df
				.format(podstawaOpodat));
		printer.println("Podstawa opodatkowania " + podstawaOpodat
				+ " zaokrąglona " + df.format(podstawaOpodat0));
		obliczPodatek(podstawaOpodat0);
		printer.println("Zaliczka na podatek dochodowy 18 % = "
				+ zaliczkaNaPod);
		deal.free(kwotaZmiejsz);
		double podatekPotracony = deal.podatek(kwotaZmiejsz, zaliczkaNaPod);
		printer.println("Podatek potrącony = "
				+ df00.format(podatekPotracony));
		obliczZaliczke();
		zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
		printer.println("Zaliczka do urzędu skarbowego = "
				+ df00.format(zaliczkaUS) + " po zaokrągleniu = "
				+ df.format(zaliczkaUS0));
		double wynagrodzenie = podstawa
				- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
		printer.println();
		printer.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
						+ df00.format(wynagrodzenie));
		
	}

	private void printBase(Deal deal, Double podstawa, double oPodstawa,
			DecimalFormat df00) {
		printer.println(deal.getName());
		printer.println("Podstawa wymiaru składek " + podstawa);
		
		printer.println("Składka na ubezpieczenie emerytalne "
				+ df00.format(s_emerytalna));
		printer.println("Składka na ubezpieczenie rentowe    "
				+ df00.format(s_rentowa));
		printer.println("Składka na ubezpieczenie chorobowe  "
				+ df00.format(u_chorobowe));
		printer.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
						+ oPodstawa);
		obliczUbezpieczenia(oPodstawa);
		printer.println("Składka na ubezpieczenie zdrowotne: 9% = "
				+ df00.format(s_zdrow1) + " 7,75% = "
				+ df00.format(s_zdrow2));
		
	}

	private char readType() {
		printer.print("Typ umowy: (P)raca, (Z)lecenie: ");
		return reader.readLine().charAt(0);
	}

	private Double readAmount() {
		try {
			printer.print("Podaj kwotę dochodu: ");
			return Double.parseDouble(reader.readLine());
		} catch (Exception ex) {
			printer.println("Błędna kwota");
			printer.println(ex.toString());
			return null;
		}

	}

	private void init() {
		ViewFactory vf = getViewFactory();
		printer = vf.getPrinter();
		reader = vf.getReader();
	}

	public static void obliczZaliczke() {
		zaliczkaUS = zaliczkaNaPod - s_zdrow2 - kwotaZmiejsz;
	}

	public static void obliczPodatek(double podstawa) {
		zaliczkaNaPod = (podstawa * 18) / 100;
	}

	public static double obliczonaPodstawa(double podstawa) {
		s_emerytalna = (podstawa * 9.76) / 100;
		s_rentowa = (podstawa * 1.5) / 100;
		u_chorobowe = (podstawa * 2.45) / 100;
		return (podstawa - s_emerytalna - s_rentowa - u_chorobowe);
	}

	public static void obliczUbezpieczenia(double podstawa) {
		s_zdrow1 = (podstawa * 9) / 100;
		s_zdrow2 = (podstawa * 7.75) / 100;
	}

	public void setViewFactory(ViewFactory vw) {
		this.vw = vw;

	}
}
