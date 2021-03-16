package spring.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
        @PropertySource("classpath:configuration.properties"),
        @PropertySource("classpath:bar.properties")
})
public class MainClass {

    @Value( "${jdbc.url}" )
    private  String jdbc;

    // https://www.techiedelight.com/read-values-from-application-properties-file-in-spring-boot/
    @Autowired
    private  Environment environment;

    public String test(){
        return environment.getProperty("jdbc.url");
    }

    public MainClass(){

    }
    public static void main(String[] args) {

        MainClass mainClass = new MainClass();
        System.out.println(mainClass.environment.getProperty("jdbc.url"));
        //System.out.println(mainClass.jdbc);
    }


}
