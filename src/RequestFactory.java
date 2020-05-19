package com.company;

import java.io.IOException;
import java.io.InputStream;

/**
 * The abstract class RequestFactory is the implementation of the design pattern "Factory",
 * it is used to generate instances of RequestImpl and use them though the
 * contract Request.
 */
public class RequestFactory {
    public static Request getInstance(InputStream input) throws IOException {
        if (input.available() > 0) {
            return new RequestImpl(input);
        } else {
            throw new IllegalArgumentException("There are not bytes to read");
        }
    }
}
