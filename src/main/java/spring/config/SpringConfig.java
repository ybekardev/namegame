package spring.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
//https://www.baeldung.com/properties-with-spring
@PropertySources({
        @PropertySource("configuration.properties"),
        @PropertySource(value = "environment/application-${spring.profiles.active}.properties",ignoreResourceNotFound = true)
})
//@Import({src.main.java.spring.config.SpringConfig.java}) if adding any jar files to utilize the config prop
public class SpringConfig {

}
