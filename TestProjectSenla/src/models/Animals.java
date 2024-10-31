package models;

import enviroment.Environment;

public class Animals extends LivingBeing{
    private int foodConsumption;

    public Animals(String name, int population, int energyConsumption, int foodConsumption) {
        super(name, population, energyConsumption);
        this.foodConsumption = foodConsumption;
    }

    @Override
    public void interactWithEnvironment(Environment environment) {
        if (environment.getTemperature() < 0 || environment.getWaterLevel() < energyConsumption){
            population -= 1;
        }
    }

    @Override
    public void interactWithSpecies(LivingBeing other) {
        if (other instanceof Plants && other.getPopulation() > foodConsumption){
            other.setPopulation(other.getPopulation() - foodConsumption);
            population += 1;
        }
    }
}
