package com.bartoszwalter.students.taxes.io;

public class ConsoleBufforPrinter extends ConsolePrinter {

	private StringBuilder sb=new StringBuilder();
	public StringBuilder getSb() {
		return sb;
	}
	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}
	@Override
	public void print(String text) {
		super.print(text);
		sb.append(text);
	}

}
