package ru.ostanin.springdemo.config.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        System.out.println(String.format("Hello, %s %s", name, surname));
        model.addAttribute("message", String.format("Hello, %s %s!", name, surname));

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    //hometask
    @GetMapping("/calculator")
    public String calculatePage(@RequestParam("a")String a, @RequestParam("b")String b,
                                @RequestParam("action")String action, Model model) {

        String result = null;
        switch (action) {
            case "multiplication":
                result = String.valueOf(Double.parseDouble(a) * Double.parseDouble(b));
                break;
            case "add":
                result = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
                break;
            case "substraction":
                result = String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
                break;
            case "division":
                result = String.valueOf(Double.parseDouble(a) / Double.parseDouble(b));
                break;
        }
        
        model.addAttribute("result", String.format("%s %s with %s = %s", a, action, b, result));
        return "first/calculator";
    }
}
