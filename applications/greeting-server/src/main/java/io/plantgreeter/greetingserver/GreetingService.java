package io.plantgreeter.greetingserver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public List<Greeting> getGreetings() {
        return greetingRepository.list();
    }
}
