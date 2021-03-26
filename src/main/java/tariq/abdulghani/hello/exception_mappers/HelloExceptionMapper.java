package tariq.abdulghani.hello.exception_mappers;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Provider
public class HelloExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        if (exception instanceof ConstraintViolationException) {
            Map<String, Object> violations = new HashMap<>();
            ConstraintViolationException violationException = exception;
            Set<ConstraintViolation<?>> violationSet = violationException.getConstraintViolations();
            violationSet.forEach(cv -> {
                violations.put("message", cv.getMessage());
                violations.put("path", cv.getPropertyPath().toString());
                violations.put("value", cv.getInvalidValue());
            });
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getCause()).build();
    }
}
