package com.bartoszwalter.students.taxes.view;


public class PrinterFactory {

	public static Printer getPrinter(){
		return new ConsolePrinter();
	}
}
