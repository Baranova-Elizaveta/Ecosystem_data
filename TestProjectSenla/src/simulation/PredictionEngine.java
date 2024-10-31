package simulation;

import models.Animals;
import models.Plants;
import enviroment.Environment;
import java.util.List;

public class PredictionEngine {

    public static String predictPopulationChange(Environment environment, List<Plants> plants, List<Animals> animals) {
        StringBuilder prediction = new StringBuilder();

        // Прогноз для растений
        for (Plants plant : plants) {
            if (environment.getWaterLevel() > 150 && environment.getTemperature() > 20) {
                prediction.append("Популяция растений ").append(plant.getName()).append(" будет расти.\n");
            } else if (environment.getWaterLevel() < 50 || environment.getTemperature() < 5) {
                prediction.append("Популяция растений ").append(plant.getName()).append(" будет сокращаться.\n");
            } else {
                prediction.append("Популяция растений ").append(plant.getName()).append(" останется стабильной.\n");
            }
        }

        // Прогноз для животных
        for (Animals animal : animals) {
            if (environment.getWaterLevel() > 100 && environment.getTemperature() > 15) {
                prediction.append("Популяция животных ").append(animal.getName()).append(" будет расти.\n");
            } else if (environment.getWaterLevel() < 30 || environment.getTemperature() < 5) {
                prediction.append("Популяция животных ").append(animal.getName()).append(" будет сокращаться.\n");
            } else {
                prediction.append("Популяция животных ").append(animal.getName()).append(" останется стабильной.\n");
            }
        }

        return prediction.toString();
    }
}
