package bo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class ServerApp {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("serverContext.xml");
        System.in.read();
    }
}
