package models;

import enviroment.Environment;

public class Plants extends LivingBeing {
    public Plants(String name, int population, int energyConsumption) {
        super(name, population, energyConsumption);
    }

    @Override
    public void interactWithEnvironment(Environment environment) {
        if (environment.getWaterLevel() > energyConsumption){
            environment.setWaterLevel(environment.getWaterLevel() - energyConsumption);
            population += 2;
        }else {
            population -= 1;
        }
    }

    @Override
    public void interactWithSpecies(LivingBeing other) {

    }
}
