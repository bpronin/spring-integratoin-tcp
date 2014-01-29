package bo;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class Generator.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Generator {

    private Service gateway;

    public Generator(Service service) {
        this.gateway = service;
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
        Date message = new Date();
        System.out.println("sending:" + message);

        try {
            gateway.process(message.toString());
            System.out.println("sent:" + message);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
