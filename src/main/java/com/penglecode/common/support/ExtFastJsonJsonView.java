package com.penglecode.common.support;

import java.util.ArrayList;
import java.util.Map;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
/**
 * 扩展的FastJsonJsonView,增加类似于MappingJackson2JsonView的extractValueFromSingleKeyModel属性
 * 
 * @author	  	pengpeng
 * @date	  	2014年11月28日 上午9:44:57
 * @version  	1.0
 */
public class ExtFastJsonJsonView extends FastJsonJsonView {

	private boolean extractValueFromSingleKeyModel = false;
	
	public void setExtractValueFromSingleKeyModel(boolean extractValueFromSingleKeyModel) {
		this.extractValueFromSingleKeyModel = extractValueFromSingleKeyModel;
	}

	@SuppressWarnings("unchecked")
	protected Object filterModel(Map<String, Object> model) {
		Object modelObj = super.filterModel(model);
		if(modelObj != null && modelObj instanceof Map){
			Map<String,Object> modelMap = (Map<String, Object>) modelObj;
			if(modelMap.size() == 1 && extractValueFromSingleKeyModel){
				return new ArrayList<Object>(modelMap.values()).get(0);
			}
		}
		return modelObj;
	}

	
	
}
