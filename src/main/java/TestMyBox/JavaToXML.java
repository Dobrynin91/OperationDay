package TestMyBox;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JavaToXML {
    public static String path = "cars.xml";

    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(path);
        try {
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, new Cars());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
