package configfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

        public static Properties propertyLoader(String propertyFilePath) {
        FileInputStream fis;
        Properties property = null;

        try {

            fis = new FileInputStream(propertyFilePath);
            property = new Properties();
            property.load(fis);

        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error while reading the File");
            e.printStackTrace();
        }
        return property;
    }


}
