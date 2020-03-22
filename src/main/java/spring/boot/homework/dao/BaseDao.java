package spring.boot.homework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Component
public abstract class BaseDao<T> implements DAO<T> {

    private final Class<T> clazz;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EntityManagerFactory factory;

    protected BaseDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T create(T t) {
        getEm().persist(t);
        return t;
    }

    @Override
    public T read(Serializable id) {
        return getEm().find(clazz, id);
    }

    @Override
    public T update(T t) {
        getEm().merge(t);
        return t;
    }

    @Override
    public void delete(Serializable id) {
        getEm().remove(id);
    }

    public EntityManager getEm() {
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

}
