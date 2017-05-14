package bo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class ReceiverApp {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("receiverClientContext.xml");

//        new ClassPathXmlApplicationContext("receiverContext.xml");
//        new ClassPathXmlApplicationContext("receiverGatewayContext.xml");
        System.in.read();
    }
}
