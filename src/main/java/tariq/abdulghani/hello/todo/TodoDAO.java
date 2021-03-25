package tariq.abdulghani.hello.todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class TodoDAO implements  CrudDAO<Todo>{

    @PersistenceContext(unitName = "PU")
    EntityManager em;

    @Override
    public List<Todo> getAll() {
        return em.createQuery("select t from Todo t").getResultList();
    }

    @Override
    public Todo getById(Long id) {
        return em.createQuery("select t from Todo t where t.id = :pId", Todo.class).setParameter("pId", id).getSingleResult();
    }

    @Override
    public Todo create(Todo entity) {
        em.persist(entity );
        return entity;
    }

    @Override
    public Todo update(Todo entity) {

        Todo foundTodo = getById(entity.getId() );
        if(foundTodo != null && entity.completed){
            foundTodo.setCompleted(true);
            foundTodo.setCompleted_at(new Date());
        }else if(foundTodo == null){
            return null;
        }
    }

    @Override
    public Todo delete(Todo entity) {
        em.remove(entity);
        return entity ;
    }

    @Override
    public Todo deleteById(Todo entity) {
        return null;
    }
}
