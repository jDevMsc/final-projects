package java.command;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


public class CommandFactory {

    private static CommandFactory factory = new CommandFactory();

    private Map<String, Command> comands = new HashMap<String, Command>();

    private CommandFactory() {

    }

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        comands.put("register", new RegisterCommand());
        comands.put("logout", new LogoutCommand());
        comands.put("main", new MainCommand());
        comands.put("login", new LoginCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        Command command = comands.get(action);
        return command;
    }

}
