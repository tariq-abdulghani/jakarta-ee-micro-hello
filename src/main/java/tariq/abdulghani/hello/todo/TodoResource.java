package tariq.abdulghani.hello.todo;

import tariq.abdulghani.hello.qualifiers.TodoRepositoryType;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    @Inject
    Logger logger;

    @EJB(beanName = "TodoRepository")
//    @Inject
//    @TodoRepositoryType
    CrudService<Todo> todoRepository;

    @GET
    public List<Todo> getALl(){
        logger.log(Level.INFO, "###################################################");
        logger.log(Level.INFO, "get all todos ....... injection works fine");
        logger.log(Level.INFO, "###################################################");
        return todoRepository.getAll();
    }

    @GET
    @Path("{id}")
    public Todo getALl(@PathParam("id") Long id){
        return todoRepository.getById(id);
    }

    @POST
    public  Todo create(Todo todo){
        return todoRepository.create(todo);
    }

    @PUT
    public  Todo update(Todo todo){
        return todoRepository.update(todo);
    }

    @DELETE
    public  Todo delete(Todo todo){
        return todoRepository.delete(todo);
    }

    @Path("{id}")
    @DELETE
    public  Todo deleteById(@PathParam("id") Long id){
        return todoRepository.deleteById(id);
    }
}
