package lesson6;

public class App
{
    public static void main( String[] args ) {
        Array array = new Array();
        int[] arr = {1, 2, 4, 4, 2, 0, 4, 1, 7};
        array.arrayCheck(arr);
        System.out.println(array.booleanCheck(arr));
    }
}
