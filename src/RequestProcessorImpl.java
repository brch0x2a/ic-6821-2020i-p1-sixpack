/**
 * This class is in charge of sending to process the user's request and sending to verify the mime type.
 */
public class RequestProcessorImpl implements RequestProcessor{

    /**
     *
     * @param request
     * @param response
     *
     * The process method receives the request and response instances.
     * It uses the MIME module to verify if the archive requested has an
     * associated MIME type.
     *
     * When the verification was made, the method sends the request to be
     * processed by the rest of the program.
     */
    @Override
    public void process(Request request, Response response) {

        MIME mime = new MIME.getInstance();
        String mimeType = mime.getMIME(request.getUrl());
        response.setContentType(mimeType);

        MethodProcessor methodProcessor = FactoryMethodMethodProcessor.getInstance().create(request, response);


    }
}
