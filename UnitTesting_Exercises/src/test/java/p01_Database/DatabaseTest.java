package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public final static Integer[] ARRAY_NUMBERS = {1, 2, 3, 4, 5, 6};
    private Database database;

    @Before
    public void setDatabase() throws OperationNotSupportedException {
        this.database = new Database(ARRAY_NUMBERS);
    }

    @Test
    public void testConstructorsCreateValidArray() {
        Integer[] elements = database.getElements();;
        Assert.assertArrayEquals(elements, database.getElements());
    }

    @Test (expected = OperationNotSupportedException.class )
    public void testArrayWithMoreElementsThanGivenCapacityThrowException() throws OperationNotSupportedException {
        Database database = new Database(new Integer[17]);

    }

    @Test (expected = OperationNotSupportedException.class )
    public void testArrayWithZeroElementsThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void testAddOperationAddElementToTheNextFreeCell() throws OperationNotSupportedException {
        database.add(15);
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, ARRAY_NUMBERS.length + 1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(15));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddOperationThrowExceptionForNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveOperationRemoveElementAtTheLastIndex() throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, ARRAY_NUMBERS.length - 1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(5));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveOperationRemoveElementFromEmptyArrayThrowException() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

}