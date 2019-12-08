package by.it.academy.foodorder.servlet;

import by.it.academy.foodorder.model.Product;
import by.it.academy.foodorder.service.ProductService;
import by.it.academy.foodorder.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {

    private ProductService productService = ProductServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> allProducts = productService.getAllProducts();
        req.setAttribute("productList", allProducts);
        req.getRequestDispatcher("/WEB-INF/productList.jsp")
                .forward(req, resp);
    }
}
