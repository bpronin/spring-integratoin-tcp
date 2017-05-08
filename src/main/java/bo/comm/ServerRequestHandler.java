package bo.comm;

/**
 * Class Printer.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class ServerRequestHandler {

    public Object process(Object message) {
        System.out.println("SERVER: replies on: " + message);
        return "OK";
    }

}
