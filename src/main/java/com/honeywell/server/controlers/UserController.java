package com.honeywell.server.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/user")
    List<String> all() {
        return new ArrayList<>(
                List.of("user"));
    }
}
