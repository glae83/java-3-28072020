package lesson6;

import java.util.Arrays;

public class Array {

    public int[] arrayCheck(int[] array) {

        int index = 0;
        int[] arr;

        if(array.length == 0) {
            throw new NullPointerException();
        } else {
            for (int i = 0; i < array.length; ++i) {
                if (array[i] == 4) {
                    index = i + 1;
                }
            }
            if(index > 0) {
                arr = Arrays.copyOfRange(array, index, array.length);
                System.out.println(Arrays.toString(arr));
            } else {
                throw new RuntimeException();
            }
        }
        return arr;
    }

    public boolean booleanCheck(int[] array) {

        int check1 = 0;
        int check4 = 0;

        for (int anArray : array) {
            if (anArray == 1) { check1 = check1 + 1; }
            if (anArray == 4) { check4 = check4 + 1; }
        }
        return check1 > 0 && check4 > 0;
    }
}
