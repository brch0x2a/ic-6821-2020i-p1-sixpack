/***
  * The MethodFactoryMethod class is the implementation of the "Factory Method" design pattern,
  * its concrete classes implement a specific type of object.
 */
public interface MethodFactoryMethod {
    MethodProcessor create(Request request, Response response);
}
