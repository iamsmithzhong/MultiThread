package testonly;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
 
public class JsonJacksonObjectMappingDemo {
 
    public static void main(String args[]){
         
        CarFleet carFleet = getCarFleet();
         
        ObjectMapper mapper = new ObjectMapper();
 
        /**
         * Write object to file
         */
        try {
            mapper.writeValue(new File("result.json"), carFleet);//Plain JSON
            //mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, carFleet);//Prettified JSON
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CarFleet value = null;
        try {
            value = mapper.readValue(new File("result.json"), CarFleet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }   
         
        System.out.println(value);
 
    }
     
    private static CarFleet getCarFleet(){
        Car car1 = new Car();
        car1.setName("Audi");
        car1.setModel("2010");
        car1.setCost(30000);
         
 
        CarEngine engine1 = new CarEngine();
        engine1.setPower("88KWH");
        engine1.setType("Diesel");
        car1.setEngine(engine1);
         
        Car car2 = new Car();
        car2.setName("Jaguar");
        car2.setModel("2013");
        car2.setCost(60000);
 
        CarEngine engine2 = new CarEngine();
        engine2.setPower("120KWH");
        engine2.setType("Diesel");
        car2.setEngine(engine2);
         
        List<String> colors = new ArrayList<String>();
        colors.add("Grey");
        colors.add("white");
        car1.setColors(colors);
        car2.setColors(colors);
         
        CarFleet carFleet = new CarFleet();
        carFleet.getCars().add(car1);
        carFleet.getCars().add(car2);
 
        return carFleet;
    }
}
