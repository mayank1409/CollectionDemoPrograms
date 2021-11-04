package io.javamasters.employeescrud.service.base;

import io.javamasters.employeescrud.exceptions.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, ID> implements IGenericService<T, ID> {

    protected abstract JpaRepository<T, ID> repository();

    @Override
    @Transactional
    public T save(T t) {
        return repository().save(t);
    }

    @Override
    @Transactional
    public T update(T t, ID id) {
        get(id);
        return repository().save(t);
    }

    @Override
    public T get(ID id) {
        Optional<T> optional = repository().findById(id);
        if (optional.isEmpty()) {
            throw new EntityNotFoundException("Entity not found");
        }
        return optional.get();
    }

    @Override
    public List<T> list() {
        return repository().findAll();
    }

    @Override
    @Transactional
    public void delete(ID id) {
        T t = get(id);
        repository().delete(t);
    }
}
