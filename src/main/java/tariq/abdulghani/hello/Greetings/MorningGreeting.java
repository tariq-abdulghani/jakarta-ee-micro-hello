package tariq.abdulghani.hello.Greetings;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@Morning
public class MorningGreeting implements SayHello{
    @Override
    public String sayHello() {
        return "good morning";
    }
}
