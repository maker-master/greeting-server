package io.plantgreeter.greetingserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class GreetingController {

    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("api/v1/greetings")
    public ResponseEntity<List<Greeting>> getGreetings() {
        List<Greeting> greetings = greetingService.getGreetings();
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

    @GetMapping("api/v1/greetings/random")
    public ResponseEntity<Greeting> getRandomGreeting() {
        List<Greeting> greetings = greetingService.getGreetings();
        int randomIndex = new Random().nextInt(greetings.size());
        Greeting randomGreeting = greetings.get(randomIndex);
        return new ResponseEntity<>(randomGreeting, HttpStatus.OK);
    }
}
