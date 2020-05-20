import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The MIMEImpl class inherits from the MIME abstract class.
 * It consists of three public and two private methods.
 * The MIMEImpl class is responsible for reading the text file that contains the MIME types.
 * This file is configurable and can to be edited as needed.
 * The MIMEImpl class receives the path of the file from which we want
 * to know its MIME type and returns a text string with that data.
 * The MIMEImple class follows the Singleton pattern, so that only one instance of it can exist.
 */

public class MIMEImpl extends MIME{

    private static MIMEImpl mimeImpl;
    private String path;
    private String resourceName;
    private String extensionFile;

    /**
     * The getInstance method is responsible for returning the
     * MIMEImpl object instance following the Singleton pattern
     */

    public static MIMEImpl getInstance() {
        if (mimeImpl == null)
            mimeImpl = new MIMEImpl();
        return mimeImpl;
    }

    /**
     * Overwritten method of the MIME class in charge of registering
     * the path of the file of which we want to know its MIME type.
     * It receives as parameter the path of the file.
     */

    @Override
    public void setPath (String path) {
        this.path = path;
        extensionFile = getExtension(path);
        System.out.println("The extension file is: " + "\"" + extensionFile + "\"");
    }

    /**
     * Overridden method of the MIME class responsible for returning the MIME
     * type of the file that was received as a parameter in the setPath method.
     * It receives as parameter the path of the file.
     */

    @Override
    public String getMIME (String resourceName) {
        this.resourceName = resourceName;
        String mimetype = findMIME(extensionFile, resourceName);
        return mimetype;
    }

    /**
     * The getExtesion method is responsible for returning a text string with the file extension.
     * It receives as parameter the file path of which we want to know the extension.
     */

    private String getExtension (String path) {
        int index = path.lastIndexOf('.');
        if (index == -1) {
            return "";
        } else return path.substring(index + 1);
    }

    /**
     * The findMIME method is responsible for returning a text string with the MIME type.
     * It receives two parameters: the file extension and the file path containing all MIME types.
     */

    private String findMIME (String fileExtension, String resourceName) {
        File file = new File (resourceName);
        Scanner scanner;
        String mimetype = "No MIME Type";

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int index = line.lastIndexOf(';');
                String extension = line.substring(0, index);
                String mime = line.substring(index + 1);
                if (extension.equals(fileExtension)) mimetype = mime;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return mimetype;
    }
}