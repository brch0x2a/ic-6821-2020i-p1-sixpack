package com.company;

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
    private   String URL="URL";
    private   String METHOD="Method";
    private   String HTTP_VERSION="HtttpVersion";
    private   String SERVER="Server";
    private   String STATUS="Status";
    private   String CONTENT_TYPE="Content-Type";
    private   String CONTENT_LENGTH="Content-Length";
    private   String LAST_MODIFIED="Last-Modified";
    private   String CONNECTION="Connection";
    private   String ACCEPT_RANGES="Accept-Ranges";
    private Map<String, String> header;
    private OutputStream outputStream;

    /**
     *Contructor for create the holder of output data
     */
    public ResponseImpl(OutputStream output) {
        this.outputStream = output;
        this.header = new Hashtable<>();
    }

    /**
     *retrieve the output holder for communication context purpose
     */
    @Override
    public OutputStream getOutputStream() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[]holder = this.toString().getBytes();

        this.outputStream = out;

        return out;
    }

    /**
     * getHeaderToString converts the header to String, for logs effects
     *
     * */
    @Override
    public String toString() {

        String headerString = "";
        for(Map.Entry m:header.entrySet()){
            headerString += m.getKey() + ": " +m.getValue() + System.lineSeparator();
        }
        return headerString;
    }
    @Override
    public void setURL(String URL) {
        this.URL = URL;
    }
    @Override
    public void setMETHOD(String METHOD) {
        this.METHOD = METHOD;
    }
    @Override
    public void setHTTP_VERSION(String HTTP_VERSION) {
        this.HTTP_VERSION = HTTP_VERSION;
    }
    @Override
    public void setSERVER(String SERVER) {
        this.SERVER = SERVER;
    }
    @Override
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    @Override
    public void setCONTENT_TYPE(String CONTENT_TYPE) {
        this.CONTENT_TYPE = CONTENT_TYPE;
    }
    @Override
    public void setCONTENT_LENGTH(String CONTENT_LENGTH) {
        this.CONTENT_LENGTH = CONTENT_LENGTH;
    }
    @Override
    public void setLAST_MODIFIED(String LAST_MODIFIED) {
        this.LAST_MODIFIED = LAST_MODIFIED;
    }
    @Override
    public void setCONNECTION(String CONNECTION) {
        this.CONNECTION = CONNECTION;
    }
    @Override
    public void setACCEPT_RANGES(String ACCEPT_RANGES) {
        this.ACCEPT_RANGES = ACCEPT_RANGES;
    }
}
