package lesson6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Ex2 {

    private Array array;
    private int[] arr;
    private boolean temp;


    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{1, 1, 1, 4}, true},
                        {new int[]{4, 4, 4, 1}, true},
                        {new int[]{5, 6, 2, 2}, false},
                        {new int[]{1, 1, 1, 1}, false},
                        {new int[]{4, 4, 4, 4}, false}
                }
        );
    }

    public Ex2(int[] arr, boolean res) {
        this.arr = arr;
        this.temp = res;
    }

    @Before
    public void init() {
        array = new Array();
    }

    @After
    public void tearDown() throws Exception { array = null; }

    @Test
    public void testArrayCheck() {
        Assert.assertEquals(array.booleanCheck(arr), temp);
    }
}