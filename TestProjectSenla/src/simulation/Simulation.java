package simulation;

import enviroment.Environment;
import models.Animals;
import models.LivingBeing;
import models.Plants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    private Environment environment;
    private List<Plants> plants;
    private List<Animals> animals;
    private int temperature;
    private int humidity;
    private int waterLevel;
    private static final String LOG_FILE = "logs/simulation_log.txt";
    private Random random = new Random();

    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public int getHumidity(){
        return humidity;
    }

    public void setHumidity(int humidity){
        this.humidity = humidity;
    }

    public String getPopulationPrediction() {
        return PredictionEngine.predictPopulationChange(environment, plants, animals);
    }

    public int getWaterLevel(){
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel){
        this.waterLevel = waterLevel;
    }
    public Simulation() {
        this.environment = new Environment(25, 80, 200);
        this.plants = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void addPlant(Plants plant){
        plants.add(plant);
    }

    public void addAnimal(Animals animal){
        animals.add(animal);
    }

    public List<Plants> getPlants(){
        return plants;
    }

    public List<Animals> getAnimals(){
        return animals;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void runSimulation(){
        for (LivingBeing plant : plants){
            plant.interactWithEnvironment(environment);
        }

        for (LivingBeing animal : animals){
            animal.interactWithEnvironment(environment);
            for (LivingBeing plant : plants){
                animal.interactWithSpecies(plant);
            }
        }

        environment.simulateChanges();
    }


    public void startAutoSimulation(int cycles) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            for (int i = 1; i <= cycles; i++) {
                writer.write("Cycle " + i + ":\n");
                updateClimateConditions();
                updatePopulationDynamics();
                logState(writer);
                replenishResources();

                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог-файл: " + e.getMessage());
        }
    }

    private void updateClimateConditions() {
        environment.setTemperature(environment.getTemperature() + random.nextInt(5) - 2);
        environment.setWaterLevel(environment.getWaterLevel() + random.nextInt(5) - 2);
    }

    private void updatePopulationDynamics() {
        for (Plants plant : plants) {
            if (environment.getWaterLevel() > 100) {
                plant.setPopulation(plant.getPopulation() + random.nextInt(20));
            } else {
                plant.setPopulation(Math.max(plant.getPopulation() - random.nextInt(10), 0));
            }
        }

        for (Animals animal : animals) {
            if (environment.getWaterLevel() > 50 && environment.getTemperature() > 10) {
                animal.setPopulation(animal.getPopulation() + random.nextInt(15));
            } else {
                animal.setPopulation(Math.max(animal.getPopulation() - random.nextInt(15), 0));
            }
        }
    }

    private void logState(BufferedWriter writer) throws IOException {
        writer.write("Environment:\n");
        writer.write("Temperature: " + environment.getTemperature() + "\n");
        writer.write("Water Level: " + environment.getWaterLevel() + "\n");

        writer.write("Plants:\n");
        for (Plants plant : plants) {
            writer.write(plant.getName() + ": Population = " + plant.getPopulation() + "\n");
        }

        writer.write("Animals:\n");
        for (Animals animal : animals) {
            writer.write(animal.getName() + ": Population = " + animal.getPopulation() + "\n");
        }
    }

    private void replenishResources() {
        if (random.nextInt(10) < 2) {
            environment.setWaterLevel(environment.getWaterLevel() + 50);
        }
    }
}
