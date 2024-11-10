package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    private List<String> greetingHistory = new ArrayList<>();
    private static final String GREETING_FORMAT = "Hello, %s!";
    private int count = 0;
    
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        count++;
        String greeting = String.format(GREETING_FORMAT, name);
        greetingHistory.add(greeting);
        return greeting;
    }
    
    @GetMapping("/greetings/history")
    public List<String> getGreetingHistory() {
        return greetingHistory;
    }
    
    @GetMapping("/count")
    public int getCount() {
        return count;
    }
    
    private String formatGreeting(String n) {
        if(n != null) {
            if(n.length() > 0) {
                return String.format(GREETING_FORMAT, n);
            } else {
                return String.format(GREETING_FORMAT, "World");
            }
        } else {
            return String.format(GREETING_FORMAT, "World");
        }
    }
}