package by.it.academy.foodorder.servlet;

import by.it.academy.foodorder.models.Food;
import by.it.academy.foodorder.service.FoodService;
import by.it.academy.foodorder.service.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/foodList")
public class FoodListServlet extends HttpServlet {

    private FoodService foodService = FoodServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> allDishes = foodService.getAllDishes();
        req.setAttribute("foodList", allDishes);
        req.getRequestDispatcher("/WEB-INF/jsp-services/foodList.jsp").forward(req, resp);
    }

}
