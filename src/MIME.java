/**
 * The abstract MIME class is responsible for defining the methods of the
 * concrete MIMEImpl class. It consists of three methods: getInstance,
 * setPath and getMIME. These methods are explained in detail in the MIMEImpl
 * class documentation, as they are overwritten in this specific class
 */

public abstract class MIME {

    public static MIMEImpl getInstance() {
        return MIMEImpl.getInstance();
    }

    public abstract void setPath(String path);

    public abstract String getMIME(String resourceName);
}
