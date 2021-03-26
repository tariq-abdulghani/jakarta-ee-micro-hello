package tariq.abdulghani.hello.todo;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class TodoDAO implements CrudDAO<Todo> {

    @PersistenceContext(unitName = "PU")
    EntityManager em;

    @Override
    public List<Todo> getAll() {
        return em.createQuery("select t from Todo t").getResultList();
    }

    @Override
    public Todo getById(Long id) {
        Todo foundTodo = em
                .createQuery("select t from Todo t where t.id = :pId", Todo.class)
                .setParameter("pId", id)
                .getSingleResult();
        if(foundTodo == null){
            throw new EntityNotFoundException("there is no Todo with id" + id);
        }else{
            return foundTodo;
        }
    }

    @Override
    public Todo create(Todo entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Todo update(Todo entity) {

        Todo foundTodo = getById(entity.getId());

        if (foundTodo != null && entity.completed) {
            // not null and completed
            foundTodo.setCompleted(true);
            foundTodo.setCompleted_at(new Date());
        } else if (foundTodo != null && !entity.completed) {
            // not null not completed
            foundTodo.setCompleted(false);
            foundTodo.setCompleted_at(null);
        } else {
            // null with any
            throw new EntityNotFoundException("there is no todo with title " + entity.getTitle());
        }
        em.merge(foundTodo);
        return foundTodo;
    }

    @Override
    public Todo delete(Todo entity) {
        em.remove(entity);
        return entity;
    }

    @Override
    public Todo deleteById(Todo entity) {
        return null;
    }
}
