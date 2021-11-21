package com.spring.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
    //URI Versioning
    //this method is for the first version that returns the entire name
    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Mr. Sam");
    }

    //this method is for the second version that returns firstName and lastName separately
    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Mr.", "Sam"));
    }

    //Versioning using Request Parameter
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 personV3(){
        return new PersonV1("Mr. Sam");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 personV4(){
        return new PersonV2(new Name("Mr.", "Sam"));
    }

    //
    @GetMapping(value = "/person/header", headers = "X-API-Version=1")
    public PersonV1 headerV1()
    {
        return new PersonV1("Tom Cruise");
    }

    @GetMapping(value = "/person/header", headers = "X-API-Version=2")
    public PersonV2 headerV2()
    {
        return new PersonV2(new Name("Tom", "Cruise"));
    }
}
