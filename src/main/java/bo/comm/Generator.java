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
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                send();
            }
        }, 1000, 500, TimeUnit.MILLISECONDS);
    }

    private void send() {
        Object message = new Date();
        try {
            System.out.println("sending:" + message);
            service.process(message);
            System.out.println("sent:" + message);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
