package cipher.controllers;

import cipher.commands.Action;
import cipher.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }

}
