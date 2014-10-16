package com.penglecode.common.consts;

import org.springframework.beans.factory.annotation.Value;

public enum PaymentEnum {

	/**
	 * //需要注册一个Spring的类型转换器Converter<String,PaymentEnum>,转换字符值"支付宝::http://www.alipay.com/gateway" -> PaymentEnum.PAYMENT_ALIPA
	 */
	@Value("PAYMENT_ALIPAY::${payment.alipay.vendor}::${payment.alipay.payurl}")
	PAYMENT_ALIPAY;
	
	private String vendor;
	
	private String payUrl;

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getPayUrl() {
		return payUrl;
	}

	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
	
}
