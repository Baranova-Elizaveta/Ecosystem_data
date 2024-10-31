package simulation;

import java.io.*;
import models.Animals;
import models.LivingBeing;
import models.Plants;
import simulation.Simulation;

public class SimulationLoader {

    public static void saveSimulation(String filename, Simulation simulation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("temperature=" + simulation.getTemperature() + "\n");
            writer.write("humidity=" + simulation.getHumidity() + "\n");
            writer.write("waterLevel=" + simulation.getWaterLevel() + "\n");

            for (LivingBeing plant : simulation.getPlants()) {
                writer.write("plant=" + plant.getName() + "," + plant.getPopulation() + "," + plant.getEnergyConsumption() + "\n");
            }

            for (LivingBeing animal : simulation.getAnimals()) {
                writer.write("animal=" + animal.getName() + "," + animal.getPopulation() + "," + animal.getEnergyConsumption() + "," + animal.getFoodConsumption() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении симуляции: " + e.getMessage());
        }
    }

    public static Simulation loadSimulation(String filename) {
        Simulation simulation = new Simulation();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length < 2) continue;

                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "temperature":
                        simulation.setTemperature(Integer.parseInt(value));
                        break;
                    case "humidity":
                        simulation.setHumidity(Integer.parseInt(value));
                        break;
                    case "waterLevel":
                        simulation.setWaterLevel(Integer.parseInt(value));
                        break;
                    case "plant":
                        String[] plantData = value.split(",");
                        Plants plant = new Plants(plantData[0], Integer.parseInt(plantData[1]), Integer.parseInt(plantData[2]));
                        simulation.addPlant(plant);
                        break;
                    case "animal":
                        String[] animalData = value.split(",");
                        Animals animal = new Animals(animalData[0], Integer.parseInt(animalData[1]), Integer.parseInt(animalData[2]), Integer.parseInt(animalData[3]));
                        simulation.addAnimal(animal);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
        }
        return simulation;
    }
}
