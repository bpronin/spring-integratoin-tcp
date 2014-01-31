package bo.comm;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class Generator.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Generator {

    private Service service;

    public Generator(Service service) {
        this.service = service;
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

        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                send(new Date());
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    private void send(Object message) {
        try {
//            System.out.println("GENERATOR: sending:" + message);
            service.process(message);
            System.out.println("GENERATOR: sent:" + message);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
