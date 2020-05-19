package com.company;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * The abstract class RequestImpl has as main objective store all data sent by the client though
 * the socket, this data it is converted to manageable properties that the rest of the system can
 * understand.
 */

public class RequestImpl implements Request{
    private String method;
    private String url;
    private String httpVersion;
    private Hashtable<String,String> header;
    private InputStream inputStream;

    public RequestImpl(InputStream input) {
        this.inputStream = input;
        this.header = new Hashtable<>();
        String inputConverted = inputStreamToString();
        separateComponents(inputConverted);
    }

    /**
     * inputStreamToString converts the inputStream to String,
     * allowing the identification of what exactly wants the client.
     */
    private String inputStreamToString() {
        String text;
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        }
        return text;
    }

    /**
     * separateComponents will assign the value of each attribute for RequestImpl,
     * splitting the information inside the InputStream.
     */
    private void separateComponents(String input){
        String[] lines = input.split("\\r?\\n");
        String[] words = lines[0].split("\\s+");

        method = words[0];
        url = words[1];
        httpVersion = words[2];

        header.put("Method", method);
        header.put("URL", url);
        header.put("HttpVersion", httpVersion);

        for(int i = 1; i < lines.length; i++){
            String[] data = lines[i].split(": ");
            header.put(data[0],data[1]);
        }
    }

    /**
     * Gets of the class, there are not need to create sets since it's not part of the scope.
     */
    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public String getHttpVersion() {
        return httpVersion;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Hashtable<String, String> getHeader() {
        return header;
    }

    /**
     * getHeaderString as his name said returns all the content inside the header hashtable
     * in a format of string to facilitate the creation of logs.
     */
    @Override
    public String getHeaderString() {
        String headerString = "";
        for(Map.Entry m:header.entrySet()){
            headerString += m.getKey() + ": " +m.getValue() + System.lineSeparator();
        }
        return headerString;
    }
}
