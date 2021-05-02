package com.pp.rest.filters.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.rest.filters.vos.SomeBean;
//statically filtering the bean properties returned from the controller
//using @JsonIgnore and   on the SomeBean properties 
@RestController
public class StaticFilterController {

	@GetMapping("/filteredbean")
	public SomeBean getFilteredBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtered-list")
	public List<SomeBean> getFilteredList() {
		return Arrays
				.asList(new SomeBean("value1","value2","value3"),
						new SomeBean("value12","value22","value32"));
		
	}
}
