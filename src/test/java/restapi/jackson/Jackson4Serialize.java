package restapi.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.C;

public class Jackson4Serialize {
    public static void main(String[] args) throws JsonProcessingException {
        Car car = new Car();
        car.setMake("RR");
        car.setModel("Phantom");
        car.setYear(2023);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(car);
        System.out.println(json);
        System.out.println(json.length());

        System.out.println("===========================================");

        String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        System.out.println(jsonPretty);
        System.out.println(jsonPretty.length());
    }
}
class Car{
    private String make;
    private String model;
    private int year;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
