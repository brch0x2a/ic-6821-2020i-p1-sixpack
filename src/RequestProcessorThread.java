import java.net.*;
import java.io.*;

/**
 * This class represents a Thread to attend the request.
 * The constructor receives a socket and a RequestProcessorImpl instance.
 * This class creates a instance for Request using the InputStream for the
 * socket and an empty Response,
 */
public class RequestProcessorThread extends Thread{
    private Socket socket = null;
    private RequestProcessor requestProcessor;

    RequestProcessorThread(Socket socket, RequestProcessor requestProcessor){
        this.socket = socket;
        this.requestProcessor = requestProcessor;

    }

    /**
     * This method executes the sequence for the request.
     * Instances of Request and Response are created here.
     *
     * At the end of the process, the request and response are save into the log.
     */
    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                InputStream in = socket.getInputStream();
                ) {

            Request request = new RequestFactory.getRequest(in);
            Response response = new ResponseFactory.getResponse(out);

            requestProcessor.process(request, response);

            Log log = new Log.getInstance();
            log.save(request);
            log.save(response);

                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
