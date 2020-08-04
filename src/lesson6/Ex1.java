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
public class Ex1 {

    private Array array;
    private int[] arr;
    private int[] temp;

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(
                new Object[][]{
                        {new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[] {1, 7}},
                        {new int[] {1, 2, 3, 4, 0, 4, 7, 8, 9}, new int[] {7, 8, 9}},
                        {new int[] {4, 1, 2, 3}, new int[] {1, 2, 3}},
                        {new int[] {4, 4, 2, 3}, new int[] {1, 2, 3}}
                }
        );
    }

    public Ex1(int[] arr, int[] res) {
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
        Assert.assertArrayEquals(temp, array.arrayCheck(arr));
    }
}