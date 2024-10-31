package models;

import enviroment.Environment;

public abstract class LivingBeing {
    protected String name;
    protected int population;
    protected int energyConsumption;
    protected int foodConsumption;

    public LivingBeing(String name, int population, int energyConsumption){
        this.name = name;
        this.population = population;
        this.energyConsumption = energyConsumption;
    }

    public String getName(){
        return name;
    }

    public int getPopulation(){
        return population;
    }

    public  void setPopulation(int population){
        this.population = population;
    }

    public int getEnergyConsumption(){
        return energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption){
        this.energyConsumption = energyConsumption;
    }

    public abstract void interactWithEnvironment(Environment environment);
    public abstract void interactWithSpecies(LivingBeing other);



        public int getFoodConsumption() {
            return foodConsumption;
        }

}
