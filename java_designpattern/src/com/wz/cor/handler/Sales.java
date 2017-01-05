package com.wz.cor.handler;

/*
 * 销售人员，可以批准5%以内的折扣
 */
public class Sales extends PriceHandler{

	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.05) {
			System.out.format("%s批准了折扣：%.2f", this.getClass().getName(), discount);
		}else{
			successor.processDiscount(discount);
		}
	}
	
}
