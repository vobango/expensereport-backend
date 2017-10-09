package com.reach_u.expensereport.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @RequestMapping("/expense")
    public String e() {
        return "GET works.";
    }
}
