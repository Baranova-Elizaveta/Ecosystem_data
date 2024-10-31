package models;

import enviroment.Environment;

public class PopulationPrediction {
    public String predictPopulationChange(LivingBeing species, Environment environment){
        int tempImpact = (environment.getTemperature() > 25) ? -1 : 1;
        int waterImpact = (environment.getWaterLevel() > species.getEnergyConsumption()) ? 1 : -1;

        if (species instanceof Plants){
            if (waterImpact > 0){
                return species.getName() + ": увеличится";
            } else {
                return species.getName() + ": уменьшается";
            }
        }else if (species instanceof Animals){
            if (tempImpact > 0 && waterImpact > 0){
                return species.getName() + ": увеличивается";
            }else if (tempImpact < 0 || waterImpact < 0){
                return species.getName() + ": уменьшается";
            }else {
                return species.getName() + ": останется стабильной";
            }
        }
        return species.getName() + ": неизвестно";
    }
}
