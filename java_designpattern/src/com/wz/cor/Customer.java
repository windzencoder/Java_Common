package com.wz.cor;

import com.wz.cor.handler.PriceHandler;
import com.wz.cor.handler.PriceHandlerFactory;

/*
 * 客户类，请求折扣
 */
public class Customer {

	private PriceHandler priceHandler;
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	
	public void requestDiscount(float discount) {
		priceHandler.processDiscount(discount);
	}
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		customer.requestDiscount(0.96f);
	}
	
}
