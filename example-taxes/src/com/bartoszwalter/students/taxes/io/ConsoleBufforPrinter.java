package com.bartoszwalter.students.taxes.io;

public class ConsoleBufforPrinter extends ConsolePrinter {

	private StringBuilder sb=new StringBuilder();
	public StringBuilder getSb() {
		return sb;
	}

	@Override
	public void print(String text) {
		//super.print(text);
		sb.append(text);
	}

}
