package inout;

import java.util.Enumeration;
import java.util.Properties;


public class PropertiesAusgeben {
    
    private Properties properties = new Properties();
    
    public PropertiesAusgeben(){
        properties.put("1", "eins");
        properties.put("2", "zwei");
    }

    public void writeProperties(Properties properties){
        Enumeration<?> enu = properties.propertyNames();
        while(enu.hasMoreElements()){
            String key = (String) enu.nextElement();
            System.out.println(key + ": " + properties.getProperty(key));
        }
    }
    
    private Properties getProperties(){
        return properties;
    }
    
    public static void main(String[] args) {
        PropertiesAusgeben pa = new PropertiesAusgeben();
        pa.writeProperties(pa.getProperties());

    }
} 