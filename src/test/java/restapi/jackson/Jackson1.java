package restapi.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"name\" : \"Elon\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        //read value is the method used to deserialize json into java object
        //Generics are dynamic return types of methods.
        Employee obj1 = objectMapper.readValue(json, Employee.class);

        System.out.println(obj1);
    }
}

class Employee{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}