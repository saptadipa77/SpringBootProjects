package com.gevernova.SpringBootProjects.HelloApp.HelloRestController;

import org.springframework.web.bind.annotation.*;
import com.gevernova.SpringBootProjects.HelloApp.dto.UserDTO;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    // UC1
    @GetMapping
    public String hello() {
        return "Hello from BridgeLabz";
    }

    // UC2
    @GetMapping("/query")
    public String helloQuery(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC3
    @GetMapping("/param/{name}")
    public String helloParam(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC4
    @PostMapping("/post")
    public String helloPost(@RequestBody UserDTO user) {
        return "Hello " + user.getFirstName() + " " +
                user.getLastName() + " from BridgeLabz";
    }

    // UC5
    @PutMapping("/put/{firstName}")
    public String helloPut(
            @PathVariable String firstName,
            @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}
