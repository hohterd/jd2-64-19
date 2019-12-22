package by.it.academy.foodorder.servlet;

import by.it.academy.project.service.FoodService;
import by.it.academy.project.service.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removeFood")
public class FoodRemoveServlet extends HttpServlet {

    private FoodService foodService = FoodServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        removeFood(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        removeFood(req, resp);
    }

    private void removeFood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        foodService.removeDish(id);
        resp.sendRedirect(req.getContextPath() + "/foodList");
    }
}

