package com.codeup.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MathController {

    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String respond (@PathVariable int x, @PathVariable int y) {
        int sum = x + y;
        return x + " plus "+ y + " is " + sum + "!";
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtractNums(@PathVariable int x, @PathVariable int y) {
        int difference = y - x;
        return x + " subtracted from "+ y + " is " + difference + "!";
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiplyNums(@PathVariable int x, @PathVariable int y) {
        int product = x * y;
        return x + " multiplied by "+ y + " is " + product + "!";
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public String divideNums(@PathVariable int x, @PathVariable int y) {
        int dividend = x / y;
        return x + " divided by "+ y + " is " + dividend + "!";
    }
}