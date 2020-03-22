package spring.boot.homework.service.spring_hibernate;

import org.springframework.transaction.annotation.Transactional;
import spring.boot.homework.dao.DAO;

import java.io.Serializable;

@Transactional
public abstract class BaseService<E> implements Service<E> {

    protected DAO<E> baseDao;

    protected BaseService(DAO<E> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public E add(E e) {
        return baseDao.create(e);
    }

    @Override
    public E update(E e) {
        return baseDao.update(e);
    }

    @Override
    public E get(Serializable id) {
        return baseDao.read(id);
    }

    @Override
    public void remove(Serializable id) {
        baseDao.delete(id);
    }
}
