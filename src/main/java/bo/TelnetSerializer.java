package bo;

import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;

import java.io.*;

/**
 * Class TelnetSerializer.
 *
 * @author Boris Pronin (<a href="mailto:boprsoft.dev@gmail.com">boprsoft.dev@gmail.com</a>)
 */
public class TelnetSerializer implements Serializer<String>, Deserializer<String> {

    @Override
    public void serialize(String s, OutputStream out) throws IOException {
        out.write(s.getBytes());
    }

    @Override
    public String deserialize(InputStream in) throws IOException {
        String s = new BufferedReader(new InputStreamReader(in)).readLine();
        return s;
    }

}
