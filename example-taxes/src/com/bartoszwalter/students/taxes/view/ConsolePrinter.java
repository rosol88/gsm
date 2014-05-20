package com.bartoszwalter.students.taxes.view;

public class ConsolePrinter implements Printer{

	@Override
	public void print(String text) {
		System.out.print(text);
	}

	@Override
	public void println(String text) {
		print(text+"\n");
	}
	@Override
	public void println() {
		print("\n");
	}

}
