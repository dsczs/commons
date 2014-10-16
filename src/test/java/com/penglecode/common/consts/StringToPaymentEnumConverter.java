package com.penglecode.common.consts;

import org.springframework.core.convert.converter.Converter;

public class StringToPaymentEnumConverter implements Converter<String, PaymentEnum> {

	public PaymentEnum convert(String source) {
		if(source != null){
			String[] sources = source.split("::");
			if(sources.length == 3){
				PaymentEnum pe = PaymentEnum.valueOf(sources[0]);
				pe.setVendor(sources[1]);
				pe.setPayUrl(sources[2]);
				return pe;
			}
		}
		return null;
	}

}
