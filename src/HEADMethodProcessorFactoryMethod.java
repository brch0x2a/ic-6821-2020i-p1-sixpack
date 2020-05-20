/***
 * This class is part of the Factory Method design pattern, it's the HEAD method factory.
 * It knows how to instantiate the HEADMethodProcessor class.
 */
public class HEADMethodProcessorFactoryMethod implements MethodFactoryMethod{
    /***
     *Implementation of the create method that returns a MethodProcessor type for the HEAD method
     */
    @Override
    public MethodProcessor create(Request request, Response response) {
        return new HEADMethodProcessor(request, response);
    }
}
