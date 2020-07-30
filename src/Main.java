import java.util.concurrent.CountDownLatch;
public class Main {
    public static final int CARS_COUNT = 4;
    public static volatile boolean winner = false;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(
                new Road(60),
                new Tunnel(100),
                new Road(40)
        );
        Car[] cars = new Car[CARS_COUNT];
        CountDownLatch carReady = new CountDownLatch(CARS_COUNT);
        CountDownLatch carFinish = new CountDownLatch(CARS_COUNT);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), carReady, carFinish);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            carReady.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            carFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}