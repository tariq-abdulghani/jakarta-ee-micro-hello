package tariq.abdulghani.hello.Greetings;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greetings")
public class GreetingsResource {
    @Inject
    @Morning
    SayHello morningGreetings;

    @Inject
    @Evening
    SayHello eveningGreetings;

    @Path("morning")
    @GET
    public String sayGoodMorning(){
        return morningGreetings.sayHello();
    }

    @Path("evening")
    @GET
    public String sayGoodEvening(){
        return eveningGreetings.sayHello();
    }
}
