package bo.comm;

/**
 * Class Printer.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class Printer {

    private String prefix = "";

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void process(Object message) {
        System.out.println(prefix + "received: " + message);
    }

    public String processAndReply(Object message) {
        System.out.println(prefix + "received: " + message);
        return "ok";
    }

}
