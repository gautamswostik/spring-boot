package com.example.firstapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HelloController {

    @GetMapping("/maya")
    public List gettName() {
        return List.of(new Person("Swostik", "Gautam"), new Person("Bidisha", "Koirala"));
    }

    @GetMapping("/mydetails")
    public HashMap myDetails() {
        HashMap<String, String> details = new HashMap<>();

        details.put("name", "Swostik Gautam");
        details.put("partner", "Bidisha Koirala");
        details.put("current_address" , "Sydney, Australia");
        details.put("qualification" , "Bachelors in Computer Science and Information Technology");
        details.put("friend_in_sydney" , "Sunil Kumar Gupta");

        return details;
    }

    record Person(int id, String name, String surname) {
        // 1. Static counter (allowed inside a record!)
        private static int count = 0;

        // 2. Extra constructor that takes ONLY name and surname
        public Person(String name, String surname) {
            this(++count, name, surname); // Calls the main record constructor with auto-incremented ID
        }
    }

}
