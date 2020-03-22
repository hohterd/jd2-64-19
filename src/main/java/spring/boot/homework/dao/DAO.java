package spring.boot.homework.dao;

import java.io.Serializable;

public interface DAO<E> {

    E create(E e);
    E read(Serializable id);
    E update(E e);
    void delete(Serializable id);

}
