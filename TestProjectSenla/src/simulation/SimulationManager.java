package simulation;

import models.Animals;
import models.Plants;
import java.util.Scanner;

public class SimulationManager {

    private Simulation simulation;

    public SimulationManager(Simulation simulation) {
        this.simulation = simulation;
    }

    // Добавление растения
    public void addPlant(String name, int population, int energyConsumption) {
        Plants plant = new Plants(name, population, energyConsumption);
        simulation.addPlant(plant);
        System.out.println("Растение добавлено: " + name);
    }

    // Добавление животного
    public void addAnimal(String name, int population, int energyConsumption, int foodConsumption) {
        Animals animal = new Animals(name, population, energyConsumption, foodConsumption);
        simulation.addAnimal(animal);
        System.out.println("Животное добавлено: " + name);
    }

    // Удаление растения
    public void removePlant(String name) {
        simulation.getPlants().removeIf(plant -> plant.getName().equals(name));
        System.out.println("Растение удалено: " + name);
    }

    // Удаление животного
    public void removeAnimal(String name) {
        simulation.getAnimals().removeIf(animal -> animal.getName().equals(name));
        System.out.println("Животное удалено: " + name);
    }

    // Задание параметров экосистемы
    public void setEnvironment(int temperature, int humidity, int waterLevel) {
        simulation.setTemperature(temperature);
        simulation.setHumidity(humidity);
        simulation.setWaterLevel(waterLevel);
    }
}
