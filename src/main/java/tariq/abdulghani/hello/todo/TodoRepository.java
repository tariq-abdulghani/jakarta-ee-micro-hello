package tariq.abdulghani.hello.todo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TodoRepository {

    @Inject
    TodoDAO todoDAO;

    public List<Todo> getAll(){
        return todoDAO.getAll();
    }

    public Todo getById(Long id){
        return todoDAO.getById(id);
    }

    public Todo create(Todo todo){
        return todoDAO.create(todo);
    }

    public Todo update(Todo todo){
        return todoDAO.update(todo);
    }

    public Todo delete(Todo todo){
        return todoDAO.delete(todo);
    }
}
