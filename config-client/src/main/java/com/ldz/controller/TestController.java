package com.ldz.controller;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;
    
    @Value("${current.env}")
    private String env;

    @Value("${dev-prop:null}")
    private String dev;
    
    @Value("${test-prop:null}")
    private String test;
    
    @RequestMapping("/from")
    public String from() {
        return this.from;
    }
    
    @GetMapping("/env")
    public String env() {
    	return this.env;
    }
    
    @GetMapping("info")
    public String info() {
    	String info = "info: ";
    	if (StringUtils.isNotBlank(dev)) {
    		info += dev;
    	}
    	if (StringUtils.isNotBlank(test)) {
    		info += "  " + test;
    	}
    	return info;
    }

}