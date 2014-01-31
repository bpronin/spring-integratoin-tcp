package bo.comm;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class SimpleServer.
 *
 * @author Boris Pronin (<a href="mailto:bpronin@bttprime.com">bpronin@bttprime.com</a>)
 */
public class SimpleServer {

    private ServerSocket socket;
    private ObjectOutputStream out;
    private final AtomicBoolean connected = new AtomicBoolean();

    public SimpleServer() {
    }

    public void run() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                listen();
            }
        });
    }

    private void listen() {
        try {
            socket = new ServerSocket(7101);
            out = new ObjectOutputStream(socket.accept().getOutputStream());
            connected.set(true);
            while (connected.get()) ;
        } catch (IOException x) {
            connected.set(false);
            x.printStackTrace();
        } finally {
            stop();
        }
//        listen();
    }

    private void stop() {
        try {
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(Object message) {
        if (connected.get()) {
            try {
                out.writeObject(message);
                out.flush();
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}
