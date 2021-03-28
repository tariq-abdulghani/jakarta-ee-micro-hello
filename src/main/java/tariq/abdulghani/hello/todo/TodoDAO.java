package tariq.abdulghani.hello.todo;

import tariq.abdulghani.hello.qualifiers.TodoDAOType;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

//@Dependent
//@TodoDAOType
//@Transactional
@Stateless(name = "TodoDAO")
public class TodoDAO implements CrudService<Todo> {

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
            return foundTodo;
    }

    @Override
    public Todo create(Todo entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Todo update(Todo entity) {

        Todo foundTodo = getById(entity.getId());
        if (entity.completed) {
            // not null and completed
            foundTodo.setCompleted(true);
            foundTodo.setCompleted_at(new Date());
        } else if (!entity.completed) {
            // not null not completed
            foundTodo.setCompleted(false);
            foundTodo.setCompleted_at(null);
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
    public Todo deleteById(Long id) {
        Todo foundTodo  = getById(id);
        em.remove(foundTodo);
        return foundTodo;
    }
}
