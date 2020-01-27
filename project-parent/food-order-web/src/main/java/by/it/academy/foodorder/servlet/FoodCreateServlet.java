package by.it.academy.foodorder.servlet;

import by.it.academy.foodorder.models.Food;
import by.it.academy.foodorder.service.FoodService;
import by.it.academy.foodorder.service.FoodServiceImpl;
import by.it.academy.foodorder.service.MenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/foodCreate")
public class FoodCreateServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodCreateServlet.class);
    private FoodService foodService = FoodServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("menuSelected", 1L);
        req.setAttribute("menu", MenuServiceImpl.getService().getAll());
        req.getRequestDispatcher("/WEB-INF/jsp-services/foodCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String menuId = req.getParameter("menuId");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String ingredients = req.getParameter("ingredients");
        String discount = req.getParameter("discount");
        String weight = req.getParameter("weight");
        String cookingTime = req.getParameter("cookingTime");
        boolean delivery = req.getParameter("delivery") != null;


        LOGGER.info("menu id: {}", menuId);
        log("menu id: " + menuId);
        Food food = new Food(null, name, Long.valueOf(price), ingredients, Long.valueOf(discount), Long.valueOf(weight),
                Long.valueOf(cookingTime), delivery);

        foodService.addNewDishes(food);

        resp.sendRedirect(req.getContextPath() + "/foodList");
    }
}
