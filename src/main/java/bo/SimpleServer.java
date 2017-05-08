package bo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class SimpleServer.
 *
 * @author Boris Pronin (<a href="mailto:boprsoft.dev@gmail.com">boprsoft.dev@gmail.com</a>)
 */
public class SimpleServer {

    public static void main(String[] args) throws Throwable {
        ServerSocket ss = new ServerSocket(5555);
        while (true) {
            System.err.println("Listening...");
            Socket s = ss.accept();
            System.err.println("Client accepted");
            new Thread(new SocketProcessor(s)).start();
        }
    }

    private static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream is;
        private OutputStream os;

        private SocketProcessor(Socket s) throws Throwable {
            this.s = s;
            this.is = s.getInputStream();
            this.os = s.getOutputStream();
        }

        public void run() {
            try {
                String request = read();
                System.out.println("received:" + request);
                String response = "echo:" + request+"\n";
                write(response);
                System.out.println("sent:" + response);
            } catch (Throwable t) {
                /*do nothing*/
            } finally {
                try {
                    s.close();
                } catch (Throwable t) {
                    /*do nothing*/
                }
            }
            System.err.println("Client processing finished");
        }

        private void write(String s) throws Throwable {
            os.write(s.getBytes());
            os.flush();

        }

        private String read() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            return br.readLine();
        }
    }
}

