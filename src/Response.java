
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Hashtable;
/**
 *Abstract interface to handle and extend output context
 */
public interface Response {
    OutputStream getOutputStream() throws IOException;
    String getHeaderToString();
     Hashtable<String, String> getHeader();

     String getHttpVersion();

     void setHttpVersion(String httpVersion);

     String getServer();

     void setServer(String server);

     Date getDate();

     void setDate(Date date);

     String getContentType();

     void setContentType(String contentType);

     Integer getContentLength();

     void setContentLength(Integer contentLength);

    public String getStatus();

    public void setStatus(String status);


}
