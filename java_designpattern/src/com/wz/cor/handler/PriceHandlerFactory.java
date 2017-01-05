package com.wz.cor.handler;

public class PriceHandlerFactory {

	public static PriceHandler createPriceHandler() {
		PriceHandler sales = new Sales();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler ceo = new CEO();
		
		sales.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(ceo);
		
		return sales;
	}

}
