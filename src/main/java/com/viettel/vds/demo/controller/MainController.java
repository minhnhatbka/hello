package com.viettel.vds.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;

@RestController
public class MainController {

    @Value("classpath:config/config.yml")
    Resource resourceFile;

    @GetMapping(value = "/")
    @ResponseBody
    public String get() {
        try {
            return new String(Files.readAllBytes(resourceFile.getFile().toPath()));
        } catch (Exception e) {
            return "Config not found";
        }
    }

}
