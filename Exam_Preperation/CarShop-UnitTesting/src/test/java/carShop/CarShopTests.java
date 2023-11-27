package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarShopTests {

    private CarShop cars;

    @Before
    public void setCars() {
        this.cars = new CarShop();
    }

    @Test
    public void testCreateCarShopCreateEmptyArrayList() {
        Assert.assertEquals(0, cars.getCars().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsMethodIsUnmodifiable() {
        Car fiat = new Car("Fiat", 90, 2300.00);
        cars.getCars().add(fiat);
    }

    @Test(expected = NullPointerException.class)
    public void testAddMethodThrowExceptionOnNullObject() {
        Car car = null;
        cars.add(car);
    }

    @Test
    public void testAddMethodSuccessfullyAddCars() {
        Car fiat = new Car("Fiat", 90, 2300);
        Car ford = new Car("Ford", 110, 6000);

        cars.add(fiat);
        Assert.assertEquals(1, cars.getCount());
        cars.add(ford);
        Assert.assertEquals(2, cars.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxHorsePower() {
        Car fiat = new Car("Fiat", 90, 2300);
        Car ford = new Car("Ford", 110, 6000);
        Car seat = new Car("Seat", 50, 5000);

        List<Car> fasterCars = new ArrayList<>();
        fasterCars.add(ford);
        fasterCars.add(fiat);

        cars.add(fiat);
        cars.add(ford);
        cars.add(seat);

        List<Car> result = cars.findAllCarsWithMaxHorsePower(80);

        Assert.assertEquals(fasterCars.size(), result.size());
    }

    @Test
    public void testRemoveMethodReturnFalse() {
        Car fiat = new Car("Fiat", 90, 2300);

        boolean result = cars.remove(fiat);
        Assert.assertFalse(result);
    }
    @Test
    public void testRemoveMethodReturnTrue() {
        Car fiat = new Car("Fiat", 90, 2300);

        cars.add(fiat);
        boolean result = cars.remove(fiat);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetTheMostLuxuryCar() {
        Car fiat = new Car("Fiat", 90, 2300);
        Car ford = new Car("Ford", 110, 6000);
        Car seat = new Car("Seat", 50, 5000);

        cars.add(fiat);
        cars.add(ford);
        cars.add(seat);

        Assert.assertEquals(ford, cars.getTheMostLuxuryCar());
    }

    @Test
    public void testGetTheMostLuxuryCarThrowException() {
        Assert.assertNull(cars.getTheMostLuxuryCar());
    }

    @Test
    public void testFindAllCarByModel() {
        Car fiat = new Car("Fiat", 90, 2300);
        Car ford = new Car("Ford", 110, 6000);
        Car seat = new Car("Fiat", 50, 5000);

        cars.add(fiat);
        cars.add(ford);
        cars.add(seat);

        List<Car> expectedResult = new ArrayList<>();
        expectedResult.add(fiat);
        expectedResult.add(seat);

        Assert.assertEquals(expectedResult, cars.findAllCarByModel("Fiat"));
    }

}

