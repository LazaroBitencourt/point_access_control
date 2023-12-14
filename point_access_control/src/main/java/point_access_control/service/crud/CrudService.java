package point_access_control.service.crud;

public interface CrudService<T, ID> {

    public T create(T entity);

    public Iterable<T> findAll();

    public T findById(ID id);

    public T update(ID id, T entity);

    public void delete(ID id);
}
