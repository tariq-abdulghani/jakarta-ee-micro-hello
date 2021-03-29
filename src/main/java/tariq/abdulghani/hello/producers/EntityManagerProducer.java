package tariq.abdulghani.hello.producers;

import javax.enterprise.inject.Produces;

import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EntityManagerProducer {
    @PersistenceContext(unitName = "PU")
    EntityManager em;

    @Produces
    public EntityManager produceEntityManager(InjectionPoint injectionPoint){
        return em;
    }
}
