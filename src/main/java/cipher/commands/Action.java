package cipher.commands;

import cipher.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
