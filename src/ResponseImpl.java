import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

/**
 * is related with the connection socket
 * when the file is reader we need to write the stream with write method
 * and flush, for the context we use out as a printWriter with the header data
 * all output need to close
 */

/**
 *Send bytes or binary stream to the client when match the request
 * Complements with the header and the ourstream
 */
public class ResponseImpl implements Response {
    private  String httpVersion;
    private  String server;
    private  Date   date;
    private  String contentType;
    private  Integer contentLength;
    private  Hashtable<String,String> header;
    private  OutputStream output;
    private  String status;


    /**
     *Contructor for create the holder of output data
     */
    public ResponseImpl(OutputStream output) {
        this.output = output;
        this.header = new Hashtable<>();
    }

    /**
     *retrieve the output holder for communication context purpose
     */
    @Override
    public OutputStream getOutputStream() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[]holder = getHeaderToString().getBytes();

        out.write(holder);
        out.close();

        output = out;

        return output;
    }

    /**
     * getHeaderToString converts the header to String, for logs effects
     *
     * */
    @Override
    public String getHeaderToString() {

        String headerString = "";
        for(Map.Entry m:header.entrySet()){
            headerString += m.getKey() + ": " +m.getValue() + System.lineSeparator();
        }
        return headerString;
    }

    /**
     *
     *getHeader retrive header object
     * */
    @Override
    public Hashtable<String, String> getHeader() {
        return header;
    }

    /**
     *
     *getHttpVersion
     * */
    @Override
    public String getHttpVersion() {
        return httpVersion;
    }
    /**
     *
     *setHttpVersion
     * */
    @Override
    public void setHttpVersion(String httpVersion) {
        this.header.put("HttpVersion", httpVersion);
        this.httpVersion = httpVersion;
    }

    /**
     *
     *getServer
     * */
    @Override
    public String getServer() {
        return server;
    }

    /**
     *
     *setServer
     * */
    @Override
    public void setServer(String server) {
        this.header.put("Server", server);
        this.server = server;
    }
    /**
     *
     *getDate
     * */
    @Override
    public Date getDate() {
        return date;
    }
    /**
     *
     *setDate
     * */
    @Override
    public void setDate(Date date) {
        this.header.put("Date", date.toString());
        this.date = date;
    }
    /**
     *
     *getContentType
     * */
    @Override
    public String getContentType() {
        return contentType;
    }
    /**
     *
     *setContentType
     * */
    @Override
    public void setContentType(String contentType) {
        this.header.put("ContentType", contentType);
        this.contentType = contentType;
    }
    /**
     *
     *getContentLength
     * */
    @Override
    public Integer getContentLength() {
        return contentLength;
    }
    /**
     *
     *setContentLength
     * */
    @Override
    public void setContentLength(Integer contentLength) {
        this.header.put("ContentLength", contentLength.toString());
        this.contentLength = contentLength;
    }
    /**
     *
     *getStatus
     * */
    @Override
    public String getStatus() {
        return status;
    }
    /**
     *
     *setStatus
     * */
    @Override
    public void setStatus(String status) {
        this.header.put("Status", status);
        this.status = status;
    }

}
