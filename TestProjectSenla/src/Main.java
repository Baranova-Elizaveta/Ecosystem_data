import simulation.Simulation;
import simulation.SimulationLoader;
import simulation.SimulationManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла симуляции: ");
        String filename = scanner.nextLine();

        Simulation simulation = SimulationLoader.loadSimulation(filename);
        SimulationManager manager = new SimulationManager(simulation);
        String prediction = simulation.getPopulationPrediction();
        System.out.println("Прогноз изменения популяций:");
        System.out.println(prediction);

        Simulation simulation1 = SimulationLoader.loadSimulation(filename);

        System.out.print("Введите количество циклов симуляции: ");
        int cycles = scanner.nextInt();
        simulation1.startAutoSimulation(cycles);

        System.out.println("Автоматическая симуляция завершена. Проверьте файл логов для деталей.");

        boolean running = true;
        while (running) {
            System.out.println("1. Добавить растение\n2. Добавить животное\n3. Удалить растение\n4. Удалить животное\n5. Установить параметры экосистемы\n6. Сохранить симуляцию\n0. Выйти");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите название растения: ");
                    String plantName = scanner.next();
                    System.out.print("Введите популяцию: ");
                    int plantPopulation = scanner.nextInt();
                    System.out.print("Введите потребление энергии: ");
                    int plantEnergy = scanner.nextInt();
                    manager.addPlant(plantName, plantPopulation, plantEnergy);
                    break;
                case 2:
                    System.out.print("Введите название животного: ");
                    String animalName = scanner.next();
                    System.out.print("Введите популяцию: ");
                    int animalPopulation = scanner.nextInt();
                    System.out.print("Введите потребление энергии: ");
                    int animalEnergy = scanner.nextInt();
                    System.out.print("Введите потребление пищи: ");
                    int animalFood = scanner.nextInt();
                    manager.addAnimal(animalName, animalPopulation, animalEnergy, animalFood);
                    break;
                case 3:
                    System.out.print("Введите название растения для удаления: ");
                    String removePlantName = scanner.next();
                    manager.removePlant(removePlantName);
                    break;
                case 4:
                    System.out.print("Введите название животного для удаления: ");
                    String removeAnimalName = scanner.next();
                    manager.removeAnimal(removeAnimalName);
                    break;
                case 5:
                    System.out.print("Введите температуру: ");
                    int temperature = scanner.nextInt();
                    System.out.print("Введите влажность: ");
                    int humidity = scanner.nextInt();
                    System.out.print("Введите уровень воды: ");
                    int waterLevel = scanner.nextInt();
                    manager.setEnvironment(temperature, humidity, waterLevel);
                    break;
                case 6:
                    SimulationLoader.saveSimulation(filename, simulation);
                    System.out.println("Симуляция сохранена в файл " + filename);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
        scanner.close();
    }
}
