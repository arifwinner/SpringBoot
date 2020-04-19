package com.areef.springBootExample.springboot_demo.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFlterController {

	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retriveSomeBean() {
		SomeBeanDynamic sBean = new SomeBeanDynamic("Arif", "007", "pasword");
		SimpleBeanPropertyFilter beanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "id");
		FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", beanPropertyFilter);

		MappingJacksonValue jacksonValue = new MappingJacksonValue(sBean);
		jacksonValue.setFilters(provider);
		return jacksonValue;
	}

	@GetMapping("/dynamic-filterings")
	public MappingJacksonValue listSomeBean() {
		List<SomeBeanDynamic> asList = Arrays.asList(new SomeBeanDynamic("Arif", "007", "pasword"),
				new SomeBeanDynamic("Arif2", "0072", "pasword2"));

		SimpleBeanPropertyFilter beanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", beanPropertyFilter);
		MappingJacksonValue jacksonValue = new MappingJacksonValue(asList);
		jacksonValue.setFilters(provider);

		return jacksonValue;
	}

}
