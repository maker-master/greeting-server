package io.plantgreeter.plantserver;

import ch.qos.logback.core.spi.PreSerializationTransformer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.List;

@Service
public class PlantService {

    private PlantRepository plantRepository;

    private GreetingClient greetingClient;

    public PlantService(PlantRepository plantRepository, GreetingClient greetingClient) {
        this.plantRepository = plantRepository;
        this.greetingClient = greetingClient;
    }

    public List<Plant> getPlants() {
        return plantRepository.list();
    }

    public Plant getPlant(Long id) {
        return plantRepository.findById(id);
    }

    public Plant createPlant(Plant plant) {
        return plantRepository.create(plant);
    }

    public Plant updatePlant(Long id, Plant plant) {
        return plantRepository.update(id, plant);
    }

    public boolean removePlant(Long id) {
        return plantRepository.delete(id);
    }

    public String getPlantGreeting(Long id) {
        Greeting greeting = greetingClient.getRandomGreeting();
        Plant plant = plantRepository.findById(id);
        String plantGreeting = greeting.getMessage() + " " + plant.getName();

        return plantGreeting;
    }
}
