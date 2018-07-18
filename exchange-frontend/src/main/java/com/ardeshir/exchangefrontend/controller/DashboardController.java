package com.ardeshir.exchangefrontend.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@Controller
public class DashboardController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder.build();
    }
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @HystrixCommand(fallbackMethod = "getDefault")
    @GetMapping("/getprice")
    public String getCryptoPrice(Model model,@RequestParam String base,@RequestParam String target)
    {

        model.addAttribute("rate",restTemplate.getForObject("http://exchange-cryptocurrency-service/getprice?base="+base+"&"+"target="+target,String.class));
        return "home :: frg";
    }
    public String getDefault(Model model,String base,String target)
    {
        model.addAttribute("rate","100");
        return "home :: frg";
    }
}
