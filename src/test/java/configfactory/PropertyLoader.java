package configfactory;

import java.util.Properties;

public class PropertyLoader
{
   private  Properties properties;
    String dir = System.getProperty("user.dir");
    public PropertyLoader(String propertyFinalName) {

        String filePath = dir + "\\src\\test\\resources\\config\\" + propertyFinalName;
        properties = PropertyUtils.propertyLoader(filePath);
    }

    public String getQABaseUrl(){
        return properties.getProperty("baseQAURL");
    }
    public String getProdBaseUrl(){
        return properties.getProperty("baseProdURL");
    }

    public String getRemoteRun(){
        return properties.getProperty("remote");
    }
    public String getEnv(){
        return properties.getProperty("Env");
    }

}
