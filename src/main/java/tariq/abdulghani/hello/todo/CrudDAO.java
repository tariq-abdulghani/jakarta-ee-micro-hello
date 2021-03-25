package tariq.abdulghani.hello.todo;

import java.util.List;

public interface CrudDAO<T>{

    List<T> getAll();
    T getById(Long id);
    T create(T entity);
    T update(T entity);
    T delete(T entity);
    T deleteById(T entity);
}
