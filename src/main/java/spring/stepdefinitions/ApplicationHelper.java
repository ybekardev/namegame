package spring.stepdefinitions;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationHelper {

    public static Object test() throws FileNotFoundException {
        Object node = jsonParser("src/main/resources/payloads/payloadArray.json", "customer[0].fullName");
        System.out.println("Assertion is done, True, if the test is not failing!");
        assertEquals(node, "Emily Jenkins");
        return node;
    }

    public static Object jsonParser(String fileName, String jsonPath) throws FileNotFoundException {
        Gson gson = new Gson();
        Object object =gson.fromJson(new FileReader(fileName), Object.class);
        Object element = JsonPath.read(object, jsonPath);
        System.out.println("Returning json file element!");
        return element;
    }
}
