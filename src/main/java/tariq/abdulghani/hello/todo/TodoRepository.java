package tariq.abdulghani.hello.todo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Stateless
public class TodoRepository {

    @PersistenceContext(unitName = "PU")
    EntityManager em;

    public List<Todo> getAll(){
        return em.createQuery("select t from Todo t").getResultList();
    }
}
