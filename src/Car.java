import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private CountDownLatch carReady;
    private CountDownLatch carFinish;
    private Race race;
    private int speed;
    private String name;

    static {
        CARS_COUNT = 0;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch carReady, CountDownLatch carFinish) {
        this.race = race;
        this.speed = speed;
        this.carReady = carReady;
        this.carFinish = carFinish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            carReady.countDown();
            carReady.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if (i == race.getStages().size() - 1) {
                if (!Main.winner) {
                    Main.winner = true;
                    System.out.println("Победитель: " + getName());
                }
            }
        }
        carFinish.countDown();
    }
}