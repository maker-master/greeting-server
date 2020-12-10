package io.plantgreeter.plantserver;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestOperations;

public class GreetingClient {

    private final RestOperations restOperations;
    private final String greetingServerEndpoint;
    private final Greeting defaultGreeting = new Greeting("DefaultHello");

    public GreetingClient(RestOperations restOperations,
                          String greetingServerEndpoint) {
        this.restOperations = restOperations;
        this.greetingServerEndpoint = greetingServerEndpoint;
    }

    @HystrixCommand(fallbackMethod = "getDefaultGreeting")
    public Greeting getRandomGreeting() {
        String endpoint = greetingServerEndpoint + "/api/v1/greetings/random";
        return restOperations.getForObject(endpoint, Greeting.class);
    }

    public Greeting getDefaultGreeting() {
        return defaultGreeting;
    }
}
