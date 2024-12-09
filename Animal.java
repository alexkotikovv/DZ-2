import java.util.ArrayList;
import java.util.List;

//
interface Animal {
    String getBreed();
    String getName();
    Double getCost();
    String getCharacter();
}

// 
abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;

    public AbstractAnimal(String breed, String name, Double cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }
}

//
class Predator extends AbstractAnimal {
    public Predator(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }
}

// Класс Pet
class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }
}

// 
class CreateAnimalService {
    
    //
    public List<Animal> createDefaultAnimals() {
        List<Animal> animals = new ArrayList<>();
        int count = 0;

        while (count < 10) {
            Animal animal = createUniqueAnimal(count);
            animals.add(animal);
            System.out.println("Создано животное: " + animal.getName());
            count++;
        }
        
        return animals;
    }

    //
    public List<Animal> createAnimals(int n) {
        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Animal animal = createUniqueAnimal(i);
            animals.add(animal);
            System.out.println("Создано животное: " + animal.getName());
        }

        return animals;
    }

    //
    public List<Animal> createAnimalsDoWhile(int n) {
        List<Animal> animals = new ArrayList<>();
        int count = 0;

        do {
            Animal animal = createUniqueAnimal(count);
            animals.add(animal);
            System.out.println("Создано животное: " + animal.getName());
            count++;
        } while (count < n);

        return animals;
    }

    // 
    private Animal createUniqueAnimal(int index) {
        if (index % 2 == 0) {
            return new Predator("Порода" + index, "Хищник" + index, 100.0 + index, "Агрессивный");
        } else {
            return new Pet("Порода" + index, "Домашний" + index, 50.0 + index, "Доброжелательный");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CreateAnimalService animalService = new CreateAnimalService();

        System.out.println("Создание 10 уникальных животных:");
        animalService.createDefaultAnimals();

        System.out.println("\nСоздание N животных (5):");
        animalService.createAnimals(5);

        System.out.println("\nСоздание N животных с использованием do-while (3):");
        animalService.createAnimalsDoWhile(3);
    }
}
