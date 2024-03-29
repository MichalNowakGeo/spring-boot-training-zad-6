package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    @RequestMapping(path = {"/", "/hello" },method = RequestMethod.GET)

    public String helloWorld(@RequestParam(required = false, value = "name")String name){
        if(name == null){
            name = "World";
        }
        log.info(name);
        return "hello " + name + "!";
    }
}
