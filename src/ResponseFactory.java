package com.company;

import java.io.OutputStream;


/*
    Factory Pattern for retrieve the Response Object for handle the output data
 */

public class ResponseFactory {
    public static Response getResponse(OutputStream output){

        return new ResponseImpl(output);

    }

}
