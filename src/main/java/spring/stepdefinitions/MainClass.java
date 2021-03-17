package spring.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
        @PropertySource("classpath:configuration.properties")
//        ,@PropertySource("classpath:bar.properties")
})
public class MainClass {

    @Value("${jdbc.url}" )
    private String jdbc;

    @Value("${testing}")
    private String testing;


    @Autowired
    private Environment environment;

    public String test(){
        return this.jdbc;
    }

    public String conf() {
        return this.testing;
    }
}
