package com.iyengarcoders.groceries.controllers;

import com.iyengarcoders.groceries.dto.PingDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1")
public class CommonController {

    @RequestMapping(value = "/ping", method = GET)
    public PingDto ping() {
        PingDto ping = new PingDto("Hello!! Groceries Server is running fine!!", new Date());
        return ping;
    }
}
