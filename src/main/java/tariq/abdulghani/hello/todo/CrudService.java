package tariq.abdulghani.hello.todo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CrudService<T>{

    List<T> getAll();
    T getById(Long id);
    T create(T entity);
    T update(T entity);
    T delete(T entity);
    T deleteById(Long id);
}
