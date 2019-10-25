package octavian.xmltech.validator;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;

public class ResourceReader {
    public String getResource(String filename) throws FileNotFoundException {
        URL resource = getClass().getClassLoader().getResource(filename);
        Objects.requireNonNull(resource);

        return resource.getFile();
    }
}
