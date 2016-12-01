package com.rafsan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller
public class ViewController {

    private String appMode;

    @Autowired
    public ViewController(Environment environment){
        this.appMode = environment.getProperty("app-mode");
    }

    @RequestMapping(value = "/")
    public String index(ModelMap modelMap){

        modelMap.put("mode",appMode);
        modelMap.put("datetime",new Date());
        modelMap.put("developer","Rafsanjani");

        return "index";
    }
}
