package com.pp.rest.filters.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.pp.rest.filters.vos.DynamicSomeBean;

@RestController
public class DynamicFilterController {
	@GetMapping("/dynamicfilteredbean")
	public MappingJacksonValue getFilteredBean() {
		DynamicSomeBean dynamicSomeBean = new DynamicSomeBean("value1","value2","value3");
		
		MappingJacksonValue mapping=new MappingJacksonValue(dynamicSomeBean);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("dynamicBean", filter);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/dynamicfiltered-list")
	public MappingJacksonValue getFilteredList() {
		List<DynamicSomeBean> values = Arrays
				.asList(new DynamicSomeBean("value1","value2","value3"),
						new DynamicSomeBean("value12","value22","value32"));
		MappingJacksonValue mapping=new MappingJacksonValue(values);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("dynamicBean", filter);
		mapping.setFilters(filters);
		return mapping;
		
	}
}
