package by.it.academy.foodorder.listener;


import by.it.academy.foodorder.db.connection.pool.FoodOrderDataSource;
import by.it.academy.foodorder.db.migration.DbMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.util.ResourceBundle;

@WebListener()
public class ContextInitListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ContextInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Context initialized");
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("mysql_hikari");
            FoodOrderDataSource.configure(bundle);
            DataSource dataSource = FoodOrderDataSource.getDataSource();
            DbMigration.migrate(dataSource);
        } catch (Exception e) {
            logger.error("error", e);
            throw new RuntimeException("Datasource initialisation error", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroyed");
    }
}
