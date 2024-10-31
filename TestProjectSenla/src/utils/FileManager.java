package utils;

import models.LivingBeing;
import simulation.Simulation;

import java.io.*;
import java.util.List;

public class FileManager {
    public static void saveSimulation(Simulation simulation, String filename) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/" + filename))){
            writer.write("Environment:\n");
            writer.write("temperature = " + simulation.getEnvironment().getTemperature() + "\n");
            writer.write("humidity = " + simulation.getEnvironment().getHumidity() + "\n");
            writer.write("waterLevel = " + simulation.getEnvironment().getWaterLevel() + "\n\n");

            writer.write("Plants:\n");
            for (LivingBeing plant : simulation.getPlants()){
                writer.write("name=" + plant.getName() + ",population=" + plant.getPopulation()
                        + ",energyConsumption=" + plant.getEnergyConsumption() + "\n");
            }

            writer.write("Animals:\n");
            for (LivingBeing animal : simulation.getAnimals()){
                writer.write("name=" + animal.getName() + ",population=" + animal.getPopulation()
                        + ",energyConsumption=" + animal.getEnergyConsumption() + "\n");
            }
        }
    }

    public static Simulation loadSimulation(String filename) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader("data/" + filename))){
            return new Simulation();
        }
    }
}
