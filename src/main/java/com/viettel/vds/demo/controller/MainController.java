package com.viettel.vds.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${env_version}")
    private String envVersion;

    @GetMapping(value = "/")
    @ResponseBody
    public String get() {
	int b = 1/0;
        try {
            return "Hello from " + envVersion;
        } catch (Exception e) {
            e.printStackTrace();
            return "Config not found";
        }
    }

}
