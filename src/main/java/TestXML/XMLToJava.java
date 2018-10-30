package TestXML;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class XMLToJava {
    public static final String path = "test_mybox.xml";

    public static void main(String[] args) {
        File file = new File(path);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String xml = StreamToString(fileInputStream);
            MyBox value = xmlMapper.readValue(xml, MyBox.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String StreamToString(InputStream stream) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
