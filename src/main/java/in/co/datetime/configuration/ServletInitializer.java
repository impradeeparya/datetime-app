package in.co.datetime.configuration;

import in.co.datetime.DatetimeAppApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * datetime-app
 * Created by pradeep.
 * On 31/1/17 1:33 AM
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DatetimeAppApplication.class);
    }
}
