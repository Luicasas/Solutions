import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, reentrantLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, reentrantLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, reentrantLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {
    private final List<String> BUFFER;
    private final String COLOR = ThreadColor.ANSI_YELLOW;
    private final ReentrantLock REENTRANT_LOCK;

    public MyProducer(List<String> buffer, ReentrantLock reentrantLock) {
        this.BUFFER = buffer;
        this.REENTRANT_LOCK = reentrantLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(COLOR + "Adding..." + num);
                REENTRANT_LOCK.lock();
                try {
                    BUFFER.add(num);
                } finally {
                    REENTRANT_LOCK.unlock();
                }
                Thread.sleep(random.nextInt(750, 1000));
            } catch (InterruptedException e) {
                System.out.println("MyProducer was interrupted.");
            }
        }
        System.out.println(COLOR + "Adding EOF and exiting...");
        REENTRANT_LOCK.lock();
        try {
            BUFFER.add("EOF");
        } finally {
            REENTRANT_LOCK.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private final List<String> BUFFER;
    private final String COLOR;
    private final String RESET = ThreadColor.ANSI_RESET;
    private final ReentrantLock REENTRANT_LOCK;

    public MyConsumer(List<String> buffer, String color, ReentrantLock reentrantLock) {
        this.BUFFER = buffer;
        this.COLOR = color;
        this.REENTRANT_LOCK = reentrantLock;
    }

    @Override
    public void run() {
        long counter = 0L;
        while (true) {
            if (REENTRANT_LOCK.tryLock()) {
                try {
                    if (BUFFER.isEmpty()) {
                        continue;
                    }
                    if (BUFFER.get(0).equals("EOF")) {
                        System.out.println(COLOR + "Exiting" + RESET);
                        break;
                    } else {
                        System.out.println(COLOR + "Removed " + BUFFER.remove(0) + RESET);
                    }
                } finally {
                    REENTRANT_LOCK.unlock();
                }
            } else {
                ++counter;
            }
        }
        System.out.println(ThreadColor.ANSI_GREEN + counter + RESET);
    }
}
