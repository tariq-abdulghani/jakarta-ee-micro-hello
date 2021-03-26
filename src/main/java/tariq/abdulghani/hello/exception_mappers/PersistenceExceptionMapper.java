package tariq.abdulghani.hello.exception_mappers;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersistenceExceptionMapper implements ExceptionMapper<PersistenceException> {
    @Override
    public Response toResponse(PersistenceException exception) {
        if(exception instanceof NoResultException){
            return Response.status(Response.Status.NOT_FOUND).entity("entity not found").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
