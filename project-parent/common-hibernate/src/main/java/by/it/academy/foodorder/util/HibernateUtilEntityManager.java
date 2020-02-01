package by.it.academy.foodorder.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtilEntityManager {

    private static final EntityManagerFactory MN_FACTORY;

    static {
        MN_FACTORY = Persistence.createEntityManagerFactory("by.it.academy");
    }

    public static EntityManager getEntityManager(){
        return MN_FACTORY.createEntityManager();
    }

    public static void close(){
        MN_FACTORY.close();
    }
}
