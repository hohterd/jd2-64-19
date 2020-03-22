package spring.boot.homework.service.spring_hibernate;

import java.io.Serializable;

public interface Service<E> {

    E add(E e);
    E update (E e);
    E get(Serializable id);
    void remove(Serializable id);

}
