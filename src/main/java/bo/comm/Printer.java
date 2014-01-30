package bo.comm;

/**
 * Class Printer.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Printer implements Service{

    public void process(Object message) {
        System.out.println("received: " + message);
    }
}
