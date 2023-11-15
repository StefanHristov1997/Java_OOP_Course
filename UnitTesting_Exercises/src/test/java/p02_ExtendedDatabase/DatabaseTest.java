package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public final static Person[] PEOPLE = {new Person(5, "Stefan"),
            new Person(8, "Georgi"),
            new Person(2, "Mitko")};
    private Database database;

    @Before
    public void setDatabase() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorsCreateValidDatabase() throws OperationNotSupportedException {
        Assert.assertArrayEquals(database.getElements(), PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayWithMoreElementsThanGivenCapacityThrowException() throws OperationNotSupportedException {
        Database database = new Database(new Person[17]);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayWithZeroElementsThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }


    @Test
    public void testAddOperationAddPeopleToTheLastIndex() throws OperationNotSupportedException {
        database.add(new Person(5, "Krasimir"));
        Person[] testPeople = database.getElements();

        Assert.assertEquals(testPeople.length, PEOPLE.length + 1);
        Assert.assertEquals(testPeople[testPeople.length - 1].getId(), 5);
        Assert.assertEquals(testPeople[testPeople.length - 1].getUsername(), "Krasimir");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddOperationTryingToAddNullElementThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveOperationRemoveElementAtTheLastIndex() throws OperationNotSupportedException {
        database.remove();
        Person[] people = database.getElements();
        Assert.assertEquals(people.length, PEOPLE.length - 1);
        Assert.assertEquals(people[people.length - 1].getId(), 8);
        Assert.assertEquals(people[people.length - 1].getUsername(), "Georgi");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOperationRemoveElementFromEmptyArrayThrowException() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test
    public void testMethodFindByUsernameFindPersonWithSameName() throws OperationNotSupportedException {
        Assert.assertEquals(database.getElements()[0], database.findByUsername("Stefan"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testMethodFindByUsernameNotPresentGivenUsernameThrowException() throws OperationNotSupportedException {
        database.findByUsername("Vladislav");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testMethodFindByUsernameWithNullParameterThrowException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testMethodFindByIdFindPersonWithSameId() throws OperationNotSupportedException {
        Assert.assertEquals(database.getElements()[0], database.findById(PEOPLE[0].getId()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testMethodFindByIdWithNotPresentGivenIdThrowException() throws OperationNotSupportedException {
        database.findById(15);
    }


}