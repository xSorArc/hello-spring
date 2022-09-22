package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles requests at path /hello   EX: localhost:8080/hello
//    @GetMapping("hello")  // Without the ("hello") we could only call this from localhost:8080
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // With @RequestMapping("hello") above class this lives at /hello/goodbye
    // Handles requests at path /goodbye   EX: localhost:8080/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // With @RequestMapping("hello") above class this lives at /hello/hello
    // Handles to get and post request at /hello?name=LaunchCode using query string
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}) // value removed makes this return at /hello
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";  // Dynamic request handler
    }

    // With @RequestMapping above class this lives at /hello/hello
    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}") // hello/ removed fixes the double hello path
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +       // Submit a request to /hello
                "<input type='text' name='name'/>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
