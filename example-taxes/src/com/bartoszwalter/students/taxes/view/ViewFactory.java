package com.bartoszwalter.students.taxes.view;

import com.bartoszwalter.students.taxes.io.ConsolePrinter;
import com.bartoszwalter.students.taxes.io.ConsoleReader;


public class ViewFactory {

	public Printer getPrinter(){
		return new ConsolePrinter();
	}
	public Reader getReader(){
		return new ConsoleReader();
	}
	
}
