package enviroment;

public class Environment {
    private int temperature;
    private int humidity;
    private int waterLevel;

    public Environment(int temperature, int humidity, int waterLevel){
        this.temperature = temperature;
        this.humidity = humidity;
        this.waterLevel = waterLevel;
    }

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

    public int getWaterLevel(){
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel){
        this.waterLevel = waterLevel;
    }

    public void simulateChanges(){
        waterLevel -= 5;
        temperature -= 1;
    }
}
