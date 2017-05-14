package bo;

import bo.comm.Service;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Jdk14Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class TelnetClientApp {

    public static void main(String[] args) throws Exception {
        ((Jdk14Logger) LogFactory.getLog("org.springframework")).getLogger().setLevel(java.util.logging.Level.WARNING);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("telnetClientContext.xml");
        Service gateway = context.getBean("gatewayToServer", Service.class);
        gateway.process("status");
        context.close();
    }

}
