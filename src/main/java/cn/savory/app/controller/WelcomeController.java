package cn.savory.app.controller;

import com.google.common.base.Strings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHi() {

        return "hi";
    }

    @RequestMapping(value = "first", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "second")
    public String first(String name) {

        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("name");
        }

        return "hi, " + name;
    }

    public String second(String name) {

        return "second";
    }
}
