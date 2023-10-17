package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1","value2","value3");
        // MappingJacksonValue : 필터 설정이 가능하게 함
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        // FilterProvider : 여러 필터를 정의할 수 있게 해줌
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

//    @GetMapping("/filtering-list")
//    public List<SomeBean> filteringList() {
//        return Arrays.asList(new SomeBean("value1","value2","value3"),
//                new SomeBean("value4","value5","value6"));
//
//    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
       List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3"),
                new SomeBean("value4","value5","value6"));
        // MappingJacksonValue : 필터 설정이 가능하게 함
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        // FilterProvider : 여러 필터를 정의할 수 있게 해줌
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}


















