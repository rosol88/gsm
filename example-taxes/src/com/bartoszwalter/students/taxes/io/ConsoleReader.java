package com.bartoszwalter.students.taxes.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bartoszwalter.students.taxes.view.Reader;

public class ConsoleReader implements Reader {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	@Override
	public String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
