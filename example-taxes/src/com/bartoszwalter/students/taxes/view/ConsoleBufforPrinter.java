package com.bartoszwalter.students.taxes.view;

public class ConsoleBufforPrinter extends ConsolePrinter {

	private StringBuilder sb;
	@Override
	public void print(String text) {
		super.print(text);
		sb.append(text);
	}

}
