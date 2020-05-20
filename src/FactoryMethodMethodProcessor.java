import java.util.HashMap;

/**
 * The FactoryMethodMethodProcessor class is a implementation of the "Singleton" design pattern,
 * this pattern is used to generate a unique instance of this class.
 * This class has a hashmap that contains the factories (one factory for each method).
 */
public class FactoryMethodMethodProcessor {
    public static FactoryMethodMethodProcessor instance = null;
    private HashMap<String, MethodFactoryMethod> factories = new HashMap<>();

    public static FactoryMethodMethodProcessor getInstance() {
        if (instance == null) {
            instance = new FactoryMethodMethodProcessor();
        }
        return instance;
    }

    /***
     * If the method does not exist in the factory, a specific exception is created
     * to return it to the Thread and it will process the error(501 Not Implemented)
     */
    public MethodProcessor create(Request request,Response response) throws Exception {
        MethodFactoryMethod factoryMethod = factories.get(request.getMethod());
        if (factoryMethod == null) {

            throw new Exception("501 Not Implemented");
        }
        return factoryMethod.create(request, response);
    }

    /***
     *A new type of method is registered in the HashMap factories
     */
    public void register(String factory, MethodFactoryMethod factoryMethod){

        factories.put(factory, factoryMethod);
    }
}


