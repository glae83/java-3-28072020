import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final Semaphore semaphore = new Semaphore(Main.CARS_COUNT / 2);

    public Tunnel(int length) {
        this.length = length;
        this.description = "������� " + length + " ������";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " ��������� � �����(����): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " ����� ����: " + description + ". ��� ��������: " + c.getSpeed());
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " �������� ����: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}