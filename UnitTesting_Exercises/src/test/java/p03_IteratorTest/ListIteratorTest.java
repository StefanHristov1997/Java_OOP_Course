package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    public final static String[] strings = {"Stefan", "Krasimir", "Vladislav"};
    private ListIterator listIterator;

    @Before
    public void setListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(strings);
    }

    @Test
    public void testConstructorCreatCorrectObject() {
        String[] returnArray = listIterator.getElements().toArray(new String[0]);
        Assert.assertArrayEquals(returnArray, strings);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParameter() throws OperationNotSupportedException {
       this.listIterator = new ListIterator(null);
    }

    @Test
    public void testMethodHasNextSuccessfullyReturnTrueValue() {
        listIterator.setCurrentIndex(1);
        boolean expectedResult = listIterator.getCurrentIndex() < listIterator.getElements().size() - 1;
        Assert.assertEquals(expectedResult, listIterator.hasNext());
    }

    @Test
    public void testMethodHasNextSuccessfullyReturnFalseValue() {
        listIterator.setCurrentIndex(2);
        boolean expectedResult = listIterator.getCurrentIndex() < listIterator.getElements().size() - 1;
        Assert.assertEquals(expectedResult, listIterator.hasNext());
    }

    @Test
    public void testMethodMoveSuccessfullyMoveElementToTheNextIndex() {
        int index = 1;
        if (listIterator.hasNext()) {
            listIterator.move();
        }
        Assert.assertEquals(index, listIterator.getCurrentIndex());
    }

    @Test
    public void testMethodMoveSuccessfullyReturnFalse() {
        listIterator.setCurrentIndex(2);
        boolean expectedResult = listIterator.hasNext();
        boolean result = listIterator.move();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testPrintMethodReturnElementAtInternalIndex() {
        String expectedResult = listIterator.getElements().get(0);
        String result = listIterator.print();
        Assert.assertEquals(expectedResult, result);
    }

    @Test (expected = IllegalStateException.class)
    public void testPrintMethodThrowExceptionWhenSizeIsZero() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        listIterator.print();
    }
}