package com.spring.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("Amit", "9999999999","39000");
    }

    //returning a list of SomeBeans as response
    @RequestMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBeans()
    {
        return Arrays.asList(new SomeBean("Saurabh", "8888888888","20000"), new SomeBean("Devesh", "1111111111","34000"));
    }

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveListOfSomeBeans1(){
        SomeBean someBean=new SomeBean("Amit", "9999999999","39000");
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name", "salary");
        FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue retrieveListOfSomeBeansList(){
        List<SomeBean> list = Arrays.asList(new SomeBean("Saurabh", "8888888888","20000"),
                                            new SomeBean("Devesh", "1111111111","34000"));
        //invoking static method filterOutAllExcept()
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "phone");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        //constructor of MappingJacksonValue class that has list as constructor argument
        MappingJacksonValue mapping = new MappingJacksonValue(list);

        mapping.setFilters(filters);
        return mapping;
    }
}
