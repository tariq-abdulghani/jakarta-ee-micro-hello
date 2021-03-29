# MicroProfile is a set of specs that are used for microservices

## Introduction
Many microprofile application servers exists, and I used payara-micro for this demo
u need to download payara-micro
and mysql connector and put it in libs dir
I used postboot file that configures data source for our app.

to build the project use
    mvn clean package

This will create a war file  This can be started by executing the following command

     java -jar path_to_payara-micro/payara-micro-5.2021.1.jar ./target/hello-jakarta-micro.war  --postbootcommandfile ./initializer/postboot --addlibs ./libs --port 7777



To launch the test page, open your browser at the following URL

    http://localhost:7777/index.html  



## Specification examples

### CDI
* type safe DI, sterio types, qualifiers


injection is achieved by type not concrete class so to inject a bean
  use an interface tha it implements.
  if multiple beans implement the same interface use
  qualifiers in case of CDI beans 
  or use in case of EJB
  `@Local public interface YourInterface{...}`.
  `@Statleass(name="name")`  specify bean name used to recognize it by container
  `@EJB(beanName="name")` use the name to inject it
  
* **life cycle - contexts - scopes - contextual instance** <br>
  **scope** : determines the lif time of an object and the visibility of it.
  each scope is associated with a context.<br>
  **context**: is an object that represents the scope as impl.<br>
  responsible for creating and destroying objects in this scope(context).<br>
  **contextual instances**:<br>
  are just objects being managed by contexts.
  
  **CDI scopes:**
  * dependent
  * request
  * session
  * application
  * conversation
  <br>
    
  **CDI managed bean life cycle:**
  * `@PostCounstruct`
  * `@PreDestroy`
  
* interceptors
* events
* service providers:<br>
    is used to provide other classes that are not beans to be injected
    like loggers, and other utils.

```java
import javax.enterprise.context.RequestScoped;

public class LoggerProducer {
  @Produces
  @RequestScoped // scope of produced class
  public Logger produceLogger(InjectionPoint injectionPoint) {
    return Logger.getLogger(injectionPoint.getMember().getClass().getName());
  }
}
```

```java
@SessionScoped
public class Preferences implements Serializable {
    
  private PaymentStrategyType paymentStrategy;
  // producer
  @Produces
  @Preferred
  @SessionScoped
  // @New makes injection of params managed by DCI so life cycle and other features 
  // can be used when injecting params.
  public PaymentStrategy getPaymentStrategy(@New CreditCardPaymentStrategy ccps,
                                            @New CheckPaymentStrategy cps,
                                            @New PayPalPaymentStrategy ppps) {
    switch (paymentStrategy) {
      case CREDIT_CARD:
        return ccps;
      case CHEQUE:
        return cps;
      case PAYPAL:
        return ppps;
      default:
        return null;
    }
  }
    // disposer
  void close(@Disposes PaymentStrategy paymentStrategy) {
    // clean resources
  }
}
```


### JAX-RS
By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.
Also, a simple todo endpoint is created.

### JPA








