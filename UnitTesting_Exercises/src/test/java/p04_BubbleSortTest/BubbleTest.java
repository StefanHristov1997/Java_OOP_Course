package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {


    @Test
    public void testBubbleSortMethodWorkCorrectly() {
        int[] inputArr = {1, 8, 5, 3, 9, 2, 4, 7, 6};
        Bubble.sort(inputArr);
        int[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Assert.assertArrayEquals(inputArr, expectedResult);
    }
}