import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed from callable call().");
            return "This is the callable result.";
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException exception) {
            System.out.println("Something went wrong.");
        } catch (InterruptedException exception) {
            System.out.println("Thread running the task was interrupted.");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private final ArrayBlockingQueue<String> BUFFER;
    private final String COLOR = ThreadColor.ANSI_YELLOW;

    public MyProducer(ArrayBlockingQueue<String> buffer) {
        this.BUFFER = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(COLOR + "Adding..." + num);
                BUFFER.put(num);

                Thread.sleep(random.nextInt(750, 1000));
            } catch (InterruptedException e) {
                System.out.println("MyProducer was interrupted.");
            }
        }
        System.out.println(COLOR + "Adding EOF and exiting...");
        try {
            BUFFER.put("EOF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyConsumer implements Runnable {
    private final ArrayBlockingQueue<String> BUFFER;
    private final String COLOR;
    private final String RESET = ThreadColor.ANSI_RESET;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.BUFFER = buffer;
        this.COLOR = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (BUFFER) {
                try {
                    if (BUFFER.isEmpty()) {
                        continue;
                    }
                    if (BUFFER.peek().equals("EOF")) {
                        System.out.println(COLOR + "Exiting" + RESET);
                        break;
                    } else {
                        System.out.println(COLOR + "Removed " + BUFFER.take() + RESET);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
