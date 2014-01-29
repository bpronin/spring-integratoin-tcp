package bo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class ClientServerApp {

    public static void main(String[] args) throws Exception {
//        new ClassPathXmlApplicationContext("clientContext.xml");
//        new ClassPathXmlApplicationContext("serverContext.xml");
        new ClassPathXmlApplicationContext("testContext.xml");
    }

}
