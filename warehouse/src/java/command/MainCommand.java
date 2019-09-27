package java.command;

import dao.BunchDAO;
import dao.DAOFactory;
import dao.FlowerDAO;
import entitiy.Bunch;
import entitiy.Flower;
import entitiy.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class MainCommand implements Command {

    public String execute(HttpServletRequest request) {
        DAOFactory factory = DAOFactory.getInstance();
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            BunchDAO bunchDAO = factory.getBunchDAO();
            List<Bunch> bunches = bunchDAO.getAllBunches(user);
            request.setAttribute("bunches", bunches);
        } else {
            FlowerDAO flowerDAO = factory.getFlowerDAO();
            List<Flower> flowers = flowerDAO.getAll();
            request.setAttribute("flowers", flowers);
        }

        return "main.jsp";
    }

}
