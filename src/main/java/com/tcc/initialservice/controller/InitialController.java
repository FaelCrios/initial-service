package com.tcc.initialservice.controller;

import com.tcc.initialservice.configuration.InitialConfiguration;
import com.tcc.initialservice.entity.Initial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class InitialController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private InitialConfiguration configuration;

    @RequestMapping("/initial")
    public Initial initial(
            @RequestParam(value="name",
            defaultValue="") String name){
        if(name.isEmpty()) name = configuration.getDefaultValue();
        return new Initial(counter.incrementAndGet(), String.format(template,configuration.getInitial(), name));
    }

}
