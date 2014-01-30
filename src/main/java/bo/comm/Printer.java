package bo.comm;

/**
 * Class Printer.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Printer {

    public void process(Object message) {
        System.out.println("received: " + message);
    }

    public String processAndReply(Object message) {
        System.out.println("received: " + message);
        return "ok";
    }

}
