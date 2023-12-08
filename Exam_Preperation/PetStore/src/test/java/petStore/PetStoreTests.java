package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    private PetStore petStore;

    @Before
    public void setAnimals() {
        this.petStore = new PetStore();
    }

    @Test
    public void testCreatePetStoreCreateEmptyList() {
        Assert.assertEquals(0, petStore.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimalsReturnsUnmodifiableList() {
        Animal animal = new Animal("Mammal", 10, 10.50);
        petStore.getAnimals().add(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalThrowExceptionOnNullAnimal() {
        Animal animal = null;
        petStore.addAnimal(animal);
    }

    @Test
    public void testAddAnimalSuccessfullyAddAnimal() {
        Animal animal1 = new Animal("Mammal", 10, 10.50);
        Animal animal2 = new Animal("Reptile", 8, 12.50);
        petStore.addAnimal(animal1);
        Assert.assertEquals(1, petStore.getCount());
        Assert.assertEquals("Mammal", petStore.getAnimals().get(0).getSpecie());
        petStore.addAnimal(animal2);
        Assert.assertEquals(2, petStore.getCount());
        Assert.assertEquals("Reptile", petStore.getAnimals().get(1).getSpecie());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        Animal animal1 = new Animal("Mammal", 10, 10.50);
        Animal animal2 = new Animal("Reptile", 8, 12.50);
        Animal animal3 = new Animal("Birds", 11, 10.50);
        Animal animal4 = new Animal("Amphibians", 2, 12.50);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);

        List<Animal> result = petStore.findAllAnimalsWithMaxKilograms(5);

        List<Animal> animalsWithMaxKg = List.of(animal1, animal2, animal3);

        Assert.assertEquals(animalsWithMaxKg, result);
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        Animal animal1 = new Animal("Mammal", 10, 10.50);
        Animal animal2 = new Animal("Reptile", 8, 12.50);
        Animal animal3 = new Animal("Birds", 11, 13.50);
        Animal animal4 = new Animal("Amphibians", 2, 20.50);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);

        Animal result = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(animal4, result);
    }

    @Test
    public void testGetTheMostExpensiveAnimalReturnNull() {
        Animal result = petStore.getTheMostExpensiveAnimal();
        Assert.assertNull(result);
    }

    @Test
    public void testFindAllAnimalBySpecie() {
        Animal animal1 = new Animal("Mammal", 10, 10.50);
        Animal animal2 = new Animal("Reptile", 8, 12.50);
        Animal animal3 = new Animal("Mammal", 11, 13.50);
        Animal animal4 = new Animal("Amphibians", 2, 20.50);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        petStore.addAnimal(animal4);

        List<Animal> mammals = petStore.findAllAnimalBySpecie("Mammal");
        List<Animal> expectedResult = List.of(animal1,animal3);

        Assert.assertEquals(expectedResult, mammals);
    }
}

