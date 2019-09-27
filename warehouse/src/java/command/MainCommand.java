package java.command;

import dao.DAOFactory;
import dao.FlowerDAO;
import entitiy.Flower;
import entitiy.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class MainCommand implements Command {

    public String execute(HttpServletRequest request) {
        DAOFactory factory = DAOFactory.getInstance();
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            request.setAttribute("bunches", bunches);
        } else {
            FlowerDAO flowerDAO = factory.getFlowerDAO();
            List<Flower> flowers = flowerDAO.getAll();
            request.setAttribute("flowers", flowers);
        }

        return "main.jsp";
    }

}
