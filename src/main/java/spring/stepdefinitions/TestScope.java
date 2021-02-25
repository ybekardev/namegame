package spring.stepdefinitions;

import com.google.gson.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestScope {

    private static volatile TestScope instance = null;
    public static Response response;

    private TestScope(){ }

    public static synchronized Response getInstance(Response apiResponse){ //if you add sync in the method name it will be thread-safe
        if(response == null){
            //lazy instantiating
            //the singleton instance is not created until the getInstance method is called for the first time.
            // This technique ensures that singleton instances are created only when needed.
            synchronized (TestScope.class){
                //first instantiation is null and the object will be created once and it will not be kept as null
                // next time and the same object/value will be used in the other calls
                if(response == null) {
                    instance = new TestScope();
                    response = apiResponse;
                    System.out.println(response.getBody().asString());
                }
            }
        }
        return response;
    }

    public static Response getNullInstance(Response apiResponse){ //if you add sync in the method name it will be thread-safe
            instance= null;
            instance = new TestScope();
        System.out.println("*****");
        //System.gc();
        System.out.println(response.getBody().asString());

        return response;
    }

    public static String jsonStringParser(Response response){
        String resp = response.getBody().asString();
        System.out.println(resp);
        JsonPath jsonPath = new JsonPath(resp);
        String jsonValue=  jsonPath.get("data[0].employee_name");
        return jsonValue;
    }

}
