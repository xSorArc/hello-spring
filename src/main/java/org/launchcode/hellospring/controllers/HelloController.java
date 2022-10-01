package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HelloController {

    // Handles requests at path /hello   EX: localhost:8080/hello
//    @GetMapping("hello")  // Without the ("hello") we could only call this from localhost:8080
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // With @RequestMapping("hello") above class, this lives at /hello/goodbye
    // Handles requests at path /goodbye   EX: localhost:8080/goodbye
    @ResponseBody
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // With @RequestMapping("hello") above class, this lives at /hello/hello
    // Handles to get and post request at /hello?name=LaunchCode using query string
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";  // Dynamic request handler
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form") //Handles requests at /form
    public String helloForm() {
        return "form";
    }

//    @ResponseBody
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    public static String createMessage(@RequestParam String name, @RequestParam String lang) {
//        String phrase = "";
//        if (Objects.equals(lang, "english")) {
//            phrase = "Hello, ";
//        } else if (Objects.equals(lang, "spanish")) {
//            phrase = "Hola, ";
//        } else if (Objects.equals(lang, "french")) {
//            phrase = "Bonjour, ";
//        } else if (Objects.equals(lang, "german")) {
//            phrase = "Hallo, ";
//        } else if (Objects.equals(lang, "korean")) {
//            phrase = "Annyeonghaseyo, ";
//        }
//        return phrase + name + "!";
//    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Launchcode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "helloList";
    }
}
