package io.pcf.greetingserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

@RestController
public class GreetingController {

    private List<Greeting> greetings = Arrays.asList(
            new Greeting(1L, "Message 1"),
            new Greeting(2L, "Message 2"),
            new Greeting(3L, "Message 3")
    );

    @GetMapping("api/v1/greetings")
    public ResponseEntity<List<Greeting>> getGreetings() {
        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

    @GetMapping("api/v1/greetings/random")
    public ResponseEntity<Greeting> getRandomGreeting() {
        int randomIndex = new Random().nextInt(3);
        Greeting randomGreeting = greetings.get(randomIndex);
        return new ResponseEntity<>(randomGreeting, HttpStatus.OK);
    }
}
