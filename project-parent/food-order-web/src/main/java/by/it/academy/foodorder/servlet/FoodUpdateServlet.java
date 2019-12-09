package by.it.academy.foodorder.servlet;

import by.it.academy.foodorder.food.Food;
import by.it.academy.foodorder.service.FoodService;
import by.it.academy.foodorder.service.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateFood")
public class FoodUpdateServlet extends HttpServlet {

    private FoodService foodService = FoodServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/foodCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String ingredients = req.getParameter("ingredients");
        String discount = req.getParameter("discount");
        String weight = req.getParameter("weight");
        String cookingTime = req.getParameter("cookingTime");
        boolean delivery = req.getParameter("delivery") != null;

        Food food = new Food(Long.valueOf(id), name, Long.valueOf(price), ingredients, Long.valueOf(discount), Long.valueOf(weight),
                Long.valueOf(cookingTime), delivery);

        foodService.updateDish(food);

        resp.sendRedirect(req.getContextPath() + "/foodList");
    }
}
