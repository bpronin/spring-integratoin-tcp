package bo;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Jdk14Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class Main.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class BiDirectionalApp {

    public static void main(String[] args) throws Exception {
        ((Jdk14Logger) LogFactory.getLog("org.springframework")).getLogger().setLevel(java.util.logging.Level.WARNING);
        new ClassPathXmlApplicationContext("biDirectional.xml");
    }

}
