package by.it.academy.foodorder.tags;

import by.it.academy.project.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

public class AuthTag extends ConditionalTagSupport {

    private String path = "";

    @Override
    protected boolean condition() {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        return user != null && user.getRole().equals("admin");
    }

    public void setPath(String path) {
        this.path = path;
    }
}