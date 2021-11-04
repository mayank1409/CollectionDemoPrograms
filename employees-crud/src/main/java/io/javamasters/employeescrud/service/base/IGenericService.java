package io.javamasters.employeescrud.service.base;

import java.util.List;

public interface IGenericService<T, ID> {
    public T save(T t);

    public T update(T t, ID id);

    public T get(ID id);

    public List<T> list();

    public void delete(ID id);
}
