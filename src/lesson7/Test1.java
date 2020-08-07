package lesson7;

public class Test1 {

    @BeforeSuite
    public static void taskBefore() {
        System.out.println(Test1.class.getSimpleName() + " Before");
    }

    @Test(priority = 5)
    public static void task1() {
        System.out.println(Test1.class.getSimpleName() + " Ex1");
    }

    @Test(priority = 3)
    public static void task2() {
        System.out.println(Test1.class.getSimpleName() + " Ex2");
    }

    @Test(priority = 10)
    public static void task3() {
        System.out.println(Test1.class.getSimpleName() + " Ex3");
    }

    @Test(priority = 3)
    public static void task4() {
        System.out.println(Test1.class.getSimpleName() + " Ex4");
    }

    @AfterSuite
    public static void taskAfter() {
        System.out.println(Test1.class.getSimpleName() + " After");
    }
}