# JAVAEE
is a platform for enterprise applications (distributed systems, security, ...)
and is a set of specs 

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

  **CDI scopes**
    * dependent
    * request
    * session
    * application
    * conversation

* interceptors
* events
* service providers

### JAX-RS
By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.
Also, a simple todo endpoint is created.

### JPA








