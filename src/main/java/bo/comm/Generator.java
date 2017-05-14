package bo.comm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class Generator.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Generator {

    private int maxIterations = 3;
    private Service service;
    private String prefix;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Generator(Service service) {
        this.service = service;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void start() {
/*
        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    send(i);
                }
                System.out.println(System.currentTimeMillis() - start);
            }
        }, 100, TimeUnit.MILLISECONDS);
*/
        final AtomicInteger iteration = new AtomicInteger();
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                send(format.format(new Date()));
                if (iteration.incrementAndGet() >= maxIterations){
                    executor.shutdown();
//                    System.exit(0);
                }
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    private void send(Object message) {
        try {
            System.out.println(prefix + ": sent:" + message);
            service.process(message);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
