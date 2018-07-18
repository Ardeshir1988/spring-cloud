package com.ardeshir.exchangecryptocurrencyservice.controller;


import com.ardeshir.exchangecryptocurrencyservice.domain.ApiObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class GetPriceController {
    @GetMapping("/getprice")
    public String getPriceRequest(@RequestParam("base") String base, @RequestParam("target") String target)
    {
        RestTemplate restTemplate=new RestTemplate();
        ApiObject apiObject=restTemplate.getForObject("https://api.cryptonator.com/api/ticker/"+base+"-"+target,ApiObject.class);
        return apiObject != null ? apiObject.getTicker().getPrice().toString() : null;
    }
}
