package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {

    private final static String SERVICE_NAME = "Test";
    private final static int CAPACITY = 3;

    private Service service;

    @Before
    public void setService() {
        this.service = new Service(SERVICE_NAME, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateServiceThrowExceptionOnNullName() {
        this.service = new Service(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateServiceThrowExceptionOnEmptyName() {
        this.service = new Service("", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateServiceThrowExceptionOnNegativeCapacity() {
        this.service = new Service("TEST", -10);
    }

    @Test
    public void testCreateServiceWithValidNameAndCapacity() {
        this.service = new Service("TEST", 2);
    }

    @Test
    public void testGetNameMethodReturnFieldName() {
        Assert.assertEquals(SERVICE_NAME, service.getName());
    }

    @Test
    public void testGetCapacityMethodReturnFieldCapacity() {
        Assert.assertEquals(CAPACITY, service.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowExceptionOnFullCapacity() {
        Robot robotTest1 = new Robot("Pesho");
        Robot robotTest2 = new Robot("Gosho");
        Robot robotTest3 = new Robot("Grisho");
        Robot robotTest4 = new Robot("Denis");
        service.add(robotTest1);
        service.add(robotTest2);
        service.add(robotTest3);
        service.add(robotTest4);
    }

    @Test
    public void testAddMethodSuccessfullyAddRobot() {
        Robot robotTest1 = new Robot("Pesho");
        Robot robotTest2 = new Robot("Gosho");

        service.add(robotTest1);
        Assert.assertEquals(1, service.getCount());
        service.add(robotTest2);
        Assert.assertEquals(2, service.getCount());
    }

    @Test
    public void testGetCountMethodSuccessfullyReturnRobotsSize() {
        Robot robotTest1 = new Robot("Pesho");
        Assert.assertEquals(0, service.getCount());
        service.add(robotTest1);
        Assert.assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodThrowExceptionOnNonExistRobot() {
        service.remove("Invalid");
    }

    @Test
    public void testRemoveMethodSuccessfullyRemoveRobot() {
        Robot robotTest1 = new Robot("Pesho");
        service.add(robotTest1);
        service.remove(robotTest1.getName());
        Assert.assertEquals(0, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleMethodThrowExceptionOnNonExistRobot() {
        service.forSale("Invalid");
    }

    @Test
    public void testForSaleMethod() {
        Robot robotTest1 = new Robot("Pesho");
        service.add(robotTest1);
        Robot robot = service.forSale(robotTest1.getName());
        Assert.assertFalse(robot.isReadyForSale());
    }

    @Test
    public void testReportMethod() {
        Robot robotTest1 = new Robot("Pesho");
        Robot robotTest2 = new Robot("Gosho");
        Robot robotTest3 = new Robot("Grisho");
        service.add(robotTest1);
        service.add(robotTest2);
        service.add(robotTest3);

        String expectedResult = "The robot Pesho, Gosho, Grisho is in the service Test!";
        Assert.assertEquals(expectedResult,service.report());
    }


}
