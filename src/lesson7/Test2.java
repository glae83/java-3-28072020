package lesson7;

public class Test2 {

    @AfterSuite
    public static void taskAfter(){
        System.out.println(Test2.class.getSimpleName() + " After");
    }

    @Test(priority = 2)
    public static void task1() {
        System.out.println(Test2.class.getSimpleName() + " Ex1");
    }
    @Test(priority = 3)
    public static void task2() {
        System.out.println(Test2.class.getSimpleName() + " Ex2");
    }
    @Test(priority = 8)
    public static void task3() {
        System.out.println(Test2.class.getSimpleName() + " Ex3");
    }
}