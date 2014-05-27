package com.bartoszwalter.students.taxes.deal;

public class DealFactory {

	public static Deal getDeal(char type) throws UnsupportedDealException {
		if (type == 'P') {
			return new StandardDeal();
		} else if (type == 'Z') {
			return new OrderDeal();
		} else {
			throw new UnsupportedDealException("UnsupportedDeal: " + type);
		}
	}
}
