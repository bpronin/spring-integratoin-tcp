package bo.comm;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class Initiator.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Initiator {

    private Service service;

    public Initiator(Service service) {
        this.service = service;
    }

    public void start() {
        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("INITIATOR: send hello");
                service.process("hello");
            }
        }, 100, TimeUnit.MILLISECONDS);
    }
}
