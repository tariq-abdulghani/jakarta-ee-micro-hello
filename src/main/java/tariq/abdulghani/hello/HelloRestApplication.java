package tariq.abdulghani.hello;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/api/v1")
@ApplicationScoped
public class HelloRestApplication extends Application {
}
