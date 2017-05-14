package bo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class SenderApp {

    public static void main(String[] args) throws Exception {
//        new ClassPathXmlApplicationContext("senderContext.xml");
//        new ClassPathXmlApplicationContext("senderGatewayContext.xml");
        new ClassPathXmlApplicationContext("senderServerContext.xml");
        System.in.read();
    }
}
