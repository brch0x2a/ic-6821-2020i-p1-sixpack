package com.company;

import java.io.InputStream;
import java.util.Hashtable;

/**
 * Interface to manage the abstract class of a request, the request can not be modified
 * and you can only consult the information obtained through the socket sent by the client.
 */
public interface Request {
    String getMethod();
    InputStream getInputStream();
    String getHttpVersion();
    String getUrl();
    Hashtable<String, String> getHeader();
    String getHeaderString();
}
