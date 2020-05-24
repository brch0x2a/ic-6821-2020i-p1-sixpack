package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Hashtable;
/**
 *Abstract interface to handle and extend output context
 */
public interface Response {
    OutputStream getOutputStream() throws IOException;
    String toString();

    public void setURL(String URL);
    public void setMETHOD(String METHOD);
    public void setHTTP_VERSION(String HTTP_VERSION);
    public void setSERVER(String SERVER);
    public void setSTATUS(String STATUS);
    public void setCONTENT_TYPE(String CONTENT_TYPE);
    public void setCONTENT_LENGTH(String CONTENT_LENGTH);
    public void setLAST_MODIFIED(String LAST_MODIFIED);
    public void setCONNECTION(String CONNECTION);
    public void setACCEPT_RANGES(String ACCEPT_RANGES);
}
