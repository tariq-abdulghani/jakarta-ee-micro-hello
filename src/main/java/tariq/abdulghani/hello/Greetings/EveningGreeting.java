package tariq.abdulghani.hello.Greetings;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@Evening
public class EveningGreeting implements SayHello{
    @Override
    public String sayHello() {
        return "good evening";
    }
}
