package com.wz.cor.handler;

/*
 * 销售总监，可以批准40%以内的折扣
 */
public class Director extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.40) {
			System.out.format("%s批准了折扣：%.2f", this.getClass().getName(), discount);
		}else{
			successor.processDiscount(discount);
		}
	}

}
