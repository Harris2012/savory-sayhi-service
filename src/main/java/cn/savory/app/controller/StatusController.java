package cn.savory.app.controller;

import cn.savory.app.Healthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    Healthy healthy;

    @ResponseBody
    @RequestMapping(value = "up", method = RequestMethod.GET)
    public String setStatusUp() {

        healthy.setUp(true);

        return "status is set to up";
    }

    @ResponseBody
    @RequestMapping(value = "down", method = RequestMethod.GET)
    public String setStatusDown() {
        healthy.setUp(false);

        return "status is set to down";
    }
}
