/***
 * This class is part of the Factory Method design pattern, it's the GET method factory.
 * It knows how to instantiate the GETMethodProcessor class.
 */
public class GETMethodProcessorFactoryMethod implements MethodFactoryMethod {
    /***
     *Implementation of the create method that returns a MethodProcessor type for the GET method
     */
    @Override
    public MethodProcessor create(Request request, Response response) {
        return new GETMethodProcessor(request, response);
    }
}
