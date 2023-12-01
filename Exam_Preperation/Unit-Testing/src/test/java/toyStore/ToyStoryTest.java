package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStoryTest {
    private ToyStore toyStore;

    @Before
    public void setToyStore() {
        this.toyStore = new ToyStore();
    }

    @Test
    public void testCreateToyStoreCreateEmptyLinkedMapWithNullToy() {
        Map<String, Toy> testMap = new LinkedHashMap<>();
        testMap.put("A", null);
        testMap.put("C", null);
        testMap.put("D", null);
        testMap.put("F", null);
        testMap.put("G", null);
        testMap.put("E", null);
        testMap.put("B", null);
        Assert.assertEquals(testMap, toyStore.getToyShelf());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetToyShelfMethodReturnUnmodifiableMap() {
        toyStore.getToyShelf().put("P", null);
        toyStore.getToyShelf().put("M", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyMethodThrowExceptionOnNonExistingShelf() throws OperationNotSupportedException {
        toyStore.addToy("P", new Toy("Bulgaria", "1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyMethodThrowExceptionOnTakenShelf() throws OperationNotSupportedException {
        toyStore.addToy("A", new Toy("Bulgaria", "1"));
        toyStore.addToy("B", new Toy("Greece", "2"));
        toyStore.addToy("A", new Toy("England", "3"));
    }

    @Test
    public void testAddToyMethodReturnsTrueOnExistingToy() throws OperationNotSupportedException {
        Toy toy = new Toy("BG", "1");
        toyStore.addToy("A", toy);
        Assert.assertTrue(toyStore.getToyShelf().containsValue(toy));
    }

    @Test
    public void testAddToyMethodReturnsFalseOnNonExistingToy() {
        Toy toy = new Toy("BG", "1");
        Assert.assertFalse(toyStore.getToyShelf().containsValue(toy));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyThrowExceptionOnExistingToy() throws OperationNotSupportedException {
        Toy toy = new Toy("BG", "1");
        toyStore.addToy("A", toy);

        Assert.assertEquals("Shelf is already taken!", toyStore.addToy("B", toy));
    }

    @Test
    public void testAddToySuccessfullyAddToy() throws OperationNotSupportedException {
        Toy firstToy = new Toy("BG", "1");
        String result = toyStore.addToy("A", firstToy);

        Assert.assertEquals("BG", toyStore.getToyShelf().get("A").getManufacturer());
        Assert.assertEquals("1", toyStore.getToyShelf().get("A").getToyId());

        Assert.assertEquals("Toy:1 placed successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyThrowExceptionOnNonExistingShelf() throws OperationNotSupportedException {
        Toy firstToy = new Toy("BG", "1");
        toyStore.addToy("A", firstToy);
        toyStore.removeToy("M", firstToy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyThrowExceptionOnNonExistingToy() {
        Toy firstToy = new Toy("BG", "1");
        toyStore.removeToy("A", firstToy);
    }

    @Test
    public void testRemoveToySuccessfullyRemoveToy() throws OperationNotSupportedException {
        Toy firstToy = new Toy("BG", "1");
        toyStore.addToy("A", firstToy);
        String result = toyStore.removeToy("A", firstToy);

        Assert.assertNull(toyStore.getToyShelf().get("A"));
        Assert.assertEquals("Remove toy:1 successfully!", result);
    }


}