package tariq.abdulghani.hello.todo;

import javax.batch.api.BatchProperty;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    @EJB
    TodoRepository todoRepository;

    @GET
    public List<Todo> getALl(){
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

    @DELETE
    public  Todo delete(Todo todo){
        return todoRepository.delete(todo);
    }
}
