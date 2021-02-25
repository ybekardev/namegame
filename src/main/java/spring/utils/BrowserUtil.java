package spring.utils;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void waitPlease(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
