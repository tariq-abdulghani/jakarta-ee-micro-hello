package tariq.abdulghani.hello.todo;

import tariq.abdulghani.hello.qualifiers.TodoDAOType;
import tariq.abdulghani.hello.qualifiers.TodoRepositoryType;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

//@RequestScoped
//@TodoRepositoryType
@Stateless(name = "TodoRepository")
public class TodoRepository implements CrudService<Todo>{

    @EJB(beanName = "TodoDAO")
//    @TodoDAOType
    CrudService<Todo> todoDAO;

    @Override
    public List<Todo> getAll(){
        return todoDAO.getAll();
    }

    @Override
    public Todo getById(Long id){
        return todoDAO.getById(id);
    }

    @Override
    public Todo create(Todo todo){
        return todoDAO.create(todo);
    }

    @Override
    public Todo update(Todo todo){
        return todoDAO.update(todo);
    }

    @Override
    public Todo delete(Todo todo){
        return todoDAO.delete(todo);
    }

    @Override
    public Todo deleteById(Long id){
        return todoDAO.deleteById(id);
    }
}
