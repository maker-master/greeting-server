package io.plantgreeter.plantserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/plants")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public ResponseEntity<List<Plant>> getPlants() {
        return new ResponseEntity<>(plantService.getPlants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable Long id) {
        Plant plant = plantService.getPlant(id);
        HttpStatus status = plant != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(plant, status);
    }

    @PostMapping
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
        Plant createdPlant = plantService.createPlant(plant);
        return new ResponseEntity<>(createdPlant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant plant) {
        Plant updatedPlant = plantService.updatePlant(id, plant);
        return new ResponseEntity<>(updatedPlant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removePlant(@PathVariable Long id) {
        HttpStatus status = plantService.removePlant(id) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity(status);
    }

    @GetMapping("/{id}/greet")
    public ResponseEntity<String> getPlantGreeting(@PathVariable Long id) {
        String plantGreeting = plantService.getPlantGreeting(id);
        return new ResponseEntity<>(plantGreeting, HttpStatus.OK);
    }
}
