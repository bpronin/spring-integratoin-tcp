package bo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class ClientServerInvertedApp {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("clientServerInvertedContext.xml");
//        new ClassPathXmlApplicationContext("senderServerContext.xml");
//        new ClassPathXmlApplicationContext("receiverClientContext.xml");
    }

}
