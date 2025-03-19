package cipher.controllers;

import cipher.commands.Action;
import cipher.commands.BruteForce;
import cipher.commands.Decoder;
import cipher.commands.Encoder;
import cipher.exeptions.AppException;

public enum Actions {
    ENCODE(new Encoder()), 
    DECODE(new Decoder()),
    BRUTE_FORCE(new BruteForce());
    
    private final Action action;

    Actions(Action action) {
        this.action = action;
    }
    
    public static Action find(String actionName) {
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e) {
            throw new AppException("not found " + actionName, e);
        }
    }
}
